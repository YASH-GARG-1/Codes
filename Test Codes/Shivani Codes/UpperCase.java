import java.util.Scanner;

public class UpperCase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter yur name : ");
        String str = scn.nextLine();

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                int val = ch - 32;
                ch = (char)val;
            }
            System.out.print(ch);
        }
    }
}
