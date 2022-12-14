package solution;

/**
 * @author LZN
 * @Title CommonLoopNode
 * @ProjectName pattern
 * @Description 给出两个单链表，判断是否相交
 * @date 2022-10-17 15:39
 **/
public class CommonLoopNode {
    static class Node {
        public Node next;

        public Node(Node node) {
            this.next = node;
        }
    }

    public static Node findOverlap(Node head1, Node head2) {
        if (head1 == null || head1.next == null) {
            return null;
        }
        if (head2 == null || head2.next == null) {
            return null;
        }
        Node node1 = head1.next;
        Node node2 = head2.next;
        int l1 = 0;
        int l2 = 0;
        while (node1.next != null) {
            node1 = node1.next;
            ++l1;
        }
        while (node2.next != null) {
            node2 = node2.next;
            ++l2;
        }
        if (node1 == node2) {
            if (l1 > l2) {
                while (l1 - l2 > 0) {
                    head1 = head1.next;
                    --l1;
                }
            }
            if (l2 > l1) {
                while (l2 - l1 > 0) {
                    head2 = head2.next;
                    --l2;
                }
            }
            while (head1 != head2) {
                head1 = head2.next;
                head2 = head2.next;
            }
            return head1;
        } else {
            // 如果没有相同的尾节点，说明他们不相交
            return null;
        }

    }
}
