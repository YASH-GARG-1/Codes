import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            // if(hm.containsKey(ch))
            // {
            //     int count = hm.get(ch);
            //     hm.put(ch,count+1);
            // }
            // else
            // {
            //     hm.put(ch,1);
            // }
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        char ch = str.charAt(0);
        for(Character ele : hm.keySet())
        {
            if(hm.get(ele) > hm.get(ch))
            {
                ch = ele;
            }
        }
        System.out.print(ch);
        scn.close();
    }

}