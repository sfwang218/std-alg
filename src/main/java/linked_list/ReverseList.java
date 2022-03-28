package linked_list;

/**
 * 反转链表
 * 关键：记录当前节点的 前一个节点 和 后一个节点
 */
public class ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    //  head
    //   a    ->   b    ->  c  ->  null
    //   c    ->   b    ->  a  ->  null
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 当前节点的 last 指针 与 next 指针互换
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;

        while (head != null) {
            next = head.next;

            head.next = pre;
            head.last = next;
            pre = head;

            head = next;
        }
        return pre;
    }
}
