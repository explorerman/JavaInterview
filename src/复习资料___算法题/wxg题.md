## 算法1

1. 两个栈实现一个队列

进阶：如何避免频繁拷贝

2. 一个字符串，删除几个字符可以形成回文字符串？比如：google删除le

## 算法2

1. 判断两棵二叉树是否是同构的，同构的意思是说：一棵树的任意一个节点的左右子树，经过n次变换后，和另一棵树相同，那就称为两个树是同构的。
2. 用数组实现一个循环队列，进阶：在上面实现无锁并发，单线程写，多线程读

## 算法3

1. 一个满二叉树深度为k，结点树为2^k - 1; 节点值为1至（2^k - 1），给出k和任意三个节点的值，输出包含该三个节点的最小子树的根节点。
   样例输入：4 10 15 13
   样例输出：12

2. 写一个LRU缓存

3. 按行打印环形数组，输入一个整数N，按行打印出从N*N矩阵
   比如n = 3

   123
   894
   765
   打印：123 894 765
   不能再内存里拼接好再输出，必须逐个打印

## 算法4

1. 一个无序正整数数组，求出这些数可以拼接的最大数字，返回string
   如：8，91，6，35，3 返回9186353 跟lc上179一样

   

   ```java
   public String largestNumber(int[] nums) {
   		StringBuilder sb = new StringBuilder();
     			int len = nums.length;
     			//因为要使用Arrays.sort();该方法需要是T数组，而给的基本类型数组，所以需要包装成Integer数组
     			Integer[] newNums = new Integer[len];
     			for(int i = 0; i < len; i++){
             newNums[i] = nums[i]; 
           }
     			//重写排序方法
     			Arrays.sort(newNums, new Comparator<Integer>(){
             public int compare(Integer o1, Integer o2){
               //将数组中的两个数，拼接成字符串比较，比如：3，30
               //str1: 3+30 = 330，str2 = 30+3 = 303
               //330 > 303,即str1 > str2,所以按从大到小排序，3要排在30的前面
               String str1 = o1.toString() + o2.toString();
   						String str2 = o2.toString() + o1.toString();
               //谁在前面谁大，str2.compareTo(str1),代表着str2大，数组按从大到小排
               return str2.compareTo(str1);
             }
           });
     			//拼接结果
     			for(int i = 0; i < len; i++){
             sb.append(newNums[i]);
           }
     		//返回数组为空的情况
     		return sb.charAt(0) == '0' ? "0" : sb.toString();
       }
   ```

   

2. LeetCode跳跃距离2

3. 计算四则运算表达式，只有正整数，加减除法，不需要考虑除0，和小数

4. 10亿数中找中位数
   先考虑两个数组中，怎么找中位数,要求：不能合并数组 （LeetCode第4题）

5. 完全二叉树求节点数---BFS解决
   

   ```java
   public int countNodes(TreeNode root) {
   	int res = 0;
     if(root == null) return res;
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     while(!queue.isEmpty()){
       int levelSize = queue.size();
       res += levelSize;
       //这儿不能直接写levelSize,因为levelSize是个final的固定值，不是个变量，所以需要将i指向levelSize即可
       for(int i = levelSize; i>0;i--){
         TreeNode temp = queue.poll();
         if(temp.left != null) queue.offer(temp.left);
         if(temp.right != null) queue.offer(temp.right);
       }
     }
     return res;
       }
   ```

   

## 算法5

输入两个字符串，输出一个字符串，输入的字符串都是整数类型，位数很大，把这个字符串相乘的结果输出，即大数相乘的算法，不允许使用系统函数，只使用基本的循环与加减乘除即可，45分钟
例如样本“123456789111111”*“987654321111111

## 