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


def tribonacci(n):
	a, b, c = 0, 1, 1
	if n == 0: return 0
	if n < 3: return 1
	
	for i range(3, n+1):
		a, b, c = b, c, a+b+c

	return c