package leetcode_list;

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class number138 {
    /**
     * 浅拷贝是指, 修改B对象的属性和方法会影响到A对象的属性和方法, 我们称之为浅拷贝
     * 深拷贝是指, 修改B对象的属性和方法不会影响到A对象的属性和方法, 我们称之为深拷贝
     * 零拷贝
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        return head;
    }
    public static void main(String[] args) {

    }
}
