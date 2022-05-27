import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ansLis = gss(str);
        System.out.print(ansLis);
        scn.close();
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0)
        {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }
        char ch = str.charAt(0);
        String subStr = str.substring(1);
        ArrayList<String> resList = gss(subStr);
        ArrayList<String> ansList = new ArrayList<>();
        for(String ele : resList)
        {
            ansList.add(ele);
        }
        for(String ele : resList)
        {
            ansList.add(ch+ele);
        }
        return ansList;
    }

}