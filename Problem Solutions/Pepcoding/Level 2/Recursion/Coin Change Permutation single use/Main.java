public class Main{
    public static void main(String args[])
    {
        int sum = 10;
        int arr[] = {2,3,5,7};
        System.out.print(coinChangeProblem(sum,arr,"",0));
    }

    public static int coinChangeProblem(int sum, int arr[], String str, int coins)
    {
        if(sum == 0)
        {
            System.out.println(str);
            return 1;
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int val = arr[i];
            arr[i] = -arr[i];
            if(val > 0 && sum-val >= 0)
            {
                ans  += coinChangeProblem(sum-val, arr, str+val, coins+1);
            }
            arr[i] = -arr[i];
        }
        return ans;
    }
}
