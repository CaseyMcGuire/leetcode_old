
class Solution {
    
    public static ListNode swapPairs(ListNode head) {
	if(head == null) return null;
	ListNode curNode = head;
	ListNode newHead = curNode.next != null ? curNode.next : curNode;
	
	while(true) {
	    if(curNode == null || curNode.next == null) {
		break;
	    } 
	    ListNode nextNode = curNode.next != null ? curNode.next.next : null;

	    curNode.next.next = curNode;
	    if(nextNode != null && nextNode.next != null) {
		curNode.next = nextNode.next;
	    } else {
		curNode.next = nextNode;
	    }
	    curNode = nextNode;
	    
	}
	return newHead;
    }

}
