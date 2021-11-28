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

struct ListNode *reverseList(struct ListNode *l1)
{
    struct ListNode *prev,*temp,*nextp;
    prev = NULL;
    if(l1 == NULL || l1->next == NULL)
    {
        return l1;
    }
    else
    {
        temp = l1;
        nextp = temp->next;
        temp->next = prev;
        while(nextp!=NULL)
        {
            prev = temp;
            temp = nextp;
            nextp = nextp->next;
            temp->next = prev;
        }
        return temp;
    }
}

struct ListNode *addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
   
    struct ListNode *temp1,*temp2,*head=NULL,*newnode;
    int carry = 0;
    if(l1 == NULL)
    {
        return l2;
    }
    else if(l2 == NULL)
    {
        return l1;
    }
    else
    {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        temp1 = l1;
        temp2 = l2;
        while(temp1 != NULL || temp2 != NULL)
        {
            int sum = carry;
            if(temp1 != NULL)
            {
                sum += temp1->val;
                temp1 = temp1->next;
            }
            if(temp2!= NULL)
            {
                sum+= temp2->val;
                temp2 = temp2->next;
            }
            newnode = (struct ListNode*)malloc(sizeof(struct ListNode));
            newnode->val = sum%10;
            newnode->next = NULL;
            carry = sum/10;
            if(head==NULL)
            {
                head = newnode;
            }
            else
            {
                newnode->next = head;
                head = newnode;
            }
        }
       
        if(carry != 0)
        {
            newnode = (struct ListNode*)malloc(sizeof(struct ListNode));
            newnode->next=head;
            newnode->val = carry%10;
            head = newnode;
        }
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        return head;
    }
}

int main()
{
    struct ListNode *l1,*l2,*temp;
    printf("Creating first list : \n");
    l1 = createList();
    printf("Creating second list : \n");
    l2 = createList();
    printList(l1);
    printList(l2);
    temp = addTwoNumbers(l1,l2);
    printf("\nThe addition of Two lists is : \n");
    printList(temp);
    deleteList(l1);
    deleteList(l2);
    deleteList(temp);
}