#include<stdio.h>
#include<stdlib.h>
 
 struct ListNode{
     int val;
     struct ListNode *next;
 }*listlast = NULL;
 
int listLen(struct ListNode *temp)
{
    int count = 0;
    while(temp != NULL)
    {
        temp = temp->next;
        count++;
    }
    return count;
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

struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
   
    int len1=0,len2=0,diff;
    struct ListNode *temp1,*temp2,*newnode;
    temp1 = headA;
    temp2 = headB;
    if(headA == NULL || headB == NULL)
    {
        return NULL;
    }
    len1 = listLen(temp1);
    len2 = listLen(temp2);
    if(len1 > len2)
    {
        diff = len1 - len2;
        while(diff>0)
        {
            temp1 = temp1->next;
            diff--;
        }
    }
    else
    {
        diff = len2 - len1;
        while(diff>0)
        {
            temp2 = temp2->next;
            diff--;
        }
    }
    while(temp1!=temp2)
    {
        temp1 = temp1->next;
        temp2 = temp2->next;
    }
    return temp1;
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
    listlast->next = NULL;
    struct ListNode *temp;
    while(head)
    {
        temp = head;
        head = head->next;
        printf("\nDeleting the Element : %d",temp->val);
        free(temp);
    }
}

void intersectNodes(struct ListNode *head1,struct ListNode *head2)
{
    int k,len1,len2,gotCorrectVal = 0,diff;
    struct ListNode *temp;
    len1 = listLen(head1);
    len2 = listLen(head2);
    while(gotCorrectVal == 0)
    {
        printf("\nEnter the Position of Node at which the lists will intersect : ");
        scanf("%d",&k);
        if((k > len1 && k > len2) || k <= 1)
        {
            printf("\nPlease enter a valid value!!!");
        }
        else
        {
            if(len1>len2)
            {
                temp = head2;
                while(temp->next != NULL)
                {
                    temp = temp->next;
                }
                listlast = temp;
                k -= 1;
                temp = head1;
                while(k>0)
                {
                    temp = temp->next;
                    k--;
                }
                listlast->next = temp;
            }
            else
            {
                temp = head1;
                while(temp->next != NULL)
                {
                    temp = temp->next;
                }
                listlast = temp;
                k -= 1;
                temp = head2;
                while(k>0)
                {
                    temp = temp->next;
                    k--;
                }
                listlast->next = temp;
            }
            gotCorrectVal = 1;
        }
    }
}

int main()
{
    struct ListNode *l1,*l2,*temp;
    l1 = createList();
    l2 = createList();
    printList(l1);
    printList(l2);
    intersectNodes(l1,l2);
    temp = getIntersectionNode(l1,l2);
    printf("\nThe Intesecting node is : %d",temp->val);
    deleteList(l1);
    deleteList(l2);
}