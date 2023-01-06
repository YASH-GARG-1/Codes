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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] ans = new ListNode[k];
        int len = 0;
        
        ListNode temp = head;
        while(temp != null)
        {
            len++;
            temp = temp.next;
        }

        if(len <= k)
        {
            int count = 0;
            temp = head;
            for(int i = 0; i < len; i++)
            {
                head = temp;
                temp = temp.next;
                head.next = null;
                ans[i] = head;
                count++;
            }
            if(count < k)
            {
                while(count < k)
                {
                    ans[count] = null;
                    count++;
                }
            }
        }
        else
        {
            int extraCount = 0;
            if(len%k != 0)
            {
                extraCount = len%k;
            }

            int count = len/k;
            temp = head;
            ListNode prev = head;
            
            int idx = 0;
            int num = 0;
            
            while(temp != null)
            {
                if(num == 0)
                {
                    ans[idx++] = temp;
                    num++;
                }
                else if(num == count)
                {
                    if(extraCount > 0)
                    {
                        ListNode node = temp.next;
                        temp.next = null;
                        temp = node;
                        ans[idx++] = temp;
                        extraCount--;
                        num = 1;
                        if(temp == null)
                        {
                            break;
                        }
                    }
                    else
                    {
                        prev.next = null;
                        ans[idx++] = temp;
                        num = 1;
                    }
                }
                else
                {
                    num++;
                }
                prev = temp;
                temp = temp.next;
            }
        }

        return ans;
    }
}