import java.util.List;
import java.util.ArrayList;
class Solution {
    //~2n time
    //O(n) time, O(n) space
    public static boolean isPalindrome(ListNode head) {
	List<Integer> list = new ArrayList<Integer>();
	ListNode curNode = head;
	while(true) {
	    if(curNode == null) break;
	    list.add(curNode.val);
	    curNode = curNode.next;
	}
	
	int i = 0;
	int j = list.size() - 1;
	while(i < j) {
	    if(list.get(i++).intValue() != list.get(j--).intValue()) {
		return false;
	    }
	}
	return true;
    }

    //~2n time
    //O(n) time, O(1) space
    public static boolean isPalindrome2(ListNode head) {
	int lengthOfList = 0;
	ListNode curNode = head;
	while(true) {
	    if(curNode == null) break;
	    lengthOfList++;
	    curNode = curNode.next;
	}

	curNode = head;
	ListNode prev = head;
	for(int i = 0; i < lengthOfList/2; i++) {

	    if(i == 0) {
		curNode = curNode.next;
		prev.next = null;
	    } else {
		ListNode next = curNode.next;
		curNode.next = prev;
		prev = curNode;
		curNode = next;
	    }
	}

	if(lengthOfList % 2 != 0) curNode = curNode.next;

	while(curNode != null) {
	    if(curNode.val != prev.val) return false;
	    curNode = curNode.next;
	    prev = prev.next;
	}

	return true;
    }
}
