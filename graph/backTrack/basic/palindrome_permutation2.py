# Given a string s, return all the palindromic permutations (without duplicates) of it.
# Return an empty list if no palindromic permutation could be form.
'''
这是一个组合问题
首先这个问题要分字符串长度奇偶讨论，如果是奇数，那么还需要枚举中间的字符
接下来我们只需要给字符串左半部做排列即可
我们可以先对字典序小的字符做排列，再在前面字符排列结果基础上对下一类字符做排列
Input: "aabb"
Output: ["abba", "baab"]
'''
# using swap:
def palindrome_permutation2(str):
    counter = collections.Counter(str)
    odd_count = sum(value % 2 for value in counter.values())
    if odd_count <= 1:
        base, mid = self.preprocess(counter)
    else:
        return []

    res = []
    self.dfs(res, list(base), list(mid), 0)
    return res

def preprocess(self, counter):
    base = mid = ''
    for char in counter:
        if counter[char] % 2 == 0:
            mid = char
        else:
            base += char * (counter[char]//2)
    return base, mid

def dfs(self, res, base, mid, depth):
    if len(arr) == 0:
        res.append(''.join(base + mid + base[::-1]))
        return
        
    for index in range(depth, len(arr)):
        if index > depth and (base[i] == base[i-1] or base[i] == base[depth]):
            continue
        base[index], base[depth] = base[depth], base[index]
        self.dfs(res, base, mid, depth+1)
        base[index], base[depth] = base[depth], base[index]
