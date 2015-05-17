#include <stdio.h>
#include <stdlib.h>
#include "ListNode.h" 
/*
struct ListNode{
  int val;
  struct ListNode *next;
  };
*/
void init_node(struct ListNode** node){
  *node = (struct ListNode*) malloc(sizeof(struct ListNode));
}

struct ListNode* init_list(int values[], int length){
  struct ListNode *head;
  struct ListNode *iter;
  
  //initialize the first node
  int i;
  init_node(&iter);
  iter->val = values[0];
  printf("%i\n",iter->val);
  head = iter;
    
  //initialize our nodes
  for(i = 1; i < length; i++){
    init_node(&(iter->next));
    iter = iter->next;
    iter->val = values[i];

  }
  return head;
}

void free_list(struct ListNode *head){
  struct ListNode *iter = head;
  while(iter != NULL){
    head = head->next;
    free(iter);
    iter = head;
  }
}

void print_list(struct ListNode *head){

  while(head != NULL){
    if(head->next != NULL) printf("%i -> ", head->val);
    else printf("%i", head->val);
    head = head->next;
  }
  printf("\n");
}

int lists_equal(struct ListNode *head1, struct ListNode *head2){
  
  return 0;
}
