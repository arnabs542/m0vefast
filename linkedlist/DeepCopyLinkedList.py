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
def copyRandomList(self, head: 'Node') -> 'Node':
	dic = dict()
	m = n = head
	while m:
		dic[m] = Node(m.val, None, None)
		m = m.next
	while n:
		dic[n].next = dic.get(n.next)
		dic[n].random = dic.get(n.random)
		n = n.next
	return dic.get(head)
