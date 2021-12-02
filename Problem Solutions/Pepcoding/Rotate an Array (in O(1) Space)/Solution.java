import java.io.*;

public class Solution{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void reverseArray(int[] arr,int l,int r)
  {
      int temp;
      for(;l<r;l++,r--)
      {
          temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;
      }
  }

  public static void rotate(int[] a, int k){
    // write your code here
    int n = a.length;
    if(n == 0)
    {
        return;
    }
    k = k%n;
    if(k<0)
    {
        k = k+n;
    }
    if(k == 0 || n == 1)
    {
        return;
    }
    reverseArray(a,0,n-1);
    reverseArray(a,0,k-1);
    reverseArray(a,k,n-1);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter the size of Array : ");
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    System.out.println("Enter the Elements of Array : ");
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    System.out.print("Enter the value of K : ");
    int k = Integer.parseInt(br.readLine());
    rotate(a, k);
    System.out.print("The Array is : ");
    display(a);
 }

}