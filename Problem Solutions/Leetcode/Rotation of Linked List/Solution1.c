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

int listLen(struct ListNode* head)
{
    int count = 0;
    struct ListNode* temp;
    if(head == NULL)
    {
        return 0;
    }
    else
    {
        temp = head;
        while(temp)
        {
            count++;
            temp = temp->next;
        }
        return count;
    }
}

struct ListNode* rotateRight(struct ListNode* head, int k){

    int len,count;
    struct ListNode *prev,*nextn,*temp;
    if(k < 0)
    {
        printf("\nEnter the valid value of k!!!\n");
        return head;
    }
    if(k == 0 || head == NULL || head->next == NULL)
    {
        return head;
    }
    len = listLen(head);
    k = k%len;
    if(k == 0)
    {
        return head;
    }
    count = len - k -1;
    temp = head;
    while(count>0)
    {
        temp = temp->next;
        count--;
    }
    prev = temp;
    nextn = temp = temp->next;
    prev->next = NULL;
    while(nextn->next !=NULL)
    {
        nextn = nextn->next;
    }
    nextn->next = head;
    return temp;
}

int main()
{
    int k;
    struct ListNode *l1,*temp;
    printf("Creating the list : \n");
    l1 = createList();
    printList(l1);
    printf("\nEnter the no. of rotations you want to make from the right : ");
    scanf("%d",&k);
    temp = rotateRight(l1,k);
    printf("\nThe Linked List after Rotating is : \n");
    printList(temp);
    deleteList(temp);
}