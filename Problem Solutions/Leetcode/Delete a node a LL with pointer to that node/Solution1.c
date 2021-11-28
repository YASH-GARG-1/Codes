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

void deleteNode(struct ListNode* node) {
    struct ListNode* temp;
    temp = node->next;
    node->val = temp->val;
    node->next = temp->next;
    free(temp);
}

int main()
{
    struct ListNode *l1;
    printf("Creating the list : \n");
    l1 = createList();
    printList(l1);
    deleteNode(ptr);
    printf("\nThe Linked List after deleting node is : \n");
    printList(l1);
    deleteList(l1);
}