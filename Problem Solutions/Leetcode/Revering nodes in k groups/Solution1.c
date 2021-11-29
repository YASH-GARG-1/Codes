#include<stdio.h>
#include<stdlib.h>

 struct ListNode{
     int val;
     struct ListNode *next;
 };

struct ListNode* createList()
{
    int loopvar = 1;
    struct ListNode *temp,*newnode,*head=NULL;
    while(loopvar)
    {   
        newnode = (struct ListNode*)malloc(sizeof(struct ListNode));
        if(newnode == NULL)
        {
            printf("Error!! Memory not Allocated.");
            return NULL;
        }
        else
        {
            printf("Enter Data : ");
            scanf("%d",&newnode->val);
            newnode->next = NULL;
            if(head == NULL)
            {
                head = temp = newnode;
                head->next = NULL;
            }
            else
            {
                temp->next = newnode;
                temp = newnode;
            }
        }
        printf("Do you want to enter more?? (0/1) : ");
        scanf("%d",&loopvar);
    }
    return head;
}

void printList(struct ListNode *head)
{
    struct ListNode* temp;
    if(head == NULL)
    {
        printf("\nThe list is empty!!!\n");
        return;
    }
    else
    {
        temp = head;
        printf("\nThe List is : ");
        while(temp)
        {
            printf("%d -> ",temp->val);
            temp = temp->next;
        }
        printf("NULL\n");
        return;
    }
}

void deleteList(struct ListNode *head)
{
    struct ListNode *temp;
    while(head)
    {
        temp = head;
        head = head->next;
        printf("\nDeleting the Element : %d",temp->val);
        free(temp);
    }
}

void reverseList(struct ListNode *ptr[])
{
    struct ListNode *prev,*nextnode,*temp;
    prev = NULL;
    temp = ptr[0];
    ptr[1] = ptr[0];
    while(temp!=NULL)
    {
        nextnode = temp->next;
        temp->next = prev;
        prev = temp;
        temp = nextnode;
    }
    ptr[0] = prev;
}

struct ListNode* reverseKGroup(struct ListNode* head, int k){
    
    int count = k;
    struct ListNode *prev,*nextptr,*startptr,*endptr;
    struct ListNode *ptr[2];
    
    if(head->next == NULL || k == 1)
    {
        return head;
    }
    
    prev = startptr = head;
    
    while(startptr != NULL)
    {
        count = k;
        endptr = startptr;
        while(count>1&&endptr!=NULL)
        {
            endptr = endptr->next;
            count--;
        }
        if(count != 1 || endptr == NULL)
        {
            return head;
        }
        else
        nextptr = endptr->next;
        endptr->next = NULL;
        ptr[0] = startptr;
        ptr[1] = endptr;
        reverseList(ptr);
        startptr = ptr[0];
        endptr = ptr[1];
        if(head == endptr)
        {
            head = startptr;
            prev = endptr;
            endptr->next = nextptr;
            startptr = nextptr;
        }
        else
        {
            prev->next = startptr;
            endptr->next = nextptr;
            prev = endptr;
            startptr = nextptr;
        }
    }
    return head;
}

int main()
{
    int k;
    struct ListNode *l1;
    printf("Creating the list : \n");
    l1 = createList();
    printList(l1);
    printf("Enter the value of K : ");
    scanf("%d",&k);
    l1 = reverseKGroup(l1,k);
    printf("\nThe Linked List after Swapping in K groups is : \n");
    printList(l1);
    deleteList(l1);
}