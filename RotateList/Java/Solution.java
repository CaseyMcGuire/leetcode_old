public class Solution {

    public ListNode rotateRight(ListNode head, int n) {
        if(n == 0 || head == null) return head;
        ListNode ptr1 = head;
        ListNode ptr2 = head;

        for(int i = 0; i < n; i++){
            ptr2 = ptr2.next;
            if(ptr2 == null) ptr2 = head;
        }

        if(ptr1 == ptr2) return head;
        while(ptr2.next != null){
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }

        ListNode newHead = ptr1.next;
        ptr1.next = null;
        ptr2.next = head;
        return newHead;
    }
}
