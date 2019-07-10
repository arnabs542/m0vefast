def fib(self, N: int) -> int:
	#fib= 0 1 1 2 3
	#  N= 0 1 2 3 4

	if N <= 1:
		return N
	if N == 2:
		return 1
	a = 1
	b = 1
	res = 0

	for i in range(3, N+1):

		res = a + b
		b = a
		a = res
	return res
