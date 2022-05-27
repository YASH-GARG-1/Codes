import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> ansList = getMazePaths(0,0,n-1,m-1);
        System.out.print(ansList);
        scn.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if((sr == dr)&&(sc == dc))
        {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }
        ArrayList<String> finalList = new ArrayList<>();
        if(sc != dc)
        {
            ArrayList<String> intList = getMazePaths(sr,sc+1,dr,dc);
            for(String ele : intList)
            {
                finalList.add("h"+ele);
            }
        }
        if(sr != dr)
        {
            ArrayList<String> intList = getMazePaths(sr+1,sc,dr,dc);
            for(String ele : intList)
            {
                finalList.add("v"+ele);
            }
        }
        return finalList;
    }

}