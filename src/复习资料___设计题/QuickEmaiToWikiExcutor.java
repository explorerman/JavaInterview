package 复习资料___设计题;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多线程下的生产者-消费者.
 * 生产者生产邮件.
 * 消费者将邮件拉出，并插入wiki.
 */
public class QuickEmaiToWikiExcutor {
    //消费线程 = CPU * 2
    private ThreadPoolExecutor threadPool;
    private ArticleBlockingQueue<ExchangeEmailShallowDTO> emailQueue;
    private EmailService emailService = new EmailService();

    public QuickEmaiToWikiExcutor() {
        emailQueue = new ArticleBlockingQueue<ExchangeEmailShallowDTO>();
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        threadPool = new ThreadPoolExecutor(corePoolSize, corePoolSize, 10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(2000));
    }

    public void extract() throws InterruptedException {
        System.out.println("开始。。。");
        long start = System.currentTimeMillis();
        //抽取邮件到队列
        new ExtractEmailTask().start();
        //把队列里的文章插入wiki
        insertWiki();
        long end = System.currentTimeMillis();
        double cost = (end - start) / 10000;
        System.out.println("完成整个过程，总花费" + cost + "秒");
    }

    private void insertWiki() throws InterruptedException {
        while (true) {
            //登陆wiki，每间隔一段时间登陆一次。
            // login();
            ExchangeEmailShallowDTO email = emailQueue.poll(2, TimeUnit.SECONDS);
            if (email == null) {
                break;
            }
            threadPool.submit(new insertToWikiTask(email));
        }
    }


    protected List<Article> extractEmail() throws InterruptedException {
        List<ExchangeEmailShallowDTO> allEmails = emailService.queryAllEmails();
        if (allEmails == null) {
            return null;
        }
        for (ExchangeEmailShallowDTO cur : allEmails) {
            emailQueue.offer(cur);
        }
        return null;
    }


    public class ExtractEmailTask extends Thread {

        @Override
        public void run() {
            try {
                extractEmail();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public class insertToWikiTask implements Runnable {

        private ExchangeEmailShallowDTO emailShallowDTO;

        public insertToWikiTask(ExchangeEmailShallowDTO emailShallowDTO) {
            this.emailShallowDTO = emailShallowDTO;
        }

        @Override
        public void run() {
            insert();
        }

        private void insert() {
            System.out.println("插入wiki成功");
        }
    }

    class ExchangeEmailShallowDTO {}

    class Article {
        private String name = "name";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    class EmailService {
        public List<ExchangeEmailShallowDTO> queryAllEmails(){
            return new ArrayList<>();
        }
    }

    class ArticleBlockingQueue<E>{
        private BlockingQueue<E> blockingQueue = new LinkedBlockingDeque<>();
        public void offer(E e) throws InterruptedException {
           blockingQueue.put(e);
        }
        public E poll(long timeOut, TimeUnit unit) throws InterruptedException {
            return blockingQueue.poll(timeOut, unit);
        }
    }

}
