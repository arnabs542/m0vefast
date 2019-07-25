# find the shortest transformation, return int
#
def wordladder1(start, end, wordlist):
    index = build_index(wordlist)
    return bfs(index, start, end)
'''
这里寻找下一个变换单词的方法是建立 index，即，如果有一个单词 abc，分别去掉第1,2,3个字符之后，把 abc 这个单词分别扔进
%bc, a%c, ab% 这三个不同的 key 的 hash 里。hash 里的 key 是去掉一个字符之后的 pattern，value 是一个 set，保存满足这个
pattern 的所有单词。
'''
def build_index(wordlist):
    map = {}
    for word in wordlist:
        for i in range(len(word)):
            s = word[:i] + "_" + word[i+1:]
            map[s] = map.get(s, []) + [word]
    '''
    "hit"
    "cog"
    ["hot","dot","dog","lot","log","cog"]

    {'_ot': ['hot', 'dot', 'lot'],
     'h_t': ['hot'],
     'ho_': ['hot'],
     'd_t': ['dot'],
     'do_': ['dot', 'dog'],
     '_og': ['dog', 'log', 'cog'],
     'd_g': ['dog'],
     'l_t': ['lot'],
     'lo_': ['lot', 'log'],
     'l_g': ['log'],
     'c_g': ['cog'],
     'co_': ['cog']}
    '''
    return map

def bfs(index, start, end):
    queue = collections.deque([(start, 1)])
    visited = set()

    while queue:
        cur, step = queue.popleft()
        if cur not in visited:
            visited.add(cur)
            if cur == end:
                return step
            for nei in get_nei_word(cur, index):
                if nei not in visited:
                    queue.append((nei, stpe+1))

    return 0

def get_nei_word(self, word, indexes):
    words = []
    for i in range(len(word)):
        key = word[:i] + '_' + word[i + 1:]
        for w in indexes.get(key, []):
            words.append(w)
    return words


# time out
def wordladder1(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
    if wordList is None or len(wordList) == 0 or endWord not in wordList:
        return 0
    if beginWord == endWord:
        return 0

    step = 0
    queue = collections.deque([beginWord])
    visited = set([beginWord])

    while queue:
        # cur = queue.popleft()
        step += 1
        for i in range(len(queue)):
            cur = queue.popleft()
            if cur == endWord:
                return step

            for nei in self.get_nei_word(cur):
                if nei in wordList and nei not in visited:
                    queue.append(nei)
                    visited.add(nei)

    return 0

def get_nei_word(self, cur):
    res = []
    letters = "abcdefghijklmnopqrstuvwxyz"
    for i in range(len(cur)):
        left, right = cur[:i], cur[i+1:]
        for replacement in letters:
            if cur[i] != replacement:
                res.append(left+replacement+right)
    return res
