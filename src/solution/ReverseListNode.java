package solution;

/**
 * @author LZN
 * @Title ReverseListNode
 * @ProjectName pattern
 * @Description
 * @date 2022-10-17 12:44
 **/
public class ReverseListNode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverse(ListNode head){
        if (head==null||head.next==null){
            return null;
        }
        ListNode newHead=reverse(head.next);
        // 1>2>3>4

        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
