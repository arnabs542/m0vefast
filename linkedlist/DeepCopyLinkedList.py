#solution1: using hashmap to avoid copy multiple times for the same node
#O(n)
'''
node.value
node.next
node.random
难点: original - copy node的1:!对应关系 避免一个original node 被copy两次, 1,2,3   3.random is 2, but 2 is already copied
- hashmap <originalnode, copiednode>
- .value: 0) valid(no necessary, since while loop)
				1)checkmap,
				 2) copy
- .next: no need
- .random; 1) valid
					2)checkmap
					3)copy
'''
def deepcopylist(head):
	if head is None:
		return head

	dummy = ListNode(0)
	dummy.next = head
	cur = dummy
	dict = {}

	while head:
		# .value
		if head not in dict:
			dict[head] = ListNode(head.val)
		cur.next = dict.get(head)
		# .next no need since for loop
		# .random
		if head.random:
			if head.random not in dict:
				dict[head.random] = ListNode(head.random)
			cur.next.random(dict.get(head.random))
		# update
		cur = cur.next
		head = head.next

	return dummy.next


class Solution:  #O(n)
# @param head, a RandomListNode
# @return a RandomListNode
def copyRandomList(self, head):
    dic = collections.defaultdict(lambda: RandomListNode(0))
    dic[None] = None
    n = head
    while n:
        dic[n].label = n.label
        dic[n].next = dic[n.next]
        dic[n].random = dic[n.random]
        n = n.next
    return dic[head]
