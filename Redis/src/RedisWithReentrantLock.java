import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李杰
 * @version 1.0
 * @Description Java实现多线程可重入锁
 * jedis的分布式锁
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/23 10:57
 * @title 标题: Java实现多线程可重入锁
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class RedisWithReentrantLock {
    private ThreadLocal<Map<String, Integer>> threadLocal = new ThreadLocal<>();

    private Jedis jedis;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    private Map<String, Integer> currentLockers() {
        Map<String, Integer> refs = threadLocal.get();
        if (refs != null) {
            return refs;
        }
        threadLocal.set(new HashMap<>());
        return threadLocal.get();
    }


    private boolean _lock(String key) {
        return jedis.set(key, "", "nx", "ex", 5L) != null;
    }

    private void _unlock(String key){
        jedis.del(key);
    }

    private boolean lock(String key) {
        Map<String, Integer> refs = currentLockers();
        final Integer refCnt = refs.get(key);
        if (refCnt != null) {
            refs.put(key, refCnt + 1);
            return true;
        }
        boolean ok = this._lock(key);
        if (!ok) {
            return false;
        }
        refs.put(key, 1);
        return true;
    }

    private boolean unlock(String key) {
        final Map<String, Integer> refs = currentLockers();
        Integer refCnt = refs.get(key);
        if(refCnt == null){
            return false;
        }
        refCnt -= 1;
        if(refCnt > 0){
            refs.put(key,refCnt);
        }else {
            refs.remove(key);
            this.unlock(key);
        }
        return true;
    }


    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        RedisWithReentrantLock redisWithReentrantLock = new RedisWithReentrantLock(jedis);
        System.out.println(redisWithReentrantLock.lock("codehole"));
        System.out.println(redisWithReentrantLock.lock("codehole"));
        System.out.println(redisWithReentrantLock.unlock("codehole"));
        System.out.println(redisWithReentrantLock.unlock("codehole"));
    }
}
