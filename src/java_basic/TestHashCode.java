package java_basic;

/**
 * @author 李杰
 * @version 1.0
 * @Description 测试hashcode
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/12 10:56
 * @title 标题: 测试hashcode
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class TestHashCode {
    public static void main(String[] args) {
        Object key = "B";
        int h = key.hashCode();
        h ^= (h >>> 16);
        int i = h % 16;
        System.out.println(h);
        System.out.println(i);

    }
}
