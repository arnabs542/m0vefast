# https://leetcode.com/problems/split-a-string-in-balanced-strings/

# Input: s = "RLRRLLRLRL" given a balanced string (number of R = number of L)
# Output: 4
# Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

def balancedStringSplit(str):
	counter = res = 0
	for i in range(len(str)):
		if str[i] == "L":
			counter -= 1
		else:
			counter += 1
		if counter == 0:  # balanced till now 
			res += 1
	return res
