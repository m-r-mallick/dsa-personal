class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode lastSmallest = null, dummy = new ListNode(-1), iter = head, postIter = head, firstSmallest = null;
        ListNode tail = dummy;
        while (iter != null) {
            postIter = iter.next;
            if (iter.val >= x) {
                iter.next = null;
                tail.next = iter;
                tail = tail.next;
            } else {
                if (lastSmallest == null) {
                    lastSmallest = iter;
                    firstSmallest = lastSmallest;
                } else  {
                    lastSmallest.next = iter;
                    lastSmallest = lastSmallest.next;
                }
            }
            iter = postIter;
        }
        if (lastSmallest != null) lastSmallest.next = dummy.next;
        return firstSmallest != null ? firstSmallest : dummy.next;
    }
}
