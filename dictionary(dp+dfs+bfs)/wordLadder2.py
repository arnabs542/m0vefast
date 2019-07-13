# find all shortest transformation sequence(s) 比如hot->hog->dog->dig和hot->dot->dog->dig
'''
从 end 到 start 做一次 BFS，并且把距离 end 的距离都保存在 distance 中。
然后在从 start 到 end 做一次 DFS，每走一步必须确保离 end 的 distance 越来越近。
'''
def wordladder2(start, end, wordlist):
    wordlist.append(start)
    wordlist.append(end)
    index = build_index(wordList)
    distance = bfs(end, index)
    res = []
    return dfs(start, end, index, distance, [start], res)

def build_index(wordlist):
    index = {}
    for word in wordlist:
        for i in range(len(word)):
            base = word[:i] + "_" + word[i+1:]
            if pattern in index:
                index[pattern].add(word)
            else:
                index[pattern] = set([word])
    '''
    {'_ot': ['hot', 'dot', 'lot'],
    'h_t': ['hot', 'hit'],
    'ho_': ['hot'],
    'd_t': ['dot'],
    'do_': ['dot', 'dog'],
    '_og': ['dog', 'log', 'cog', 'cog'],  # duplicate since we have start and end to the index, so duplicate
    'd_g': ['dog'],
    'l_t': ['lot'],
    'lo_': ['lot', 'log'], ' # duplicate
    l_g': ['log'],
    'c_g': ['cog', 'cog'],   # duplicate
    'co_': ['cog', 'cog'],   # duplicate
    '_it': ['hit'],
    'hi_': ['hit']}
    '''
    return index

# return distance map
def bfs(end, index):
    distance = {end:0}  # visited
    queue = collections.deque([end])

    while queue:
        cur = queue.popleft()
        for nei in get_nei_word(cur, index):
            if nei not in distance:
                queue.append(nei)
                distance[nei] = distance[cur] + 1

    return distance

def dfs(start, end, index, distance, path, res):
    if start == end:
        res.append(path)
        return
    # branching factor:
    # depth: from start to end
    for nei in get_nei_word(start, index):
        if distance[nei] == distance[start] - 1:
            dfs(nei, end, index, distance, path+[nei], res)

def get_nei_word(word, index):
    neightbours = []
    for i in range(len(word)):
        base = word[:i] + "_" + word[i+1:]
        for nei in index.get(base, []):
            neightbours.append(nei)
    return neightbours
