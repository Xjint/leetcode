package 剑指offer系列;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 翻转链表后 常规相加
        ListNode reversel1 = reverse(l1);
        ListNode reversel2 = reverse(l2);
        return doAdd(reversel1, reversel2);
    }

    // 两链表相加
    private ListNode doAdd(ListNode reversel1, ListNode reversel2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode listNode = dummyHead;
        int flag = 0;
        int val = 0;

        int val1 = 0;
        int val2 = 0;
        while (reversel1 != null || reversel2 != null) {
            val1 = reversel1 != null ? reversel1.val : 0;
            val2 = reversel2 != null ? reversel2.val : 0;
            val = (val1 + val2 + flag) % 10;
            flag = (val1 + val2 + flag) / 10;
            listNode.next = new ListNode(val);
            listNode = listNode.next;
        }
        if (flag != 0) {
            listNode.next = new ListNode(flag);
        }
        return dummyHead.next;
    }

    // 翻转链表
    private ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode head = reverse(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return head;
    }
}
// @lc code=end