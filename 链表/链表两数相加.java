package 链表;

/**
 * Created by jintao.bai on 2020/5/28 15:33
 */
public class 链表两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int value = (l1 == null ? 0 : l1.value) + (l2 == null ? 0 : l2.value) + flag;
            node.next = new ListNode(value % 10);
            flag = value % 10;
            node = node.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag != 0) {
            node.next = new ListNode(flag);
        }
        return dummy.next;
    }
}
