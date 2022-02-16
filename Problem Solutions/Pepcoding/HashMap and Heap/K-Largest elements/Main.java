/*
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
      for(int i = 0; i < n; i++)
      {
          pq.add(arr[i]);
      }
      printEle(pq,k);
    }
    
    public static void printEle(PriorityQueue<Integer> pq, int k)
    {
        if(k == 0)
        {
            return;
        }
        int ele = pq.peek();
        pq.remove();
        printEle(pq,k-1);
        System.out.println(ele);
    }
}
*/

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      for(int i = 0; i < k; i++)
      {
          pq.add(arr[i]);
      }
      printEle(k,arr);
    }
    
    public static void printEle(int k,int arr[])
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i = 0; i < k; i++)
        {
            pq.add(arr[i]);
        }
        
        for(int i = k; i < arr.length; i++)
        {
            if(pq.peek() < arr[i])
            {
                pq.add(arr[i]);
                pq.remove();
            }
        }
        
        for(int i = 0; i < k; i++)
        {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}