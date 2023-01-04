import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        for(int i = 0; i < num; i++)
        {
            String str = scn.next();
            if(!hm.containsKey(str))
            {
                hm.put(str, 1);
                arr.add(str);
            }
            else
            {
                hm.put(str, hm.get(str) + 1); // or simly use 'arr.remove(str);' 
            }                                 // then we would not have to traverse the 
        }                                     // arraylist again to remove the elements
                                              // occuring more than once.

        // ? Why hadn't I used arr.remove(str) trick above??
        // * If we had done that, then It would have search the arraylist again and again
        // * even though the element had been already deleted. that is why it is a better
        // * approach to simply find their occurances and store it in the hashmap and later
        // * traversing the list in reverse order(as we will be removing the element from the
        // * list) and then removing the elements in one go.

        int len = arr.size();
        for(int i = len-1; i > -1; i--) // traversing the arraylist in the reverse order
        {                               // as we will be removing elements from the arraylist.
            if(hm.get(arr.get(i)) > 1)
            {
                arr.remove(i);
            }
        }
        int k = scn.nextInt();
        if(k > arr.size())
        {
            System.out.print("");
        }
        else
        {
            System.out.print(arr.get(k-1));
        }
        scn.close();
    }
}