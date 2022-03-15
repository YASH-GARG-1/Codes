import java.io.*;
import java.util.*;

public class Main{
   
public static int precedence(char opr){
    if(opr == '+' || opr == '-')
        return 1;
    return 2;       // * OR /   
}
public static boolean isOptr(char ch){
    if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
        return true;
    }
    return false;
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<String> postfix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    Stack<Character> optr = new Stack<>();
    
    int n = exp.length();
    for(int i = 0; i<n; i++){
        char ch = exp.charAt(i);
        
        if(ch == '('){
            optr.push(ch);
        }
        else if((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') ){
            postfix.push(String.valueOf(ch));
            prefix.push(String.valueOf(ch));
        }
        else if(ch == ')'){
            while(optr.peek() != '(')
            {
                char op = optr.pop();
                String exp2 = postfix.pop();
                String exp1 = postfix.pop();
                String ans = exp1+exp2+op;
                postfix.push(ans);
                exp2 = prefix.pop();
                exp1 = prefix.pop();
                ans = op + exp1 + exp2;
                prefix.push(ans);
            }
            optr.pop();
        }
        else if(isOptr(ch)){
            while(!optr.empty() && optr.peek() != '(' && precedence(optr.peek()) >= precedence(ch))
            {
                char op = optr.pop();
                String exp2 = postfix.pop();
                String exp1 = postfix.pop();
                String ans = exp1+exp2+op;
                postfix.push(ans);
                exp2 = prefix.pop();
                exp1 = prefix.pop();
                ans = op + exp1 + exp2;
                prefix.push(ans);
            }
            optr.push(ch);
        }
    }
    
    while(optr.size() != 0){
        char op = optr.pop();
            String exp2 = postfix.pop();
            String exp1 = postfix.pop();
            String ans = exp1+exp2+op;
            postfix.push(ans);
            exp2 = prefix.pop();
            exp1 = prefix.pop();
            ans = op + exp1 + exp2;
            prefix.push(ans);
    }
    System.out.println(postfix.peek());
    System.out.println(prefix.peek());
    
 }
}