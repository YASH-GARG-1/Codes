import java.io.*;

public class solution{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static int[] inverse(int[] a){
    // write your code here
    int n = a.length;
    if(n == 0)
    {
        return null;
    }
    int arr[] = new int[n];
    for(int i = 0;i<n;i++)
    {
        arr[a[i]] = i;
    }
    return arr;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter the size of array : ");
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    System.out.println("Enter the ELements of array : ");
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int[] inv = inverse(a);
    System.out.println("Inverse of the array is : ");
    display(inv);
 }

}