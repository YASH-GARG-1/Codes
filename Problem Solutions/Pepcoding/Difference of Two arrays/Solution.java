import java.util.*;

public class Solution{

public static int[] differenceOfArrays(int n,int arr[],int m,int arr2[])
{
    int i,j,k,carry = 0;
    int arr3[] = new int[m];
    i = n-1;
    j = m-1;
    k = m-1;
    while(i >= 0)
    {
        if((carry + arr2[j]) >= (arr[i]))
        {
            arr3[k] = (carry + arr2[j] - arr[i]);
            carry = 0;
        }
        else
        {
            arr3[k] = (carry + arr2[j] + 10 - arr[i]);
            carry = -1;
        }
        i--;
        j--;
        k--;
    }
    while(j >= 0)
    {
        if((carry + arr2[j]) >= 0)
        {
            arr3[k] = (carry + arr2[j]);
            carry = 0;
        }
        else
        {
            arr3[k] = (carry + 10 + arr2[j]);
            carry = -1;
        }
        k--;
        j--;
    }
    return arr3;
}

public static void main(String[] args) throws Exception {
    
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the Size of Array 1 : ");
    int n = scn.nextInt();
    System.out.print("Enter the elements of array : ");
    int arr[] = new int[n];
    for(int i = 0;i<n; i++)
    {
        arr[i] = scn.nextInt();
    }
    System.out.print("Enter the Size of Array 2 : ");
    int m = scn.nextInt();
    System.out.print("Enter the elements of array : ");
    int arr2[] = new int[m];
    for(int i = 0;i<m; i++)
    {
        arr2[i] = scn.nextInt();
    }
    int arr3[] = differenceOfArrays(n,arr,m,arr2);
    System.out.print("The Difference of Two arrays is : ");
    int fnzi = -1;
    for(int i = 0; i<m; i++){
        if(arr3[i] != 0){
            fnzi = i;
            break;
        }
    }
    if(fnzi == -1){
        System.out.print("0");
    }
    for(int i = fnzi; i<m; i++){
        System.out.print(arr3[i]);
    }
    scn.close();
 }

}