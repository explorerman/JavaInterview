package swordOffer;

import java.util.Arrays;

/**
 * @author 李杰
 * @version 1.0
 * @Description 最小的K个数
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/3 16:19
 * @title 标题: 最小的K个数
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
