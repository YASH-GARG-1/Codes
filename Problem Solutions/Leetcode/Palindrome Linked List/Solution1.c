#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
 
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
    while(head!=NULL)
    {
        temp = head;
        head = head->next;
        printf("\nDeleting the Element : %d",temp->val);
        free(temp);
    }
}

struct ListNode* reverseList(struct ListNode* head)
{
    struct ListNode *prev,*temp,*nextnode;
    prev = NULL;
    temp = head;
    while(temp!=NULL)
    {
        nextnode = temp->next;
        temp->next = prev;
        prev = temp;
        temp = nextnode;
    }
    return prev;
}

bool isPalindrome(struct ListNode* head){
    
    if(head->next == NULL)
    {
        return true;
    }
    else if(head->next->next == NULL)
    {
        if(head->val == head->next->val)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else
    {
        bool value = true;
        struct ListNode *slowptr,*fastptr,*temp1,*temp2,*temp;
        slowptr = fastptr = head;
        while(fastptr->next != NULL && fastptr->next->next != NULL)
        {
            slowptr = slowptr->next;
            fastptr = fastptr->next->next;
        }
        temp = reverseList(slowptr->next);
        slowptr->next = NULL;
        temp1 = head;
        // printf("\nFirst Half : \n");
        // printList(head);
        temp2 = temp;
        // printf("\nSecond Half : \n");
        // printList(temp);
        while(temp1!=NULL && temp2!=NULL)
        {
            if(temp1->val != temp2->val)
            {
                value = false;
                break;
            }
            temp1 = temp1->next;
            temp2 = temp2->next;
        }
        temp1 = reverseList(temp);
        // printf("\nFirst Half : \n");
        // printList(head);
        // printf("\nseconf Half : \n");
        // printList(temp1);
        slowptr->next = temp1;
        return value;
    }
}

int main()
{
    struct ListNode *l1;
    printf("Creating the list : \n");
    l1 = createList();
    printList(l1);
    if(isPalindrome(l1))
    {
        printf("\nThe Linked List is Palindrome!!\n");
    }
    else
    {
        printf("\nThe Linked List in Not Palindrome!!\n");
    }
    // printList(l1);
    deleteList(l1);
}