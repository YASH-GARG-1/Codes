// Remove Duplicates in a sorted array.

#include<stdio.h>

int removeDuplicates(int* nums, int numsSize){
    int count = 0,prevEle,prevInd=0;
    if(numsSize == 0)
    {
        return 0;
    }
    prevEle = nums[0];
    count++;
    for(int i = 1;i<numsSize;i++)
    {
        if(nums[i] != prevEle)
        {
            nums[++prevInd] = nums[i];
            prevEle = nums[i];
            count++;
        }
    }
    return count;
}

int main()
{
    int n;
    printf("Enter the size of Array : ");
    scanf("%d",&n);
    int arr[n],count = 0;
    printf("Enter the elements of Array (In Ascending Order) : ");
    for(int i = 0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    count = removeDuplicates(arr,n);
    printf("The no. of Non-Duplicate Elements in the array are : %d\n",count);
    printf("The array is : ");
    for(int i = 0;i<n;i++)
    {
        printf("%d ",arr[i]);
    }
    return 0;
}