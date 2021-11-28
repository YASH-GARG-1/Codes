#include<stdio.h>
#include<stdlib.h>
 
 struct ListNode{
     int val;
     struct ListNode *next;
 };

void reverseList(struct ListNode* ptr[])
{
    struct ListNode *prev,*nextnode,*temp;
    prev = NULL;
    temp = ptr[0];
    ptr[1] = temp;
    while(temp!=NULL)
    {
        nextnode = temp->next;
        temp->next= prev;
        prev = temp;
        temp = nextnode;
    }
    ptr[0] = prev;
    return;
}

struct ListNode* reverseBetween(struct ListNode* head, int left, int right){
    
    if(head->next == NULL || left == right)
    {
        return head;
    }
    else
    {
        struct ListNode *ptr[2];
        struct ListNode *startptr,*endptr,*temp,*prev,*lastptr;
        right = right-left;
        left = left-1;
        prev = NULL;
        startptr = head;
        while(left>0)
        {
            prev = startptr;
            startptr = startptr->next;
            left--;
        }
        
        endptr = startptr;
        
        while(right>0)
        {
            endptr = endptr->next;
            right--;
        }
        
        lastptr = endptr->next;
        endptr->next = NULL;
        
        ptr[0] = startptr;
        ptr[1] = endptr;
        
        reverseList(ptr);
        
        startptr = ptr[0];
        endptr = ptr[1];
        if(prev == NULL)
        {
            endptr->next = lastptr;
            return startptr;
        }
        else
        {
            prev->next = startptr;
            endptr->next = lastptr;
            return head;
        }
    }
}

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

int main()
{
    int left,right;
    struct ListNode *l1,*temp;
    printf("Creating the list : \n");
    l1 = createList();
    printList(l1);
    printf("\nEnter the Position of left Node : ");
    scanf("%d",&left);
    printf("\nEnter the Position of Right Node : ");
    scanf("%d",&right);
    temp = reverseBetween(l1,left,right);
    printf("\nThe Linked List after Reversing between the given range is : \n");
    printList(temp);
    deleteList(temp);
}