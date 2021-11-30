import java.io.*;

public class Solution{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.print(sb);
  }

  public static void reverse(int[] a){
    int n = a.length;
    int temp;
    for(int i = 0;i<n/2;i++)
    {
        temp = a[i];
        a[i] = a[n-1-i];
        a[n-1-i] = temp;
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter the Size of Array : ");
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    System.out.print("Enter the Elements of Array : \n");
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    reverse(a);
    System.out.println("The Array After Reversing is : ");
    display(a);
 }

}