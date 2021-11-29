#include<stdio.h>

void moveZeroes(int* nums, int numsSize){
    int count=0,ptr = -1;
    if(numsSize == 0)
    {
        return;
    }
    for(int i = 0;i<numsSize;i++)
    {
        if(nums[i] != 0)
        {
            nums[++ptr] = nums[i];
        }
        else
        {
            count++;
        }
    }
    for(int i = ptr + 1; i < numsSize; i++)
    {
        nums[i] = 0;
    }
}

int main()
{
    int n;
    printf("Enter the size of array : ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the Elements of array : ");
    for(int i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }
    moveZeroes(arr,n);
    printf("Array after Puttting all the zeroes at last is : ");
    for(int i = 0;i<n;i++)
    {
        printf("%d ",arr[i]);
    }
    return 0;
}