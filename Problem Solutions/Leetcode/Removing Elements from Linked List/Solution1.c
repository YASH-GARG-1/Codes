#include<stdio.h>
#include<stdlib.h>
 
 struct ListNode{
     int val;
     struct ListNode *next;
 }*ptr=NULL;

struct ListNode* createList()
{
    int loopvar = 1,count = 0;
    struct ListNode *temp,*newnode,*head=NULL;
    while(loopvar)
    {   count++;
        newnode = (struct ListNode*)malloc(sizeof(struct ListNode));
        if(newnode == NULL)
        {
            printf("Error!! Memory not Allocated.");
            return NULL;
        }
        else
        {
            if(count == 3)
            {
                ptr = newnode;
            }
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

struct ListNode* removeElements(struct ListNode* head, int val){
    struct ListNode* temp,*prev;
    temp = head;
    while(temp != NULL && temp->val == val)
    {
        temp = temp->next;
        free(head);
        head = temp;
    }
    if(temp == NULL)
    {
        return NULL;
    }
    else
    {
        prev = temp;
        while(temp != NULL)
        {
            if(temp != NULL && temp->val == val)
            {
                prev->next = temp->next;
                free(temp);
                temp = prev->next;
            }
            else
            {
                prev = temp;
                temp = temp->next;
            }
        }
        return head;
    }
    
}

int main()
{
    int val;
    struct ListNode *l1;
    printf("Creating the list : \n");
    l1 = createList();
    printList(l1);
    printf("Enter the value that you want to remove from the list : ");
    scanf("%d",&val);
    l1 = removeElements(l1,val);
    printf("\nThe Linked List after deleting node is : \n");
    printList(l1);
    deleteList(l1);
}