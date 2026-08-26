/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;

        // Step 1: Find length
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: If removing the first node
        if (n == length) return head.next;

        // Step 3: Traverse to (length - n - 1)th node
        temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        // Step 4: Remove node
        temp.next = temp.next.next;

        return head;
    }
}
