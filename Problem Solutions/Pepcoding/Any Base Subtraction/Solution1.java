import java.util.*;

public class Solution1{

    public static void main(String[] args) {

        int d;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Base : ");
        int b = scn.nextInt();
        System.out.print("Enter the First Number : ");
        int n1 = scn.nextInt();
        System.out.print("Enter the Second Number : ");
        int n2 = scn.nextInt();
        if (n1 < n2)
            d = getDifference(b, n1, n2);
        else
            d = getDifference(b, n2, n1);
        System.out.println("The Ans after Substracting Bigger Number from Smaller Number is : "+d);
        scn.close();
    }

    public static int getDifference(int b, int n1, int n2) {
        // write your code here
        int carry = 0, temp, temp2, ans = 0, mul = 1;
        if (n1 == n2) {
            return 0;
        }

        while (n2 > 0) {
            temp = n1 % 10;
            temp2 = n2 % 10;
            if ((carry + temp2) >= temp) {
                ans += (carry + temp2 - temp) * mul;
                carry = 0;
            } else {
                ans += (carry + temp2 + b - temp) * mul;
                carry = -1;
            }
            mul *= 10;
            n2 = n2 / 10;
            n1 = n1 / 10;
        }
        return ans;
    }

}