package 链表;

import base.ListNode;

/**
 * @author baijintao
 * @date 2021/10/1 10:33 上午
 */
public class 反转链表 {

  public ListNode ReverseList(ListNode head) {
    //递归
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = ReverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

}
