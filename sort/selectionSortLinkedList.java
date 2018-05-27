public ListNode select(ListNode head) {
        if (head == null || head.next == null) { // corner case
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curParent = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode minParent = curParent;
            ListNode min = cur;

            ListNode jParent = cur;
            ListNode j = cur.next;

            while (j != null) {
                if (j.value < min.value) {
                    min = j;
                    minParent = jParent;
                }
                jParent = j;
                j = j.next;
            }
            // swap cur and min node;
            curParent.next = min;
            minParent.next = cur;
            ListNode tmp = min.next;
            min.next = cur.next;
            cur.next = tmp;
            // update cur node
            curParent = min;
            cur = min.next;
        }
        return dummy.next;
    }
