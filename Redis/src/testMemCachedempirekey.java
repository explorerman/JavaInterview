import com.danga.MemCached.MemCachedClient;

import java.util.Date;
import java.util.Objects;

/**
 * @author 李杰
 * @version 1.0
 * @Description 测试memcached缓存单key的过期时间
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/27 12:56
 * @title 标题: 测试memcached缓存单key的过期时间
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class testMemCachedempirekey {
    public static void main(String[] args) throws InterruptedException {
        //时间都是毫秒
        MemCachedClient memCachedClient = new MemCachedClient();
        memCachedClient.set("lijie", "lijie的过期时间测试", new Date(1000L));
        Thread.sleep(2000L);
        final Object lijie = memCachedClient.get("lijie");
        if(!Objects.isNull(lijie)){
            System.out.println(lijie);
        }
    }

}
