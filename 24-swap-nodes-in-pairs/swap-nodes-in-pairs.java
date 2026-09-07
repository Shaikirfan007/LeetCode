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
    public ListNode swapPairs(ListNode head) {
        // Base case: if list is empty or has only one node, return as is
        if (head == null || head.next == null) {
            return head;
        }

        // Nodes to be swapped
        ListNode first = head;
        ListNode second = head.next;

        // Swap
        first.next = swapPairs(second.next); // recursively swap the rest
        second.next = first;

        // New head is the second node
        return second;
    }
}
