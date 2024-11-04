package deleteNodeinaLinkedList;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


class Solution {
    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/";

    public void deleteNode(ListNode node) {
        System.gc();
        node.val=node.next.val;
        node.next=node.next.next;
    }
}