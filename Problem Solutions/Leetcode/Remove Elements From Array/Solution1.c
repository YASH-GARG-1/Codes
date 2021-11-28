#include<stdio.h>

int removeElement(int* nums, int numsSize, int val){
    
    int ptr = -1,count = 0;
    if(numsSize == 0)
    {
        return 0;
    }
    for(int i = 0;i<numsSize;i++)
    {
        if(nums[i] != val)
        {
            nums[++ptr] = nums[i];
            count++;
        }
    }
    return count;
}

int main()
{
    int n,val;
    printf("Enter the size of array : ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the Elements of array : ");
    for(int i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }
    printf("Enter the value that you want to delete from the array : ");
    scanf("%d",&val);
    val = removeElement(arr,n,val);
    printf("Array after removing the Duplicate Elements is : ");
    for(int i = 0;i<val;i++)
    {
        printf("%d ",arr[i]);
    }
    return 0;
}