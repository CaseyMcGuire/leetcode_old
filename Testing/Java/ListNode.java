package Testing.Java;


public class ListNode {
	    	public int val;
	    	public ListNode next;
	    	public ListNode(int x){
	    		val = x;
	    		next = null;
	    	}
	    	
	    	/**
	    	 * This method prints out the current linked list to the console
	    	 */
	    	public void printList(){
    			ListNode temp = this;
	    		do{
	    			System.out.print(temp.val + "->");
	    			temp = temp.next;
	    		}while(temp != null);
	    		System.out.print("null");
	    		System.out.println();
	    	}
	    	
	    	/**
	    	 * This method creates a linked list whose values are between the low and high value.
	    	 * @param low	The first value in the linked list
	    	 * @param high	The last value in the linked list
	    	 * @return		The head of the linked list
	    	 */
	    	public static ListNode createLinkedList(int low, int high){
	    		if(low>high) return null;
	    		ListNode head = new ListNode(low);
	    		ListNode temp = head;
	    		for(int i = low+1; i <= high; i++){
	    			temp.next = new ListNode(i);
	    			temp = temp.next;
	    		}
	    		return head;
	    	}
	    	
	    	public static ListNode createLinkedList(int[] array){
	    		if(array == null) return null;
	    		ListNode head = new ListNode(array[0]);
	    		ListNode temp = head;
	    		for(int i = 1; i<array.length; i++){
	    			temp.next = new ListNode(array[i]);
	    			temp = temp.next;
	    		}
	    		return head;
	    	}
	    	
	    	/**
	    	 * Return the true if the two nodes have equals values, false otherwise.
	    	 * @param one The first node
	    	 * @param two The second node.
	    	 * @return	True if the nodes are equal, false otherwise.
	    	 */
	    	public boolean equals(ListNode one, ListNode two){
	    		return one.val == two.val;
	    	}
	    	
	    	/**
	    	 * Returns true if the two passed nodes are the heads of equivalent linked lists.
	    	 * @param one
	    	 * @param two
	    	 * @return
	    	 */
	    	public static boolean listEquals(ListNode one, ListNode two){
	    		if(one == null && two == null) return true;
	    		//System.out.println(one);
	    		//System.out.println(two);
	    		while(one != null || two != null){
		    		if(one == null && two != null || one != null && two == null) return false;
		    		if(one.val != two.val) return false;
		    		one = one.next;
		    		two = two.next;
	    		}
	    		return true;
	    	}
	    	
	    	public static boolean isSorted(ListNode head){
	    		for(ListNode cur = head; cur.next != null; cur = cur.next){
	    			if(cur.val>cur.next.val) return false;
	    		}
	    		return true;
	    	}
	    	
	    	
	}
