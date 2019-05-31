# Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
'''
这是一个组合问题
首先这个问题要分字符串长度奇偶讨论，如果是奇数，那么还需要枚举中间的字符
接下来我们只需要给字符串左半部做排列即可
我们可以先对字典序小的字符做排列，再在前面字符排列结果基础上对下一类字符做排列
Input: "aabb"
Output: ["abba", "baab"]
'''
def generatePalindromes(self, s):
    counter = collections.Counter(s)
    odds_count = sum(value % 2 for value in counter.values())
    if odds_count > 1:
        return []
    else:
        base, mid = self.preprocess(counter)

    res = []
    self.dfs(res, base, mid, 0)
    return res


def preprocess(self, counter):
    base = mid = ''
    for char in counter:
        if counter[char] % 2 == 1:
            mid = char
        base += char * (counter[char]//2)
    return base, mid

def dfs(self, res, base, mid, depth):
    if depth == len(base):
        res.append(base + mid + base[::-1])
        return

    for i in range(depth, len(base)):
        if i > depth and (base[i] == base[i-1] or base[i] == base[depth]):
            continue

        permu = base if i == depth else base[:depth] + base[i] + base[depth+1:i] + base[depth] + base[i+1:]

        self.dfs(res, permu, mid, depth+1)
