package sort;

/**
 * @author 李杰
 * @version 1.0
 * @Description  排序算法的抽象类，实现了less和swap算法，less实现比较操作，swap实现交换。
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/15 9:39
 * @title 标题: 排序算法的抽象类
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public abstract class Sort<T extends Comparable<T>> {
    /**
     *功能描述
     * @name 实现类实现排序算法
     * @createTime: 2020/4/15 9:57
     * @param  * @param nums 
     * @author 李杰
     * @return 
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public abstract void sort(T[] nums);

    /**
     *功能描述
     * @name  比较两个数的大小，返回true，是前者小于后者，返回false，是前者大于后者。二者相等也返回false
     * @createTime: 2020/4/15 9:45
     * @param  * @param v
     * @param w
     * @author 李杰
     * @return {@link boolean}返回true，是前者小于后者，返回false，是前者大于后者。二者相等也返回false
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    protected boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }

    /**
     *功能描述
     * @name  交换容器中的两个数
     * @createTime: 2020/4/15 9:45
     * @param  * @param a
     * @param i
     * @param j
     * @author 李杰
     * @return
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    protected void swap(T[] a, int i, int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
