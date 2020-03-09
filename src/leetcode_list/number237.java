package leetcode_list;

public class number237 {
    //一般链表删除节点是知道前面的节点，然后直接让前面节点指向下一节点，这道题的特点在于，只知道当前节点，所以转换思路为：
    //将下一节点的值赋给当前节点，删除下一节点，间接达到了要求。
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {

    }
}
