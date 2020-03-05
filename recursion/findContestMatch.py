https://leetcode.com/problems/output-contest-matches/
def findContestMatch(n):
	if n % 2 == 1:
		return []

	nums = map(str, range(1, n+1))
	# 1,2,3,4
	res = []
	for i in range(1, n // 2 + 1):
		res.extend("(" + nums[i] + "," + nums[n - 1 - i] + ")")


	return res







'''
Input: 8
Output: (((1,8),(4,5)),((2,7),(3,6)))
Explanation: 
First round: (1,8),(2,7),(3,6),(4,5)
Second round: ((1,8),(4,5)),((2,7),(3,6))
Third round: (((1,8),(4,5)),((2,7),(3,6)))
Since the third round will generate the final winner, you need to output the answer (((1,8),(4,5)),((2,7),(3,6))).
'''



 def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        def helper(array):
            if len(array) == 1:
            	return array[0]
            res = []
            for i in range(len(array)/2):
                res.append('('+array[i]+','+array[len(array)-1-i]+')')
            return helper(res)


        a = list(map(str,range(1,n+1)))  #  map returns a map object not a list:
        return helper(a)