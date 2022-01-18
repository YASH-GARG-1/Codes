// import java.io.*;
// import java.util.*;

// public class Main {

//     static ArrayList<String> refList = new ArrayList<>();
    
//     static void initArrayList()
//     {
//         refList.add(".;");
//         refList.add("abc");
//         refList.add("def");
//         refList.add("ghi");
//         refList.add("jkl");
//         refList.add("mno");
//         refList.add("pqrs");
//         refList.add("tu");
//         refList.add("vwx");
//         refList.add("yz");
//     }

//     public static void main(String[] args) throws Exception {
//         Scanner scn = new Scanner(System.in);
//         String str = scn.next();
//         initArrayList();
//         ArrayList<String> ansList = getKPC(str);
//         System.out.print(ansList);
//         scn.close();
//     }

//     public static ArrayList<String> getKPC(String str) {
//         if(str.length() == 0)
//         {
//             ArrayList<String> baseList = new ArrayList<>();
//             baseList.add("");
//             return baseList;
//         }
//         int n = Integer.parseInt(String.valueOf(str.charAt(0)));
//         String subStr = str.substring(1);
//         ArrayList<String> ansList = getKPC(subStr);
//         ArrayList<String> finalList = new ArrayList<>();
//         String ref = refList.get(n);
//         for(int i = 0; i < ref.length(); i++)
//         {
//             char ch = ref.charAt(i);
//             for(String ele : ansList)
//             {
//                 finalList.add(ch+ele);
//             }
//         }
//         return finalList;
//     }

// }

import java.io.*;
import java.util.*;

public class Main {

    static String refList[] = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ansList = getKPC(str);
        System.out.print(ansList);
        scn.close();
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0)
        {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }
        char cha = str.charAt(0);
        int n = cha - '0';
        String subStr = str.substring(1);
        ArrayList<String> ansList = getKPC(subStr);
        ArrayList<String> finalList = new ArrayList<>();
        String ref = refList[n];
        for(int i = 0; i < ref.length(); i++)
        {
            char ch = ref.charAt(i);
            for(String ele : ansList)
            {
                finalList.add(ch+ele);
            }
        }
        return finalList;
    }

}