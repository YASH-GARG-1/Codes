import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn  =new Scanner(System.in);
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
        ArrayList<String> finalAns = new ArrayList<>();
        if(sc < dc)
        {
            int i = 1;
            while((sc+i)<=dc)
            {
                ArrayList<String> ansList = getMazePaths(sr,sc+i,dr,dc);
                for(String ele : ansList)
                {
                    finalAns.add("h"+i+ele);
                }
                i++;
            }
        }
        if(sr < dr)
        {
            int i = 1;
            while((sr+i)<=dr)
            {
                ArrayList<String> ansList = getMazePaths(sr+i,sc,dr,dc);
                for(String ele : ansList)
                {
                    finalAns.add("v"+i+ele);
                }
                i++;
            }
        }
        if((sc<dc)&&(sr<dr))
        {
            int i = 1;
            while(((sc+i)<=dc) && ((sr+i)<= dr))
            {
                ArrayList<String> ansList = getMazePaths(sr+i,sc+i,dr,dc);
                for(String ele : ansList)
                {
                    finalAns.add("d"+i+ele);
                }
                i++;
            }
        }
        return finalAns;
    }

}