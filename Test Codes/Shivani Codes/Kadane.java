public class Kadane {
    public static void main(String[] args) {
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int arr[] = {10, 20, 30, -20, -32, 100, 12, -2, 20};

        for(int ele : arr)
        {
            sum = sum+ele;
            if(sum > maxSum)
            {
                maxSum = sum;
            }
            if(sum < 0)
            {
                sum = 0;
            }
        }

        System.out.print("Max Sum is : " + maxSum);
    }
}
