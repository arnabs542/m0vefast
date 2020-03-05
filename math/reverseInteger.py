def reverseInteger(num):
	# habndle overflow case
	sign = 1 if num > 0 else -1
	num = abs(num)

	res = []
	while num > 0:
		reminder = num % 10
		res.append(reminder)
		num = num // 10

	x = 0
	for i in range(len(res)):
		x = x * 10 + res[i]

	if x > 0x7FFFFFFF:
		return 0
	else:
		return num * sign