'''
given set containing just  () {} [], determin if valid parenthesis
https://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
'''
def isValid(self, s: str) -> bool:
    if s is None or not s:
        return True

    stack = []
    map = {}
    map['('] = ')'
    map['['] = ']'
    map['{'] = '}'

    for i in range(len(s)):
        cur = s[i]
        if cur in map:
            stack.append(cur)
        else:
            if stack and cur == map.get(stack[-1]):
                stack.pop()
            else:
                return False

    if stack:
        return False
    else:
        return True


'''
https://leetcode.com/problems/valid-parenthesis-string/
Given a string containing only three types of characters: '(', ')' and '*',
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Input: "(*))"
Output: True
”(”容易受制于”)”而将其与”*”匹配后就很灵活，不仅避免了数量太多带来的麻烦，也能在和*匹配后再次提供自身给”)”进行匹配。
优先配对的思想, 左括号单独存储，
======== * 1) 优先与落单的(配对，2) 如果没有，则*单独存在，
=====右括号 1) 优先与落单的(配对，2) 如果没有，则与已配对的 (* 的cp中 或者 单独存在的* 配对，3) 如果还没有，则return false。
而且最后，如果有单独的左括号，也return false
'''
       (  *  )  )
Left   1  0
cp     1  2  1  0
       (  )  )  *
       1  0
       1  0  -1false

def isValidString(s):
    left = cp = 0
    for i in range(len(s)):
        cur = s[i]
        if cur == '(':
            left += 1
            cp += 1
        elif cur == "*":
            if left > 0:
                left -= 1
            cp += 1
        else:
            if left > 0:
                left -= 1
            cp -= 1
            if cp < 0:
                return False

    if left > 0:
        return False
    return True
