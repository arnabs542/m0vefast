def getDecimalValue(head):
	if head is None:
		return 0

	res =0
	while head is not None:
		res = res * 2 + head.val
		head= head.next 
	return res