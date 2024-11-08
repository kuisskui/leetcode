package palindromeLinkedList;


import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {
    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/";
    ListNode pointerHead;

    public boolean isPalindrome(ListNode head) {
        pointerHead = head;
        return recurse(head);
    }

    private boolean recurse(ListNode pointerTail) {
        if (pointerTail == null) {
            return true;
        }

        boolean isPalindromic = recurse(pointerTail.next);

        if (!isPalindromic) {
            return false;
        }

        if (pointerHead.val != pointerTail.val) {
            return false;
        }

        pointerHead = pointerHead.next;

        return true;
    }
}