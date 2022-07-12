public class CoinChangeRecursive {
    public static void main(String args[])
    {
        int sum = 11;
        int arr[] = {1,2,5};
        System.out.print(coinChangeProblem(sum,arr,arr.length-1,"",0));
    }

    public static int coinChangeProblem(int sum, int arr[], int idx, String str, int coins)
    {
        if(sum < 0)
        {
            return -1;
        }
        if(sum == 0)
        {
            System.out.println(str);
            return coins;
        }
        int ans = -1;
        for(int i = idx; i >= 0; i--)
        {
            int temp = -1;
            if(sum-arr[i] >= 0)
            {
                temp = coinChangeProblem(sum-arr[i], arr, i, str+arr[i], coins+1);
            }
            if(temp != -1)
            {
                if(ans == -1 || temp < ans)
                {
                    ans = temp;
                }
            }
        }
        return ans;
    }
}
