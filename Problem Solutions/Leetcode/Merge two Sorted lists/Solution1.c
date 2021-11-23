#include<stdio.h>
#include<stdlib.h>

struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode* createList()
{
    int l = 1;
    struct ListNode *newnode,*temp,*l1;
    l1 = NULL;
    while(l)
    {
        newnode = (struct ListNode*)malloc(sizeof(struct ListNode));
        if(newnode == NULL)
        {
            printf("Error!! The Node was not Created.");
            return NULL;
        }
        printf("Enter the data : ");
        scanf("%d",&newnode->val);
        newnode->next = NULL;
        if(l1 == NULL)
        {
            l1 = temp = newnode;
        }
        else
        {
            temp->next = newnode;
            temp = newnode;
        }
        printf("Do you want to enter more elements (enter 0/1) : ");
        scanf("%d",&l);
    }
    return l1;
}

struct ListNode *mergingLists(struct ListNode *l1, struct ListNode *l2)
{
    struct ListNode *prev, *temp1, *temp2, *starting, *ending;
    temp1 = l1;
    temp2 = l2;
    prev = l1;
    while (temp2 != NULL)
    {
        while (temp1 != NULL && temp1->val <= temp2->val)
        {
            prev = temp1;
            temp1 = temp1->next;
        }
        if (temp1 == NULL)
        {
            prev->next = temp2;
            return l1;
        }
        else
        {
            // prev->next = temp2;
            // temp2 = temp2->next;
            // prev = prev->next;
            // prev->next = temp1;
            starting = ending = temp2;
            while (temp2 != NULL && temp2->val <= temp1->val)
            {
                ending = temp2;
                temp2 = temp2->next;
            }
            prev->next = starting;
            ending->next = temp1;
            prev = ending;
        }
    }
    return l1;
}

struct ListNode *mergeTwoLists(struct ListNode *l1, struct ListNode *l2)
{

    if (l1 == NULL)
    {
        return l2;
    }
    else if (l2 == NULL)
    {
        return l1;
    }
    else if (l1->val < l2->val)
    {
        return mergingLists(l1, l2);
    }
    else
    {
        return mergingLists(l2, l1);
    }
}

void printList(struct ListNode* head)
{
    if(head == NULL)
    {
        printf("\nThe List is Empty!!!");
        return;
    }
    else
    {
        struct ListNode *temp;
        temp = head;
        printf("\nThe List is : ");
        while(temp)
        {
            printf("%d -> ",temp->val);
            temp = temp->next;
        }
        printf("NULL\n");
    }
}

void deleteList(struct ListNode* head)
{
    struct ListNode* temp;
    while(head)
    {
        temp = head;
        head = head->next;
        printf("\nDeleting Element : %d",temp->val);
        free(temp);
    }   
}

int main()
{
    struct ListNode *l1,*l2;
    l1 = createList();
    l2 = createList();
    printList(l1);
    printList(l2);
    printf("\nNow Merging Two Lists....");
    l1 = mergeTwoLists(l1,l2);
    printf("\nThe Merged list is : ");
    printList(l1);
    printf("\nNow Deleting the Merged Lists.");
    deleteList(l1);
    printf("\nLists Deleted Successfully!!!");
}