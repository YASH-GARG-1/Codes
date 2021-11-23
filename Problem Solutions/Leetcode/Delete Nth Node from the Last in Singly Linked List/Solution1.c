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

struct ListNode* removeNthFromEnd(struct ListNode* head, int n){
    if(head->next == NULL && n == 1)
    {
        free(head);
        return NULL;
    }
    else
    {
        struct ListNode *ptr1,*ptr2,*prev;
        prev = ptr1 = ptr2 = head;
        while(n>0)
        {
            ptr2 = ptr2->next;
            n--;
        }
        while(ptr2!=NULL)
        {
            prev = ptr1;
            ptr1 = ptr1->next;
            ptr2 = ptr2->next;
        }
        if(prev == ptr1)
        {
            head = head->next;
            free(prev);
            return head;
        }
        prev->next = ptr1->next;
        free(ptr1);
        return head;
    }
}

int main()
{
    int n;
    struct ListNode *l1;
    printf("Creting Linked List :\n");
    l1 = createList();
    printList(l1);
    printf("\nEnter the position of the element from the last which you want to delete : ");
    scanf("%d",&n);
    l1 = removeNthFromEnd(l1,n);
    printf("\nThe Updated list is : ");
    printList(l1);
    printf("\nNow Deleting the List.");
    deleteList(l1);
    printf("\nLists Deleted Successfully!!!");
}