// import java.util.*;

// public class Main{

//     public static void main(String args[])
//     {
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         for(int i = 1; i <= n; i++)
//         {
//             String str = scn.next();
//             System.out.println(encodingString(str,0));
//         }
//         scn.close();
//     }

//     public static long encodingString(String str, int idx)
//     {
//         if(str.length() == idx)
//         {
//             return 1;
//         }
//         long count = 0;
//         char ch = str.charAt(idx);
//         if(ch == '*')
//         {
//             int n2;
//             for(int j = 1; j <= 9; j++)
//             {
//                 n2 = j+ 64;
//                 ch = (char)n2;
//                 count += encodingString(str,idx+2);
//                 count = count%1000000009;
//             }    
//             return count;
//         }
//         int n = ch - '0';
//         if(n > 0)
//         {
//             int n1 = n + 64;
//             ch = (char)n1;
//             count += encodingString(str, idx+1);
//             count = count%1000000009;
//         }
//         if(((str.length()-idx-1)>=1) && n!=0)
//         {
//             ch = str.charAt(idx+1);
//             int n2;
//             if(ch == '*')
//             {
//                 for(int j = 0; j <= 9; j++)
//                 {
//                     n2 = j;
//                     n2 = n*10 + n2;
//                     if(n2 >= 1 && n2 <= 26)
//                     {
//                         n2 = n2+64;
//                         ch = (char)n2;
//                         count += encodingString(str,idx+2);
//                         count = count%1000000009;
//                     }
//                     else if(n2 >= 27 && n2 <= 52)
//                     {
//                         n2 = n2+70;
//                         ch = (char)n2;
//                         count += encodingString(str,idx+2);
//                         count = count%1000000009;
//                     }
//                 }    
//                 return count;
//             }
//             n2 = ch-'0';
//             n2 = n*10 + n2;
//             if(n2 >= 1 && n2 <= 26)
//             {
//                 // Uppercase
//                 n2 = n2+64;
//                 ch = (char)n2;
//                 count += encodingString(str,idx+2);
//                 count = count%1000000009;
//             }
//             else if(n2 >= 27 && n2 <= 52)
//             {
//                 //Lowercase
//                 n2 = n2+70;
//                 ch = (char)n2;
//                 count += encodingString(str,idx+2);
//                 count = count%1000000009;
//             }
//         }
//         return count;
//     }
// }

import java.util.*;

public class Main{

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++)
        {
            String str = scn.next();
            System.out.println(encodingString(str,0));
        }
        scn.close();
    }

    public static long encodingString(String str, int idx)
    {
        if(str.length() == idx)
        {
            return 1;
        }
        long count = 0;
        char ch = str.charAt(idx);
        if(ch == '*')
        {
            int n;
            for(int j = 1; j <= 9; j++)
            {
                n = j + 64;
                ch = (char)n;
                count += encodingString(str,idx+2);
                count = count%1000000009;
            }
            if(idx+1 == str.length())
            {
                return count;
            }
            // for thr test case *3
            for(int j = 1; j <= 5; j++)
            {   
                ch = str.charAt(idx+1);
                int n2;
                if(ch == '*')
                {
                    for(int k = 0; k <= 9; k++)
                    {
                        n2 = j;
                        n2 = j*10 + n2;
                        count += calCount(n2,str,idx);
                        count = count%1000000009;
                    }    
                    return count;
                }
                n2 = ch-'0';
                n2 = j*10 + n2;
                count += calCount(n2,str,idx);
                count = count%1000000009;
            }
            return count;
        }
        int n = ch - '0';
        if(n > 0)
        {
            int n1 = n + 64;
            ch = (char)n1;
            count += encodingString(str, idx+1);
            count = count%1000000009;
        }
        if(((idx+1)<str.length()) && n!=0)
        {
            ch = str.charAt(idx+1);
            int n2;
            if(ch == '*')
            {
                for(int j = 0; j <= 9; j++)
                {
                    n2 = j;
                    n2 = n*10 + n2;
                    count += calCount(n2,str,idx);
                }    
                return count;
            }
            n2 = ch-'0';
            n2 = n*10 + n2;
            count += calCount(n2,str,idx);
            count = count%1000000009;
        }
        return count;
    }

    public static long calCount(int n2,String str,int idx)
    {
        char ch;
        long count = 0;
        if(n2 >= 1 && n2 <= 26)
        {
            // Uppercase
            n2 = n2+64;
            ch = (char)n2;
            count = encodingString(str,idx+2);
            count = count%1000000009;
        }
        else if(n2 >= 27 && n2 <= 52)
        {
            //Lowercase
            n2 = n2+70;
            ch = (char)n2;
            count = encodingString(str,idx+2);
            count = count%1000000009;
        }
        return count;
    }
}