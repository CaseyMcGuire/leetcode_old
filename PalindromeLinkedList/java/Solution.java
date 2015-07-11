import java.util.List;
import java.util.ArrayList;
class Solution {
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
}
