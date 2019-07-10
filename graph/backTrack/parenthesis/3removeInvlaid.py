def removeInvalidParentheses(self, s: str) -> List[str]:
    if s is None or not s:
        return [""]

    # count left and right
    left, right = countLeftRight(s)

    res = []
    self.dfs(0, left, right, res, s)
    return res

def dfs(self, depth, left, right, res, path):
    # base case check
    if left == 0 and right == 0:
        if self.isValid(path):
            res.append(''.join(path))
        return

    # branching factor: every index considering to check/delete
    # depth: left/right
    for i in range(depth, len(path)):
        # duplicate edge case:  ())  remove ) and ) are the same
        if i > depth and path[i] == path[i-1]:
            continue

        if path[i] == '(' and left > 0:
            self.dfs(i, left-1, right, res, path[:i]+path[i+1:])

        if path[i] == ')' and right > 0:
            self.dfs(i, left, right-1, res, path[:i]+path[i+1:])

def countLeftRight(s):
    left = right= 0
    for each in s:
        if each == "(":
            left += 1
        elif each == ')':
            if left > 0:
                left -= 1
            else:
                right += 1
    return left, right


def isValid(self, path):
    left, right = countLeftRight(path)
    return left == 0 and right == 0
