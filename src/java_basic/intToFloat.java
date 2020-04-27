package java_basic;

/**
 * @author 李杰
 * @version 1.0
 * @Description  16和10进制互转
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/26 15:46
 * @title 标题:
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class intToFloat {
    public static void main(String[] args) {
        String ss = "42980000";
        final Integer bits = Integer.valueOf(ss.trim());
        Float value = Float.intBitsToFloat(Integer.valueOf(ss.trim(), 16));
        int s = ((bits >> 31) == 0) ? 1 : -1;
        int e = ((bits >> 23) & 0xff);
        int m = (e == 0) ?
                (bits & 0x7fffff) << 1 :
                (bits & 0x7fffff) | 0x800000;

        System.out.println(m);
        System.out.println("16进制浮点数转10进制=" + value);
        Float f = 76.0F;
        System.out.println("10进制浮点数转16进制=" + Integer.toHexString(Float.floatToIntBits(f)));
    }
}
