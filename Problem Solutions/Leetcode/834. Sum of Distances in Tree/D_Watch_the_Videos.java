import java.util.*;

public class D_Watch_the_Videos
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int mem = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        long totalTime = 0;
        int prev = 0;
        boolean chance = false;
        int i,j;
        for(i = 0,j=n-1; i <= j;)
        {
            // System.out.println("chance : " + chance + " i : " + i + " j : " + j + " tot : " + totalTime + " pev : " + prev);
            if(chance)
            {
                if(arr[i] + prev <= mem)
                {
                    totalTime += arr[i];
                    prev = arr[i];
                }
                else
                {
                    totalTime += arr[i] + 1;
                    prev = arr[i];
                }
                i++;
                chance = false;
            }
            else
            {
                // while(arr[j] + arr[i] > mem && i != j)
                // {
                //     if(prev != 0)
                //     {
                //         totalTime += 1 + arr[j];
                //         // prev = arr[j];
                //         prev = arr[j];
                //     }
                //     else
                //     {
                //         totalTime += arr[j];
                //         prev = arr[j];
                //     }
                //     j--;
                // }
                // if(arr[i] + arr[j] > mem)
                // {
                //     if(prev != 0)
                //     {
                //         totalTime += 1;
                //     }
                //     totalTime += arr[j];
                //     prev = arr[j];
                //     j--;
                // }
                if(arr[j] + prev <= mem)
                {
                    totalTime += arr[j];
                    prev = arr[j];
                    j--;
                    chance = true;
                }
                else
                {
                    totalTime += arr[j] + 1;
                    prev = arr[j];
                    j--;
                    chance = true;
                }
            }
        }
        System.out.print(totalTime + 1);
        scn.close();
    }
}