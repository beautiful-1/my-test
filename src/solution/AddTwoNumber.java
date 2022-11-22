package solution;

/**
 * @author LZN
 * @Title TowNumTotal
 * @ProjectName pattern
 * @Description 两数相加
 * @date 2022-10-17 14:44
 **/
public class AddTwoNumber {
    public ReverseListNode.ListNode addTwoNumber(ReverseListNode.ListNode l1, ReverseListNode.ListNode l2) {
        // 创建一个头节点
        ReverseListNode.ListNode pre = new ReverseListNode.ListNode(0);
        // 创建一个当前节点， 这个节点的主要作用就是作为移动使用
        ReverseListNode.ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 获取数据
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 求和
            int sum =x+y+carry;
            // 获取进一位
            carry=sum%10;
            //求余数
            sum=sum/10;
            cur.next=new ReverseListNode.ListNode(sum);
            cur=cur.next;
            if (l1.next!=null){
                l1=l1.next;
            }
            if (l2.next!=null){
                l2=l1.next;
            }
        }
        if (carry==1){
            cur.next=new ReverseListNode.ListNode(1);
        }
        return pre.next;

    }
}
