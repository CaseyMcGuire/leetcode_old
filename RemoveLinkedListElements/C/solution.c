#include "../../Testing/C/ListNode.h"
#include <stdlib.h>
#include <stdio.h>

struct ListNode* removeElements(struct ListNode* head, int val){
  if(head == NULL) return NULL;
  else if(head->next == NULL && head->val == val) {
    free(head);
    return NULL;
  }

  //if the head has the value, we have to find the new head node
  while(head != NULL && head->val == val){
    struct ListNode *temp = NULL;
    if(head->next != NULL) temp = head->next;
    free(head);
    head = temp;
  }
    
  //create ListNode pointer that will iterate through the list
  struct ListNode *iter = head;
  
  while(iter != NULL){
    if(iter->next != NULL && iter->next->val == val){
      struct ListNode *temp = iter->next->next;
      free(iter->next);
      iter->next = temp;
    }else{
      iter = iter->next;
    } 
  }
  return head;
}

void run_test(char *test_name, struct ListNode **input, struct ListNode *expected_result, int element_to_remove){
  struct ListNode *result = removeElements(*input, element_to_remove);
  *input = result;
  int passed = lists_equal(result, expected_result);
  printf("%s", test_name);
  if(passed == 1){
    printf(": PASS");
  }else{
    printf(": FAIL\n");
    printf("Expected : ");
    print_list(expected_result);
    printf("Actual : ");
    print_list(result);
  }
  printf("\n");
}


int main(int argc, char *argv[]){

  struct ListNode *input = NULL;
  struct ListNode *expected_result = NULL;
  
  run_test("Null test", &input, expected_result, 0);

  //remove value from list with only one element
  int arr1[] = {1};
  input = init_list(arr1, 1);
  run_test("Remove single element test", &input, NULL, 1);
  free_list(input);

  //don't remove value from single list
  input = init_list(arr1, 1);
  run_test("Don't remove single element test", &input, input, 0);
  free_list(input);

  //remove multiple head values
  int arr2[] = {1,1,1,1,1,1,1,2};
  input = init_list(arr2, 8);
  int result_arr2[] = {2};
  expected_result = init_list(result_arr2, 1);
  run_test("Remove multiple heads test", &input, expected_result, 1);
  free_list(input);
  print_list(expected_result);
  free_list(expected_result);
  
  int arr3[] = {1,2,3,4,5,6};
  input = init_list(arr3, 6);
  int result_arr3[] = {1,2,3,4,5};
  expected_result = init_list(result_arr3, 5);
  run_test("Remove tail from list", &input, expected_result, 6);
  free_list(input);
  free_list(expected_result);

  int arr4[] = {1,2,3,4,5,6,6};
  input = init_list(arr4, 7);
  int result_arr4[] = {1,2,3,4,5};
  expected_result = init_list(result_arr4, 5);
  run_test("Remove multiple elements at tail of list", &input, expected_result, 6);
  free_list(input);
  free_list(expected_result);

  int arr5[] = {1,2,3,4,5,6};
  input = init_list(arr5, 6);
  int result_arr5[] = {1,2,3,5,6};
  expected_result = init_list(result_arr5, 5);
  run_test("Remove element from middle of list", &input, expected_result, 4);
  free_list(input);
  free_list(expected_result);

  return 0;
}
