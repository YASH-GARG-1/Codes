import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ansList = getStairPaths(n);
        System.out.print(ansList);
        scn.close();
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0)
        {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }
        ArrayList<String> finalAns = new ArrayList<>();
        if((n-1) >= 0)
        {
            ArrayList<String> ansList1 = getStairPaths(n-1);
            for(String ele : ansList1)
            {
                finalAns.add(1+ele);
            }
        }
        if((n-2) >= 0)
        {
            ArrayList<String> ansList2 = getStairPaths(n-2);
            for(String ele : ansList2)
            {
                finalAns.add(2+ele);
            }
        }
        if((n-3) >= 0)
        {
            ArrayList<String> ansList3 = getStairPaths(n-3);
            for(String ele : ansList3)
            {
                finalAns.add(3+ele);
            }
        }
        return finalAns;
    }

}