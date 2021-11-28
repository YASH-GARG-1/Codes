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

struct ListNode* middleNode(struct ListNode* head){
    
    if(head->next == NULL)
    {
        return head;
    }
    else if(head->next->next == NULL)
    {
        return head->next;
    }
    else
    {
        struct ListNode *fastptr,*slowptr;
        fastptr = slowptr = head;
        while(fastptr!=NULL && fastptr->next != NULL)
        {
            slowptr = slowptr->next;
            fastptr = fastptr->next->next;
        }
        return slowptr;
    }
}

int main()
{
    struct ListNode *l1,*temp;
    printf("Creating the list : \n");
    l1 = createList();
    printList(l1);
    temp = middleNode(l1);
    printf("\nThe Middle Node of the Linked List is : %d\n",temp->val);
    deleteList(l1);
}