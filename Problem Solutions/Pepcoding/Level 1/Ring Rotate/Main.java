import java.util.*;

public class Main {

    public static void rotateArray(int arr[],int n,int t)
    {

        // Here arr is the Array, n is the size of array and t is the no. of times we have to
        // rotate the array.
        int ind;
        int arr2[] = new int[n];
        t = (t%n + n)%n;  // This will also work for negative value of t.
        ind = t;
        if(t == 0)
        {
            return;
        }
        for(int i=0;i<n;i++)
        {
            arr2[i] = arr[ind];
            ind = (ind+1)%n;
        }
        for(int i=0;i<n;i++)
        {
            arr[i] = arr2[i];
        }
    }

    public static void ringRotate(int arr[][],int n,int m,int r,int t)
    {
        int flag = 0,i,j,minr,maxr,minc,maxc,ind = -1;
        int s = 2*n + 2*m - 4;
        if((n%2 != 0) && (r > (n/2)))
        {
            flag = 1;
            s = n - 2*(r-1);
        }
        else
        {
            s = s - 8*(r-1);
        }
        int newarr[] = new int[s];
        if(flag == 1)
        {
            //  If the array consists of Odd no of rows and the operation is performed
            //on the Innermost Ring.
            j = i = n/2;
            for(int k = 0;k<s;k++)
            {
                newarr[k] = arr[i][j++];
            }
        }
        else
        {
            minr = minc = r-1;
            maxc = m-r;
            maxr = n-r;
            for(i = minr,j = minc;j<=maxc;j++)
            {
                newarr[++ind] = arr[i][j];
            }
            minr++;
            for(i = minr,j = maxc;i <= maxr;i++)
            {
                newarr[++ind] = arr[i][j];
            }
            maxc--;
            for(i = maxr,j = maxc;j>= minc;j--)
            {
                newarr[++ind] = arr[i][j];
            }
            maxr--;
            for(i = maxr,j = minc;i>=minr;i--)
            {
                newarr[++ind] = arr[i][j];
            }
            minc--;
        }
        rotateArray(newarr,s,t);
        if(flag == 1)
        {
            i = j = r-1;
            for(i = 0;i<s;i++)
            {
                arr[i][j++] = newarr[i];
            }
        }
        else
        {
            ind = -1;
            minr = minc = r-1;
            maxc = m-r;
            maxr = n-r;
            for(i = minr,j = minc;j<=maxc;j++)
            {
                arr[i][j] = newarr[++ind];
            }
            minr++;
            for(i = minr,j = maxc;i <= maxr;i++)
            {
                arr[i][j] = newarr[++ind];
            }
            maxc--;
            for(i = maxr,j = maxc;j>= minc;j--)
            {
                arr[i][j] = newarr[++ind];
            }
            maxr--;
            for(i = maxr,j = minc;i>=minr;i--)
            {
                arr[i][j] = newarr[++ind];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        int r = scn.nextInt();
        int t = scn.nextInt();
        ringRotate(arr,n,m,r,t);
        display(arr);
        scn.close();
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}