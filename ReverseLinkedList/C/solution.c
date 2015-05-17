#include "../../Testing/C/ListNode.h"
#include <stdlib.h>
#include <stdio.h>

struct ListNode* reverse(struct ListNode *node);
struct ListNode* reverseList(struct ListNode *head);

struct ListNode* reverseList(struct ListNode* head){
  if(head == NULL) return NULL;
  else if(head->next == NULL) return head;
  else{
    
    struct ListNode *new_head = reverse(head);
    head->next = NULL;
    return new_head;
  }
}

struct ListNode* reverse(struct ListNode* node){

  //we're in the last node
  if(node->next->next == NULL) {
    node->next->next = node;
    return node->next;
  }
  else{
    struct ListNode *new_head = reverse(node->next);
    node->next->next = node;
    return new_head;
  }
}

int main(int argc, char *argv[]){
  int arr[] = {1};
  struct ListNode *head = init_list(arr, 1);
  printf("%i\n", arr[0]);
  print_list(head);
  head = reverseList(head);
  print_list(head);
}
