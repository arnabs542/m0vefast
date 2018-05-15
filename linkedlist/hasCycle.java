public boolean hasCycle(ListNode head){
		if (head == null || head.next == null)
			return false;
		ListNode fast = head.next;
		ListNode slow = head;
			while (fast != slow) {
					if(fast==null || fast.next==null)
							return false;
					fast = fast.next.next;
					slow = slow.next;
			}
			return true;
	}

//Return the node where the cycle starts. Return null if there is no cycle.
if (head == null || head.next==null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
