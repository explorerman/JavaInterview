package 复习资料___设计题;


import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;
import sun.jvm.hotspot.utilities.MethodArray;
import sun.jvm.hotspot.utilities.RBNode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

interface IMsgQueue {

}

/**
 * 总消息队列管理.
 */
public class MsgQueueManager implements IMsgQueue {
    /**
     * 消息总队列
     */
    private final BlockingQueue<Message> messageQueue  = new LinkedTransferQueue<Message>();
    private final BlockingQueue<Message> subMsgQueues  = new LinkedTransferQueue<Message>();

    private static MsgQueueManager msgQueueManager = new MsgQueueManager();

    public static MsgQueueManager getInstance() {
        return msgQueueManager;
    }

    public void put(Message msg) {
        try {
            messageQueue.put(msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Message take() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }


    public BlockingQueue<Message> getMessageQueue() {
        return messageQueue;
    }



    public BlockingQueue<Message> getSubQueue(){
        int errorCount = 0;
        for (;;){
            if(subMsgQueues.isEmpty()){
                return null;
            }
            int index = (int)(System.nanoTime() % subMsgQueues.size());
//            return subMsgQueues.get(index);
            return null;
        }
    }


    //messageQueue.put(msg);
    //Packet msg = Packet.createPacket();
    //IMsgQueue messageQueue = MsgQueueFactory.getMessageQueue();
    //往消息队列添加一条消息
    //使用的时候往消息总队列发消息即可


    /*
     *启动一个消息分发线程，在这个线程里子子队列自动去总队列里获取信息.
     */
    static class DispatchMessageTask implements Runnable{
        @Override
        public void run() {
            BlockingQueue<Message> subQueue;
            for(;;){
                //如果没有数据则阻塞队列
                Message msg = null;
                try {
                    msg = getInstance().getMessageQueue().take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //如果为空，则表示没有session机器连上来
                //需要等待，直到有session机器连上来
                while ((subQueue = getInstance().getSubQueue()) == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                //把消息放到小队列
                try {
                    subQueue.put(msg);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class Message {

    }
}


