import java.util.*;

class Main{
    
    static int maxlev = 0;
    static int NoOfWays = 0;

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int Hp = scn.nextInt();
        int n = scn.nextInt();
        int noOfSpells = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        findNoOfWays(Hp,n,noOfSpells,arr,0);
        System.out.println(NoOfWays);
        // System.out.print(maxlev);
        scn.close();
    }

    public static void findNoOfWays(int Hp, int n, int noOfSpells, int arr[], int lev)
    {
        if(lev == n)
        {
            if(lev > maxlev)
            {
                maxlev = lev;
                NoOfWays = 1;
            }
            else if(lev == maxlev)
            {
                NoOfWays++;
            }
            return;
        }
        if(noOfSpells > 0)
        {
            // System.out.println("With spell : Moving to lev : "+(lev+1)+" from "+lev+" and hp : "+Hp);
            findNoOfWays(Hp,n,noOfSpells-1,arr,lev+1);
        }
        if((Hp - arr[lev])<=0)
        {
            if(lev > maxlev)
            {
                maxlev = lev;
                NoOfWays = 1;
            }
            else if(lev == maxlev)
            {
                NoOfWays++;
            }
            return;
        }
        // System.out.println("Without spell : Moving to lev : "+(lev+1)+" from "+lev+" and hp : "+(Hp-arr[lev]));
        findNoOfWays(Hp-arr[lev],n,noOfSpells,arr,lev+1);
    }
}
