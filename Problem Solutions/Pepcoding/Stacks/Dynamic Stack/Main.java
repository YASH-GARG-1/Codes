import java.io.*;
import java.util.*;

public class Main {

  public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      return tos + 1;
    }

    void display() {
      for (int i = tos; i >= 0; i--) {
        System.out.print(data[i] + " ");
      }
      System.out.println();
    }

    // change the code of this function according to question
    void push(int val) {
        int n = data.length;
      if (tos == n - 1) {
        int arr[] = new int[2*n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = data[i];
        }
        data = arr;
      }
        tos++;
        data[tos] = val;
    }

    int pop() {
      if (tos == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
          int n = data.length;
        int val = data[tos];
        if((tos*2) <= n)
        {
            int arr[] = new int[n/2];
            for(int i = 0; i < tos; i++)
            {
                arr[i] = data[i];
            }
            data = arr;
        }
        tos--;
        return val;
      }
    }

    int top() {
      if (tos == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        return data[tos];
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("display")) {
        st.display();
      }
      str = br.readLine();
    }
  }
}