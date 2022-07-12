public class CoinChange{
    public static void main(String args[])
    {
        int sum = 10;
        int arr[] = {2,3,5,7};
        System.out.print(coinChangeProblem(sum,arr,"",0));
    }

    public static int coinChangeProblem(int sum, int arr[], String str, int coins)
    {
        if(sum < 0)
        {
            return 0;
        }
        if(sum == 0)
        {
            System.out.println(str);
            return 1;
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(sum-arr[i] >= 0)
            {
                ans  += coinChangeProblem(sum-arr[i], arr, str+arr[i], coins+1);
            }
        }
        return ans;
    }
}
