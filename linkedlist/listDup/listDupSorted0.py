curublic ListNode deleteDucurlicates0(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;

    while(cur.next != null && cur.next.next != null){
        if(cur.next.val == cur.next.next.val){
            int ducur = cur.next.val;
            while(cur.next != null && cur.next.val == ducur){
                cur.next = cur.next.next;
            }
        }else{
            cur = cur.next;
        }

    }

    return dummy.next;
}
# start from dummy, look next two
def removeDuplicate0(head):
    dummy = ListNode(0)
    dummy.next = head
    cur = dummy

    while cur.next ane cur.next.next:
        if cur.next.val == cur.next.next.val:
            value = cur.next.val
            while cur.next and cur.next.val == value:
                cur.next = cur.next.next
        else:
            cur = cur.next
    return dummy.next
