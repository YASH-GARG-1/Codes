import java.util.*;

public class Source2{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = 0; i < n; i++)
        {
            int s = scn.nextInt();
            int arr[] = new int[s];
            for(int j = 0; j < s; j++)
            {
                arr[j] = scn.nextInt();
            }
            System.out.print(gokuAndDragonballs(s,arr,s));
        }
        scn.close();
    }

    public static String gokuAndDragonballs(int n, int arr[], int ele)
    {
        if(n == 0 && (ele != 0))
        {
            String ans = "NO";
            return ans;
        }
        if(ele == 0)
        {
            String ans = "YES";
            return ans;
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == n)
            {
                count++;
                arr[i] = 0;
                ele = ele-1;
            }
        }
        if(count == 0)
        {
            return "NO";
        }
        else
        {
            return gokuAndDragonballs(n-count,arr,ele);
        }
    }
}