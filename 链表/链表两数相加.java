package 链表;

/**
 * Created by jintao.bai on 2020/5/28 15:33
 */
public class 链表两数相加 {

    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> node = dummy;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int value = (l1 == null ? 0 : l1.getValue()) + (l2 == null ? 0 : l2.getValue()) + flag;
            node.setNext(new ListNode<>(value % 10));
            flag = value % 10;
            node = node.getNext();
            l1 = l1 == null ? null : l1.getNext();
            l2 = l2 == null ? null : l2.getNext();
        }
        if (flag != 0) {
            node.setNext(new ListNode<>(flag));
        }
        return dummy.getNext();
    }
}
