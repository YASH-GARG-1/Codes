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

struct ListNode* swapPairs(struct ListNode* head){
    struct ListNode *temp,*prev,*nextnode,*prevconn;
    prev = temp = nextnode = head;
    prevconn = NULL;
    
    if(head == NULL || head->next == NULL)
    {
        return head;
    }
    else
    {
        temp = temp->next;
        nextnode = temp->next;
        temp->next = prev;
        prev->next = nextnode;
        head = temp;
        prevconn = prev;
        while(nextnode != NULL && nextnode->next != NULL)
        {
            prev = nextnode;
            temp = nextnode->next;
            nextnode = nextnode->next->next;
            temp->next = prev;
            prev->next = nextnode;
            prevconn->next = temp;
            prevconn = prev;
        }
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
    l1 = swapPairs(l1);
    printf("\nThe Updated list is : ");
    printList(l1);
    printf("\nNow Deleting the List.");
    deleteList(l1);
    printf("\nLists Deleted Successfully!!!");
}