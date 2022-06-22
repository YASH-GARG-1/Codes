// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main{
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        Scanner scn = new Scanner(System.in);
        int input1 = scn.nextInt();
        int input2 = scn.nextInt();
        int input3 = scn.nextInt();
        int input4 = scn.nextInt();
        int input5 = scn.nextInt();
        
        int numArr[] = new int[5];
        numArr[0] = input1;
        numArr[1] = input2;
        numArr[2] = input3;
        numArr[3] = input4;
        numArr[4] = input5;
        int max_stable = Integer.MIN_VALUE;
        int min_stable = Integer.MAX_VALUE;
        
        for(int i = 0; i < 5; i++)
        {
            int arr[] = new int[10];
            int num = numArr[i];
            while(num > 0)
            {
                int rem = num%10;
                arr[rem] = arr[rem] + 1;
                num = num/10;
            }
            int occur = -1;
            int flag = 0;
            for(int j = 0; j < 9; j++)
            {
                if(arr[i]!= 0)
                {
                    if(occur == -1)
                    {
                        occur = arr[i];
                        continue;
                    }
                    else if(occur != arr[i])
                    {
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0)
            {
                max_stable = Math.max(numArr[i], max_stable);
                min_stable = Math.min(numArr[i], min_stable);
            }
        }
        System.out.print(max_stable-min_stable);
    }
}