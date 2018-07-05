//钟表的指针，一个走得快一个走得慢，走得快的一定会在某个时刻追上走得慢的指针
public boolean hasCycle(ListNode head){
	//make sure slow and fast can be initialized
		if (head == null || head.next == null)
			return false;
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != slow) {
			//make sure slow.next and slow.next.next is jumpable
				if(fast==null || fast.next==null)
						return false;
				fast = fast.next.next;
				slow = slow.next;
		}
		return true;
	}
http://umairsaeed.com/blog/2011/06/23/finding-the-start-of-a-loop-in-a-circular-linked-list/
//Return the node where the cycle starts. Return null if there is no cycle.
		if (head == null || head.next==null) {
            return null;
        }
        ListNode fast = head.next;
				ListNode slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }
				//has cycle, need to return now
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
			}
		}
