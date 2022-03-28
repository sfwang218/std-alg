package linked_list;

/**
 * 从 链表中 删除给定节点
 */
public class DeleteGivenValue {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeValue(Node head, int num) {
        // head来到第一个不需要删的位置
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        Node head = new Node(3);

        Node cur = head;
        Node node;
        for (int i = 3; i > 0; i--) {
            node = new Node(i);

            cur.next = node;
            cur = node;
        }

        head = removeValue(head, 3);

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
