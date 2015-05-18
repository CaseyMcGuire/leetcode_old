#ifndef __LISTNODE__
#define __LISTNODE__ 

struct ListNode{
  int val;
  struct ListNode *next;
};

void init_node(struct ListNode** node);
struct ListNode* init_list(int values[], int length);
void print_list(struct ListNode *head);
int lists_equal(struct ListNode *head1, struct ListNode *head2);
void free_list(struct ListNode *head);

#endif
