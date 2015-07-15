import java.util.*;
public class Solution {

    //O(n) time and O(1) space but basically destroys the list and apparently can't be graded
    public static ListNode detectCycle(ListNode head) {
	if(head == null || !hasCycle(head)) return null;
	ListNode curNode = head;
	for(;;) {
	    if(curNode.next == null) return curNode;
	    ListNode temp = curNode.next;
	    curNode.next = null;
	    curNode = temp;
	}
    }

    public static boolean hasCycle(ListNode head) {
	ListNode fastNode = head.next;
	ListNode slowNode = head;
	if(fastNode == null) return false;
	for(;;) {
	    if(fastNode == slowNode) return true;
	    if((fastNode = fastNode.next) == null) return false;
	    if((fastNode = fastNode.next) == null) return false;
	    slowNode = slowNode.next;
	}
    }

    //O(n) time, O(n) space
    public static ListNode detectCycle2(ListNode head) {
	Set<ListNode> visitedNodes = new HashSet<>();
	ListNode curNode = head;
	while(true) {
	    if(curNode == null) return null;
	    if(visitedNodes.contains(curNode)) return curNode;
	    visitedNodes.add(curNode);
	    curNode = curNode.next;
	}
    }

    public static ListNode detectCycle3(ListNode head) {
	if(head == null) return null;
	ListNode fastNode = head;
	ListNode slowNode = head;
	for(;;) {
	    if((fastNode = fastNode.next) == null) return null;
	    if((fastNode = fastNode.next) == null) return null;
	    slowNode = slowNode.next;
	    if(fastNode == slowNode) break;
	}

	slowNode = head;
	while(slowNode != fastNode) {
	    slowNode = slowNode.next;
	    fastNode = fastNode.next;
	}
	return slowNode;
    }

    public static ListNode getNth(ListNode head, int nth) {
	ListNode curNode = head;
	for(int i = 0 ;; i++) {
	    if(i == nth) return curNode;
	    else curNode = curNode.next;
	}
    }

    public static ListNode getTail(ListNode head) {
	ListNode curNode = head;
	while(curNode.next != null) {
	    curNode = curNode.next;
	}
	return curNode;
    }

}
