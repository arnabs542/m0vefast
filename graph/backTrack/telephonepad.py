#23:["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
def letterCombinations(self, digits: str) -> List[str]:
    index = build_index()
    res []
    dfs(digits, index, "", res, 0)
    return res

def dfs(digits, index, path, res, depth):
    # branching factor: possible choice of curretn digit
    # depth: length of the digits
    if depth == len(digits):
        res.append(path)
        return

    digit = digits[depth]
    candidates = index[digit]
    for candidate in candidates:
        dfs(digits, index, path+candidate, res, depth+1)
    # return
    
def build_index():
    index = collecitons.defaultdict()
    index['2'] = ['a','b','c']
    index['3'] = ['d','e','f']
    index['4'] = ['g','h','i']
    index['5'] = ['j','k','l']
    index['6'] = ['m','n','o']
    index['7'] = ['p','q','r','s']
    index['8'] = ['t','u','v']
    index['9'] = ['w','x','y','z']
    return index
