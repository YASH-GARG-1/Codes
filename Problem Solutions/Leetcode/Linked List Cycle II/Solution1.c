#include<stdio.h>
#include<stdlib.h>
 
struct ListNode{
     int val;
     struct ListNode *next;
 };

struct ListNode *detectCycle(struct ListNode *head) {
    
    struct ListNode *fastptr,*slowptr;
    if(head == NULL || head->next == NULL)
    {
        return NULL;
    }
    slowptr = fastptr = head;
    while(fastptr->next!=NULL && fastptr->next->next != NULL)
    {
        slowptr = slowptr->next;
        fastptr = fastptr->next->next;
        if(slowptr == fastptr)
        {
            break;
        }
    }
    if(fastptr->next == NULL || fastptr->next->next == NULL)
    {
        return NULL;
    }
    fastptr = head;
    while(fastptr != slowptr)
    {
        slowptr = slowptr->next;
        fastptr = fastptr->next;
    }
    return fastptr;
}