public ListNode mergeSort(ListNode head) {
        //corner case
        if (head == null || head.next == null) {
            return head;
        }

//find middle node and divide into two list
        ListNode mid = findMid(head);
        ListNode l = head;
        ListNode r = mid.next;
        mid.next = null;

//go into the mergeSort
        ListNode h1 = mergeSort(l);
        ListNode h2 = mergeSort(r);
        ListNode result = merge(h1, h2);
        return result;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        if(h1 == null) {
	  return h2;
	}
     	if(h2 == null) {
	  return h1;
	}
        ListNode dummyHead = new ListNode(0);
        ListNode cur1 = h1;
        ListNode cur2 = h2;
        ListNode index = dummyHead;
        while (cur1 != null && cur2 != null) {
            if (h1.value <= h2.value) {  ???
                index.next = cur1;
                cur1 = cur1.next;
                index = index.next;
            } else {
                index.next = cur2;
                cur2 = cur2.next;
                index = index.next;
            }
            if (cur1 == null) {
                index.next = cur2;
            } else if (cur2 == null) {
                index.next = cur1;
            }
        }
        return dummyHead.next;
    }
