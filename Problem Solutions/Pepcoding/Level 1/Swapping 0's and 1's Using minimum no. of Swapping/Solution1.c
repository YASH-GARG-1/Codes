#include <stdio.h>

void sortingArray(int* arr, int n)
{
    int temp,ptr1=0,ptr2=n-1;
   
    if(n == 0 || n == 1)
    {
        return;
    }
    while(ptr1<ptr2)
    {
        while(arr[ptr1] == 0 && ptr1<n)
        {
            ptr1++;
        }
        while(arr[ptr2] == 1 && ptr2>-1)
        {
            ptr2--;
        }
        if(ptr1<ptr2)
        {
            temp = arr[ptr1];
            arr[ptr1] = arr[ptr2];
            arr[ptr2] = temp;
        }
    }
    return;
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
    int n;
    printf("\nEnter the size of array : ");
    scanf("%d",&n);
    int arr[n];
    printf("\nEnter the Elements of array : ");
    for(int i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }
    printArray(arr,n);
    sortingArray(arr,n);
    printf("\nAfter Swapping, The list is : ");
    printArray(arr,n);
    return 0;
}
