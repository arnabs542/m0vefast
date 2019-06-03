'''
 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL

close list to a ring
Compute the length of the list and close list
Find the new tail ----> (n - k % n - 1)th node
     the new head---> (n - k % n)th node.
Break the ring:::: new_tail.next = None
 '''
def rotateByK(head, k):
    if head is None or head.next is None:
        return head

        # close list to a ring and compute length
        length = 1
        cur = head
        while cur.next:
            cur = cur.next
            length += 1
        cur.next = head

        # find new tail : (n - k % n - 1)th node
        # and new head : (n - k % n)th node  or n - k) th node
        new_tail = head
        #new_head
        while in range(length - k % length - 1):
            new_tail = new_tail.next
        new_head = new_tail.next

        #break the ring
        new_tail.next = None
        return new_head
