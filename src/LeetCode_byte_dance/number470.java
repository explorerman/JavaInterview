package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 用rand7()实现rand10()
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/30 12:57
 * @title 标题: 用rand7()实现rand10()
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number470 {
    public int rand10() {
        int res;
        while (true){
            //构造1-49的均匀分布
            res = (rand7() - 1) * 7 + rand7();
            //剔除大于40的值，1-40等概率出现
            if(res <= 40) break;
        }
        //构造1-10的均匀分布，+1是为了解决40%10==0的情况
        return res % 10 + 1;
    }

    private int rand7() {
        return 0;
    }
}
