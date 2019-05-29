# solution2: not in place, n time
def removeString4(str):
	res = [None]
	for index, char in enumerate(str):
		if res[-1] == char:
			res.pop()
		else:
			res.append(char)

	return ''.join(res[1:])  # first index is None

# solution2: n^2 time, n space
def removeDuplicates(self, S: str) -> str:
	s=list(S)
	for j in range(len(s)):
		for i in range(1,len(s)):
			if s[i]==s[i-1]:
				s[i],s[i-1]='0','0'
		t=''.join(s)
		t=list(t.replace('0',''))
		if len(s)==len(t):
			break
		else:
			s=t

	return ''.join(t)

def removeString4(input):
	if input is None or not input:
		return input

	arr = list(input)
	slow = 0
	fast = 1

	while fast < len(arr):
		if slow == -1 or arr[slow] != arr[fast]:
			slow += 1
			arr[slow] = arr[fast]
		else:
			while fast + 1 < len(arr) and arr[fast+1] == arr[slow]:
				fast += 1
			slow -= 1

	return ''.join(arr[:slow+1])
