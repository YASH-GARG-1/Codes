//Program for Swapping 0's and 1's and putting then togther by performin minimum Swaps.

#include <stdio.h>

int minSwaps(int* arr, int n)
{
    int temp,ptr1=0,ptr2=n-1;
    int count0 = 0,count1 = 0,max_count=0,prev=0;
    if(n == 0 || n == 1)
    {
        return 0;
    }
    for(int i = 0; i < n; i++)
    {
        if(arr[i] == 0)
            count0++;
        else
            count1++;
    }
    if(count1 == 0 || count1 == n)
    {
        return 0;
    }
    int count = 0;
    for(int i = 0; i < count1; i++)
    {
        if(arr[i] == 1)
            count += 1;
    }
    max_count = count;
    for(int i = count1;i<n;i++)
    {
        if(arr[i] == 1)
            count++;
        if(arr[prev] == 1)
            count--;
        if(count>max_count)
        {
            max_count = count;
        }
        prev++;
    }
    return (count1-max_count);
}

void printArray(int* arr,int n)
{
    if(n == 0)
    {
        printf("\nThe list is empty!!!");
        return;
    }
    else
    {
        printf("\nThe List is : ");
        for(int i = 0; i < n; i++)
        {
            printf("%d ",arr[i]);
        }
        printf("\n");
        return;
    }
}

int main()
{
    int n,ans;
    printf("\nEnter the size of array : ");
    scanf("%d",&n);
    int arr[n];
    printf("\nEnter the Elements of array : ");
    for(int i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }
    printArray(arr,n);
    ans = minSwaps(arr,n);
    printf("\nThe Minimum no. of Swaps required for Grouping together all 1's are : %d",ans);
    return 0;
}
