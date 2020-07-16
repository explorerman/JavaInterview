package java_basic;

/**
 * @author 李杰
 * @version 1.0
 * @Description 值类型
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/16 17:22
 * @title 标题: 值类型
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ValueType {
    public static void main(String[] args) {
        double d1 = 3.14;
        double d2 = d1;
        Double o1 = d1;
        Double o2 = d2;
        Double ox = o1;
        System.out.println(d1 == d2 ? "yes" : "no");
        System.out.println(o1.equals(o2) ? "yes" : "no");
        //注意包装类型的比较应该用equal
//        System.out.println(o1 == o2 ? "yes" : "no");
//        System.out.println(o1 == ox ? "yes" : "no");

    }
}
