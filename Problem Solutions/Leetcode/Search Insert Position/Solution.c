#include<stdio.h>
#include<stdlib.h>

int searchInsert(int* nums, int numsSize, int target){

    int mid, l = 0, r = numsSize -1;
    if(nums[0] >= target)
    {
        return 0;
    }
    else if(nums[numsSize - 1] < target)
    {
        return numsSize;
    }
    else if(nums[numsSize - 1] == target)
    {
        return numsSize-1;
    }
    else
    {
        while(l<=r)
        {
            mid = l + (r-l)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] > target)
            {
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        return l;
    }
}

int main()
{
    int n,ele,ind;
    printf("Enter the Size of Array : ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the Elements of Array : ");
    for(int i = 0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    printf("Enter the Target Element : ");
    scanf("%d",&ele);
    ind = searchInsert(arr,n,ele);
    printf("The Index for inserting the Target Element is : %d",ind);
    return 0;
}