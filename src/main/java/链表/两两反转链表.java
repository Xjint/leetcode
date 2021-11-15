package 链表;

import base.ListNode;

/**
 * @author baijintao
 * @date 2021/10/9 10:38 上午
 */
public class 两两反转链表 {

  /**
   * 每两个节点翻转
   */
  public ListNode ReverseList(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode node = dummy;
    while (node.next != null && node.next.next != null) {
      ListNode a = node.next;
      ListNode b = a.next;
      node.next = b;
      a.next = b.next;
      b.next = a;
      node = b;
    }
    return dummy.next;
  }

  public ListNode ReverseListV2(ListNode head) {
    ListNode next = head.next;
    head.next = ReverseListV2(next.next);
    next.next = head;
    return next;
  }

}
