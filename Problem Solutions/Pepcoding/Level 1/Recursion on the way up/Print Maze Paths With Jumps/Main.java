import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(1,1,n,m,"");
        scn.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if((sr==dr)&&(sc==dc))
        {
            System.out.println(psf);
            return;
        }
        int i = 1;
        while((sc+i)<=dc)
        {
            printMazePaths(sr,sc+i,dr,dc,psf+"h"+i);
            i++;
        }
        i = 1;
        while((sr+i)<=dr)
        {
            printMazePaths(sr+i,sc,dr,dc,psf+"v"+i);
            i++;
        }
        i = 1;
        while(((sr+i)<=dr) && ((sc+i)<=dc))
        {
            printMazePaths(sr+i,sc+i,dr,dc,psf+"d"+i);
            i++;
        }
    }

}