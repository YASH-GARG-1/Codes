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
    public int numComponents(ListNode head, int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        for(int ele : nums)
        {
            hs.add(ele);
        }
        int ans = 0;
        ListNode temp = head;
        boolean connected = false;
        while(temp != null)
        {
            if(hs.contains(temp.val))
            {
                if(!connected)
                {
                    ans++;
                    connected = true;
                    continue;
                }
            }
            else
            {
                connected = false;
            }
            temp = temp.next;
        }
        return ans;
    }
}