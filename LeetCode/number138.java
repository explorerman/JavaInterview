import java.util.HashMap;
import java.util.Map;

/**
 * @author 李杰
 * @Description 复制带随机指针的链表
 */
class Node {
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
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        //第一步：在每个原节点后面创建一个新节点
        // 1->1'->2->2'->3->3'
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p = newNode.next;
        }
        p = head;
        //第二步:设置新节点的随机指针
        while (p != null) {
            if (p.random != null) {
                //都是新节点
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        //第三步：将两个链表分离
        while (p != null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }

    //方法2:使用hashmap
    public Node copyRandomList2(Node head) {
        if(head == null){
            return null;
        }
        //创建一个hash表，key是原节点，value是新节点
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null){
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
        p = head;
        //再次遍历，这次遍历把next和随机指针设置好
        while (p != null){
            Node newNode = map.get(p);
            if(p.next != null){
                newNode.next = map.get(p.next);
            }
            if(p.random != null){
                newNode.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }

}
