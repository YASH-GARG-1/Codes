import java.io.*;
import java.util.*;

public class MergeKsortedLists{
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      HashMap<Integer, Integer> hm = new HashMap<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int n = lists.size();
      int idxarr[] = new int[n];
      int sizearr[] = new int[n];
      int no_of_ele = 0;
      for(int i = 0; i < n; i++)
      {
         sizearr[i] = lists.get(i).size();
         no_of_ele += sizearr[i];
      }

      for(int i = 0; i < n; i++)
      {
         int ele = lists.get(i).get(0);
         hm.put(ele,i);
         pq.add(ele);
         // System.out.println("Element : "+ele+" ListNo : "+i);
      }
      for(int i = 0; i < no_of_ele; i++)
      {
         int val = pq.peek();
         int listNo = hm.get(val);
         // System.out.println("Removing Value : "+val+" ListNo : "+listNo);
         rv.add(val);
         if((idxarr[listNo] + 1) < sizearr[listNo])
         {
            int idx = idxarr[listNo];
            idxarr[listNo] = idx+1;
            int ele = lists.get(listNo).get(idx+1);
            pq.add(ele);
            hm.put(ele,listNo);
            // System.out.println("Adding Element : "+ele+" ListNo : "+listNo);
         }
         pq.remove();
         hm.remove(val);
      }
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}