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
    getCommonEle(n1,n2,arr1,arr2);
    scn.close();
 }

    public static void getCommonEle(int n1, int n2, int arr1[], int arr2[])
    {
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        for(int i = 0; i < n1; i++)
        {
            hm1.put(arr1[i],0);
            // if(!hm1.containsKey(arr1[i]))
            // {
            //     hm1.put(arr1[i],0);
            // }
        }

        for(int i = 0; i < n2; i++)
        {
            if(hm1.containsKey(arr2[i]))
            {
                // Better Approach : If the element is present in the HashMap, then Simply remove the
                // Element frm the HashMap using hm.remove(arr[2]);
                
                System.out.println(arr2[i]);
                hm1.remove(arr2[i]);

                // Or
                // int val = hm1.get(arr2[i]);
                // if(val == 0)
                // {
                //     System.out.println(arr2[i]);
                //     hm1.put(arr2[i],1);
                // }
            }
        }
    }

}

// // With Two HaspMaps.

// import java.util.*;

// public class Main{

// public static void main(String[] args) throws Exception {
//     // write your code here
//     Scanner scn = new Scanner(System.in);
//     int n1 = scn.nextInt();
//     int arr1[] = new int[n1];
//     for(int i = 0; i < n1; i++)
//     {
//         arr1[i] = scn.nextInt();
//     }
//     int n2 = scn.nextInt();
//     int arr2[] = new int[n2];
//     for(int i = 0; i < n2; i++)
//     {
//         arr2[i] = scn.nextInt();
//     }
//     getCommonEle(n1,n2,arr1,arr2);
//     scn.close();
//  }

//     public static void getCommonEle(int n1, int n2, int arr1[], int arr2[])
//     {
//         HashMap<Integer,Integer> hm1 = new HashMap<>();
//         for(int i = 0; i < n1; i++)
//         {
//             if(!hm1.containsKey(arr1[i]))
//             {
//                 hm1.put(arr1[i],1);
//             }
//         }

//         HashMap<Integer, Integer> hm2 = new HashMap<>();
//         for(int i = 0; i < n2; i++)
//         {
//             if(hm1.containsKey(arr2[i]))
//             {
//                 if(!hm2.containsKey(arr2[i]))
//                 {
//                     System.out.println(arr2[i]);
//                     hm2.put(arr2[i],1);
//                 }
//             }
//         }
//     }

// }