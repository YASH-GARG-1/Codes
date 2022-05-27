import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int arr1[] = new int[n1];
    for(int i = 0; i < n1; i++)
    {
        arr1[i] = scn.nextInt();
    }
    int n2 = scn.nextInt();
    int arr2[] = new int[n2];
    for(int i = 0; i < n2; i++)
    {
        arr2[i] = scn.nextInt();
    }
    getCommonEle2(n1,n2,arr1,arr2);
    scn.close();
 }
    
    public static void getCommonEle2(int n1, int n2, int arr1[], int arr2[])
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n1; i++)
        {
            hm.put(arr1[i], hm.getOrDefault(arr1[i],0)+1);
        }

        for(int i = 0; i < n2; i++)
        {
            if(hm.containsKey(arr2[i]))
            {
                int val = hm.get(arr2[i]);
                System.out.println(arr2[i]);
                if((val-1) == 0)
                {
                    hm.remove(arr2[i]);
                }
                else
                {
                    hm.put(arr2[i],val-1);
                }
            }
        }
    }
}