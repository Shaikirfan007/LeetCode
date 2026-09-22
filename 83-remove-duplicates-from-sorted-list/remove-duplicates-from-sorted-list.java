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
    public ListNode deleteDuplicates(ListNode head) {
        // If the list is empty, just return null
        if (head == null) return null;
        
        // Start from the head
        ListNode current = head;
        
        // Traverse until the end
        while (current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                // Move forward if no duplicate
                current = current.next;
            }
        }
        
        return head;
    }
}
