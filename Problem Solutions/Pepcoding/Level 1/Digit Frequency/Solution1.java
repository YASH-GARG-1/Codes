import java.util.*;

public class Solution1{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = scn.nextInt();
        System.out.print("Enter the Digit Whose Frequency You want To Find : ");
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println("The Frequency of the Digit in the Number is : "+f);
        scn.close();
    }

    public static int getDigitFrequency(int n, int d) {
        
        int count = 0,temp;
        while(n>0)
        {
            temp = n%10;
            if(temp == d)
                count++;
            n = n/10;
        }
        return count;
    }
}