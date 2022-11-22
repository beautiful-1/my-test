package solution;

/**
 * @author LZN
 * @Title ReverseKGroup
 * @ProjectName pattern
 * @Description K个一组翻转链表。
 * @date 2022-10-17 12:56
 **/
public class ReverseKGroup {
    public ReverseListNode.ListNode reverseKGroup(ReverseListNode.ListNode head,int k){
        ReverseListNode.ListNode dump = new ReverseListNode.ListNode(0);
        dump.next=head;
        ReverseListNode.ListNode pre=dump;
        ReverseListNode.ListNode end =dump;
        // end.next==null，表示链表到达未尾部结点
        while (end.next!=null){
            for (int i=0;i<k;i++){
                end=end.next;
            }
            if(end==null){
                break;
            }
            //循环中的两个临时变量
            ReverseListNode.ListNode start=pre.next;
            ReverseListNode.ListNode next=end.next;
            // 断开局部链表和主链表的链接
            end.next=null;
            pre.next=myReverse(start);
            start.next=next;
            pre=start;
            end=start;
        }
        return dump.next;
    }
    /**
     * 该方法是通过3个指针来进行链表的翻转
     * */
    private ReverseListNode.ListNode myReverse(ReverseListNode.ListNode head){
        ReverseListNode.ListNode preNode=null;
        ReverseListNode.ListNode curNode=head;
        ReverseListNode.ListNode nextNode=null;
        while(curNode!=null){
            // 获取到下一个节点的，临时保存
            nextNode=curNode.next;
            // 原本当前节点的下一个节点时指向nextNode  由于链表翻转，需要将curNode的nextNode指向preNode
            curNode.next=preNode;
            // 接下来当前节点变为preNode
            preNode=curNode;
            // 接下来指针向右移动，nextNode变成了curNode
            curNode=nextNode;
        }
        return preNode;
    }
}
