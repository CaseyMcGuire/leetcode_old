import Testing.Java.*;

public class Solution{
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
	if(headA == null || headB == null) return null;
	int lengthOfListA = getLengthOfList(headA);
	int lengthOfListB = getLengthOfList(headB);
    
	ListNode firstList, secondList;

	if(lengthOfListA > lengthOfListB){
	    firstList = headB;
	    secondList = getNthNode(headA, lengthOfListA - lengthOfListB);
	}
	else if(lengthOfListA < lengthOfListB){
	    firstList = headA;
	    secondList = getNthNode(headB, lengthOfListB - lengthOfListA);
	}else{
	    firstList = headA;
	    secondList = headB;
	}
	
	
	while(firstList != null){
	    if(firstList == secondList) return firstList;
	    firstList = firstList.next;
	    secondList = secondList.next;
	}
	
	return null;
    }
    
    public static int getLengthOfList(ListNode head){
	if(head == null) return 0;
	int length = 1;
	while(head != null){
	    length++;
	    head = head.next;
	}
	return length;
    }

    public static ListNode getNthNode(ListNode head, int index){
	for(int i = 0; i < index; i++){
	    head = head.next;
	}
	return head;
    }
}
