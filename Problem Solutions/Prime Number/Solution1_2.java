import java.io.*;
class Solution1_2{
    // We can check whether a number is prime or not by simply dividing the given number with all the numbers that are less then
    //it, except 1 as every number is divisible by 1.

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a Number : ");
        int n = Integer.parseInt(br.readLine()); // taking the input from the user.
        int flag = 0; //if flag is 0, the number is prime. If flag = 1, the number is number is not prime.
        for(int i = 2;i<n;i++)
        {
            // checking whether the number is divible by any number in the range 2 to n-1.
            if((n%i)==0)
            {
                flag = 1; // As the number is divisible by the value of i, hence it is not a prime no.
                break; // to break the loop as there is no more need to check for other numbers.
            }
        }
        if(flag == 0)
        {
            System.out.println("The number "+n +" is Prime.");
        }
        else
        {
            System.out.println("The number "+n +" is Not Prime.");
        }
    }
}
