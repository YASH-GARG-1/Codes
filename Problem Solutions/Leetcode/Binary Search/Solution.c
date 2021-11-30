#include<stdio.h>

int search(int* nums, int numsSize, int target){

    int l = 0,h = numsSize - 1,mid;
    while(l<=h)
    {
        mid = l + (h-l)/2;
        if(nums[mid] == target)
        {
            return mid;
        }
        else if(nums[mid] > target)
        {
            h = mid-1;
        }
        else
        {
            l = mid+1;
        }
    }
    return -1;
}

int main()
{
    int n,ele,ind;
    printf("Enter the Size of array : ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the Elements of Array : ");
    for(int i = 0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    printf("Enter the Element you want ot search in array : ");
    scanf("%d",&ele);
    ind = search(arr,n,ele);
    if(ind == -1)
    {
        printf("Element Not Found in the Array!!");
    }
    else
    {
        printf("Element Found at Index : %d",ind);
    }
    return 0;
}