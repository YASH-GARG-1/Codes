import java.util.Scanner;
public class Solution2 {
    //Now checking whetehr a number is prime or not by using a different method. we know that if
    //the square root of a number is divible by a number greater than 1, then it is not a prime number.
    //this approch reduces the time complexity of our program to a great extent.
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = scn.nextInt();
        int flag = 0;
        // flag to tell whether a number if prime of not. 0 if prime and 1 for not prime.
        for(int i = 2;i*i<=n;i++) // Same as cheacking i<=sqrt(n)
        {
            if((n%i)==0) //checking whether n is divisible by i or not.
            {
                flag = 1;
                break;
            }
        }
        if(flag == 0)
        {
            System.out.println(n+" is Prime");
        }
        else
        {
            System.out.println(n+" is Not Prime");
        }
        scn.close(); // closing the Scanner object.
    }
}
