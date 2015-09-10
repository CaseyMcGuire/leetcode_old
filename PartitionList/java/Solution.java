import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public ListNode partition(ListNode head, int x) {
	if(head == null) return null;
	Deque<ListNode> nodesGreaterThan = new LinkedList<ListNode>();
	Deque<ListNode> nodesLessThan = new LinkedList<ListNode>();

	ListNode curNode = head;
	while(curNode != null) {
	    if(curNode.val < x) {
		nodesLessThan.addLast(curNode);
	    }
	    else {
		nodesGreaterThan.addLast(curNode);
	    }
	    curNode = curNode.next;
	}
	
	ListNode newHead = null;
	while(!nodesLessThan.isEmpty()) {
	    if(newHead == null) {
		newHead = nodesLessThan.removeFirst();
		curNode = newHead;
	    }
	    else {
		curNode.next = nodesLessThan.removeFirst();
		curNode = curNode.next;
	    }
	}
	
	while(!nodesGreaterThan.isEmpty()) {
	    if(newHead == null) {
		newHead = nodesGreaterThan.removeFirst();
		curNode = newHead;
	    }
	    else {
		curNode.next = nodesGreaterThan.removeFirst();
		curNode = curNode.next;
	    }
	}
	curNode.next = null;
	
	return newHead;
    }


    public static void runTest(ListNode result, ListNode expected) {
	if(!result.equals(expected)) {
	    System.out.println("PASS");
	} else {
	    System.out.println("FAIL. Expected: " + expected + " Result: " + result);
	}
    }

    public static void main(String[] args) {
	Solution solution = new Solution();
	ListNode test1 = ListNode.createLinkedList(new int[]{1,4,3,2,5,2});
	ListNode expected1 = ListNode.createLinkedList(new int[]{1,2,2,4,3,5});
	runTest(solution.partition(test1, 3), expected1);
    }

}
