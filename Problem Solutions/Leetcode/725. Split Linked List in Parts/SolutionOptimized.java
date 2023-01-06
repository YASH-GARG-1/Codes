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
import java.util.*;
class SolutionOptimized {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode [] ans = new ListNode[k];
        int len = 0;
        
        for(ListNode temp = head; temp != null; temp = temp.next)
        {
            len++;
        }

        int count = len/k;
        int rem = len%k;

        ListNode temp, prev;
        temp = prev = head;

        for(int i = 0; i < k && temp != null; i++, rem--)
        {
            ans[i] = temp;
            for(int j = 0; j < count + (rem > 0 ? 1 : 0); j++)
            {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }

        return ans;
    }
}