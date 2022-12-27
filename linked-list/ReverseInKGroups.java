class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseInKGroups {
    public static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
	 public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = dummy, next = dummy;
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        while (n >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            n -= k;
        }
        return dummy.next;
    }
	 public static void printList(ListNode head) {
		 while (head != null) {
			 System.out.print(head.val + " -> ");
			 head = head.next;
		 }
		 System.out.print("NULL\n");
	 }
	 public static void main(String[] args) {
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 head.next.next = new ListNode(3);
		 head.next.next.next = new ListNode(4);
		 head.next.next.next.next = new ListNode(5);
		 head.next.next.next.next.next = new ListNode(6);
		 head.next.next.next.next.next.next = new ListNode(7);
		 head.next.next.next.next.next.next.next = new ListNode(8);
		 head.next.next.next.next.next.next.next.next = new ListNode(9);
		 head.next.next.next.next.next.next.next.next.next = null;
		 printList(head);
		 printList(reverseKGroup(head, 2));
	 } 
}
