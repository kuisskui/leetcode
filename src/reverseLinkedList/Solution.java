package reverseLinkedList;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/";

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: if the list is empty or has only one node
        }
        return recursive(head);
    }

    public ListNode recursive(ListNode node) {
        if (node.next == null){
            return node;
        }
        ListNode newHead = recursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }


    public ListNode bestMemorySolution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }

        return prev;
    }
}