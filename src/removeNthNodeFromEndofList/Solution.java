package removeNthNodeFromEndofList;


import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    final private String url = "https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/603/";

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1){
            head.next = null;
            return null;
        }
        ListNode realHead = new ListNode();
        realHead.next = head;
        check(realHead, n);
        return realHead.next;

    }

    public int check(ListNode node, int n){
        if (node.next == null){
            return n - 1;
        }
        int count = check(node.next, n);
        if (count == 0){
            node.next = node.next.next;
        }
        return count - 1;
    }

    public ListNode bestMemorySolution(ListNode head, int n) {
        ListNode fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        if(fast == null) return head.next;

        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next.next;
        slow.next = temp;
        return head;
    }
}
