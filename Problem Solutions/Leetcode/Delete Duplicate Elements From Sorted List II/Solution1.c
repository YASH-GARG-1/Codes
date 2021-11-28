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

struct ListNode* deleteDuplicates(struct ListNode* head){
    
    if(head == NULL || head->next == NULL)
    {
        return head;
    }
    struct ListNode *prev,*temp,*startptr,*endptr;
    prev = startptr = head;
    while(startptr != NULL)
    {
        if(startptr->next != NULL && startptr->next->val == startptr->val)
        {
            endptr = startptr->next;
            while(endptr!=NULL && startptr->val == endptr->val)
            {
                temp = endptr;
                endptr = endptr->next;
                free(temp);
            }
            if(startptr == head)
            {
                free(startptr);
                startptr = head = prev = endptr;
            }
            else
            {
                free(startptr);
                prev->next = endptr;
                startptr = endptr;
            }
        }
        else
        {
            prev = startptr;
            startptr = startptr->next;
        }
    }
    return head;
}

int main()
{
    int val;
    struct ListNode *l1;
    printf("Creating the list : \n");
    l1 = createList();
    printList(l1);
    l1 = deleteDuplicates(l1);
    printf("\nThe Linked List after Deleting Duplicate nodes is : \n");
    printList(l1);
    deleteList(l1);
}