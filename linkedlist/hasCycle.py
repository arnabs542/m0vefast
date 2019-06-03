# 钟表的指针，一个走得快一个走得慢，走得快的一定会在某个时刻追上走得慢的指针
def hasCycle1(head):
	if head is None or head.next is None:
		return False
	slow = head
	fast = head
	while fast.next:  # makesure 1
		fast = fast.next.next
		slow = slow.next
		if fast == slow:  # make sure 2
			return True
		elif fast is None or slow is None:
			return False
	return False

#Return the node where the cycle starts. Return null if there is no cycle.
# no extra space
'''
使用双指针判断链表中是否有环，慢指针每次走一步，快指针每次走两步，若链表中有环，则两指针必定相遇。
假设环的长度为l，环上入口距离链表头距离为a，两指针第一次相遇处距离环入口为b，则另一段环的长度为c=l-b，
由于快指针走过的距离是慢指针的两倍，则有a+l+b=2*(a+b),又有l=b+c，可得a=c，故当判断有环时(slow==fast)时，移动头指针，
同时移动慢指针，两指针相遇处即为环的入口。
'''
def hasCycle2(head):
	# todo



public ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;    		//快指针
        slow = head;				//慢指针
        while (fast != slow) {		//快慢指针相遇
            if(fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow.next) {  //同时移动head和慢指针
            head = head.next;
            slow = slow.next;
        }
        return head;				//两指针相遇处即为环的入口
    }
