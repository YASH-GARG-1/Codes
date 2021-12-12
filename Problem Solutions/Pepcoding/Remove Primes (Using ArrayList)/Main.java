import java.util.*;

public class Main{
    
	public static void solution(ArrayList<Integer> al){
		
		int n,flag;
		for(int i = al.size()-1; i >= 0; i--)
		{
		    flag = 0;
		    n = al.get(i);
		    for(int j = 2; j*j<=n;j++)
		    {
		        if((n%j) == 0)
		        {
		            flag = 1;
		            break;
		        }
		    }
		    if(flag != 1)
		    {
		        al.remove(i);
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
        scn.close();
	}
}