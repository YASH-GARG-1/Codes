/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode fastPtr, slowPtr;
        fastPtr = slowPtr = head;
        
        boolean flag = false;
        while(fastPtr!= null && fastPtr.next != null)
        {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr)
            {
                flag = true;
                break;
            }
        }
        
        if(!flag)
        {
            return null;
        }
        
        slowPtr = head;
        
        while(slowPtr != fastPtr)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return slowPtr;
    }
}