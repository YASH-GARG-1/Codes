import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i= 0; i < n; i++)
    {
        arr[i] = scn.nextInt();
    }
    LongestConsecutiveSeq(n,arr);
    scn.close();
 }

    public static void LongestConsecutiveSeq(int n, int arr[])
    {
     HashMap<Integer,Boolean> hm = new HashMap<>();
		  for(int i = 0; i < n; i++)
		  {
			hm.put(arr[i],true);
		  }
		  for(int i = 0; i < n; i++)
		  {
			  if(hm.containsKey(arr[i] - 1))
			  {
				  hm.put(arr[i],false);
			  }
		  }
		  int count = 0;
		  int ele = -1;
		  for(int i = 0; i < n; i++)
		  {
			  if(hm.get(arr[i]) == true)
			  {
				  int j = 0;
				  while(hm.containsKey(arr[i]+j) == true)
				  {
					  j++;
				  }
				  if(count < j)
				  {
					  count = j;
					  ele = arr[i];
				  }
			  }
		  }
		  for(int i = 0; i < count; i++)
		  {
			  System.out.println(ele+i);
		  }
 }

}