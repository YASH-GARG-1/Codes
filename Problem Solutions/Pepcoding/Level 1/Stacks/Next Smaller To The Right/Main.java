import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
  }

  public static int[] solve(int[] arr) {
    // solve
    int n = arr.length;
    int nstr[] = new int[n];
    Arrays.fill(nstr,-1);
    Stack<Integer> st = new Stack<>();
    for(int i = 0; i < n; i++)
    {
        while(!st.empty() && arr[st.peek()] > arr[i])
        {
            nstr[st.pop()] = arr[i];
        }
        st.push(i);
    }
    return nstr;
  }

}