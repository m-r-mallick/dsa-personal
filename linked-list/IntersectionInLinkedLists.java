class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

public class IntersectionInLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = 0, c2 = 0;
        ListNode temp1 = headA, temp2 = headB;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
//			  check if intersection even exists		  
        if (temp1 != temp2) return null;
//         temp11 = headA, temp1 = headA.last
        ListNode temp11 = headA;
        temp1.next = temp11;
//         now traverse listB and find cycle
        ListNode slow = headB, fast = headB;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = headB;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        temp1.next = null;
        return slow;
    }
}
