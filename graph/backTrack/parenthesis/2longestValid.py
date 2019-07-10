'''
https://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/
//find the longest palindrome bracket,Given a string containing just the characters '(' and ')',
//O(n) O(n)
//Special thing is that trick of using i(index) and 0|1 for extra ')', to cover this kind of testcases: )()()) :4  （）（）
'''
def longestValidParentheses(s):
    stack = []  # (index, left/right)   stuff to consider (currenlty not valid)
    res = 0
    for i in range(len(s)):
        cur = s[i]
        if c == '(':
            stack.push((i, 0))
        else:
            if not stack or stack[-1][1] == 1:   # last on stack is )
                stack.push((i, 1))
            else:                               # last on stack is (
                stack.pop()   # this will pop up all existing palindrome
                curlen = 0
                if not stack:
                    curlen = i + 1
                else:
                    curlen = i - stack[-1][0]
                res = max(res, curlen)

    return res
