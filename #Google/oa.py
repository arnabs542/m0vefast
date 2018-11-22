import collections
# Google 麵筋

# 第一道:找到最长的字符串的长度，要求这个子字符串的头字符和尾字符相同。
# 如 abdcbe, 则最长的是 bdcb,头 b 和尾 b 相同，返回 4。要求时间复杂度 O(n)。
def sol(s):
	dic = collections.defaultdict(list)
	ans, L, R = 0, 0, 0
	for i, c in enumerate(s):
		dic[c].append(i)
	for c, indices in dic.items():
		l, r = indices[0], indices[-1]
		if ans < r - l:
			ans = r - l
			L, R = l, r
	return s[L:R+1], L, R


# 第二道:找到最长的连续子序列，要求这个连续子序列的和为 0。
# 先用 sum_array 转换一下，就变成了第一道题
def sol2(l):
	sum_array = [i for i in l]
	for i in range(1, len(sum_array)):
		sum_array[i] += sum_array[i-1]
	sum_array = [0] + sum_array
	_, L, R = sol(sum_array)
	return l[L:R]

# 第二轮:1 道题。OOD。
# 设计一个扫地机器人。
# 这个机器人可以前进，向左转，向右转。
# 方法有 move, turnRight, turnLeft, clean()。 设计相应的数据结构使得它能扫完整个房间。房间大小未知，机器人的初始位置未知。
# 489 robot room cleaner (dfs)
def cleanRoom(self, robot):
    self.dfs(robot, 0, 0, 0, 1, set())

def dfs(self, robot, x, y, x_dir, y_dir, visited):
    robot.clean()
    visited.add((x, y))
    for i in range(4):
        next_x, next_y = x + x_dir, y + y_dir
        if (next_x, next_y) not in visited and robot.move():
            self.dfs(robot, next_x, next_y, x_dir, y_dir, visited)
            robot.turnLeft()
            robot.turnLeft()
            robot.move()
            robot.turnLeft()
            robot.turnLeft()
        robot.turnLeft()
        x_dir, y_dir = -y_dir, x_dir


# 给一个数组A，再给一个shuffle A得到的数组B，再给个新数组C，求shuffle C得到的数组D。要求C到D的映射与A到B要一致。 假设所有数组都未排序。
# 比如给A= 2，3，6，7，4；B＝3，2，4，7，6；C= 5，6，1，2，3 那 D就应该是 6，5，3，2，1.
#      A= 1, 2, 3   B = 1, 3, 2  C = 3, 3, 3   D = 3, 3, 3
#      A= 1, 1, 2   B = 1, 2, 1  C = 3, 4, 5   D = 3, 5, 4
#      # idea: form injection from A to C
def findMapping(A, B, C):
	dic = collections.defaultdict(collections.deque)
	for a, c in zip(A, C):
		dic[a].append(c)
	D = []
	for b in B:
		D.append(dic[b].popleft())
	return D


# 给 x,y 轴上一堆点，点的坐标都是正整数，问这些点是否是关于 x = ? 的直线对称。
def mirrorImage(points, x):
	count = colections.defaultdict(int)
	for xx, yy in points:
		xx = abs(xx - x)
		count[(xx, yy)] += 1
	return 1 not in count.values()

# 给一个长方形框（宽和高）和一段话，问能把整段话放进框里的最大字号，你可以调用两个现有的函数，分别返回每个字符的宽度和字符高度。
# 典型的二分查找，在字号范围内不断二分，最后就返回能把整段话放进框里的最大字号了
def fitScreen(screen_width, screen_height, num_chars, font_sizes):
	def ok_or_not(width, height, screen_width, screen_height, num_chars):
		num_chars_per_line = screen_widht // width
		num_chars_per_column = screen_height // height
		num_chars_can_fit = num_chars_per_line * num_chars_per_column
		return num_chars_can_fit >= num_chars

	lo, hi = 0, len(font_sizes) - 1
	while lo < hi:
		mid = (lo + hi + 1) // 2
		font_size = font_sizes[mid]
		width, height = API(font_size)
		size_ok = ok_or_not(width, height, screen_width, screen_height, num_chars)
		if not size_ok:
			hi = mid -1
		else:
			lo = mid
	return lo

# 1st 电面： lc 459，亚裔哥们
# Doable, O(n^2)
def repeatedSubstringPattern(self, s):
    l = len(s)
    for i in range(l//2, 0, -1):
        if l % i == 0:
            m = l // i
            subS = s[:i]
            if subS * m == s: return True
    return False

# 奇技淫巧 O(n)
def repeatedSubstringPattern(self, s):
 	return s in (s + s)[1:-1]

# KMP table, O(n)
def repeatedSubstringPattern(self, s):
	i, j, n = 1, 0, len(s)
    dp = [0] * (n + 1)
    while i < n:
        if s[i] == s[j]:
            i, j = i + 1, j + 1
            dp[i] = j
        elif j == 0: i += 1
        else: j = dp[j]
    return dp[n] > 0 and dp[n] % (n - dp[n]) == 0
# 2nd 电面：lc 685变种。给出binary tree is invalid，有多余的link，要求make the binary tree valid。
# 留了25分钟给这个题。给的输入是root节点。先给面试官讲解了我的做法，找到所有的edge，然后按着685来
# 第二题，如果是binary tree的话，是不是可以做BFS，记住访问过的节点，遍历每个node时查看它的left和right是否已访问过，如果是就去掉。
# +1，我也觉得是，既然给的是root就说明面试官其实想要一个recursion的解法吧...
def removeRedundantLinkInBinaryTree(root):
	visited = {}
	q = deque([root])
	while q:
		node = q.popleft()
		visited.add(node)
		if node.left:
			if node.left in visited:
				node.left = None
				break
			q.append(node.left)
		if node.right:
			if node.right in visited:
				node.right = None
				break
			q.append(node.right)
# 定义两个binary string的distance是去掉common prefix的长度之和。
# 比如: 1011000和1011110的common prefix是1011， distance就是len("000"+"110") = 3 + 3 = 6.
# 现在给一个list of binary strings, 求max distance. 用trie+dfs
# list of binary strings 的 max distance，是整个list去掉common prefix之后任意两个string的max distance中最大的那个
#
# 我是先build trie，然后dfs对每个node返回从那个node开始往下走的最长path, 所以就是dfs(root) = 1 + max(dfs(root.left), dfs(root.right))
# 与此同时如果node有两个children，更新distance = max(distance , dfs(root.left)+dfs(root.right))
# 最后返回distance
# build trie是kn，dfs也是kn，所以是O(kn)

# 刚才又仔细想了一下，dfs的时间复杂度应该是2^n而不是nk，n是list里最长的binary string. 举个例子lst=[10,01,11,00,10,01,11,00...]重复1000次，trie里只有7个node. 所以最终复杂度是nk+2^n
#
#
# http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=440636&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
def maxDistanceOfBinaryStrings(string_list):

as as as as    as as as as as as as as as as as as as
  as as        as
  as as 	   as as as as as
  as as 	   as
  as as        as
# 给一个tree, 给定两个node，求两个node之间最小的距离（edge数）是多少。
def lca_distance(q, p):
	dic = {}
	distance = 0
	while q:
		dic[q] = distance
		distance += 1
		q = q.parent

	distance = 0
	while p:
		if p in dic:
			return distance + dic[p]
		distance += 1
		p = p.parent
	return float('inf')

# 1. input list[int]，output True/False，list里面如果有数字重复出现少于两次 -- False，
# 所有数字出现都超过两次 -- True。input是乱序的，所以我最开始先排了序再做的，时间复杂度O(nlogn)。
# 然后问可不可以降低到O(n)。说了一下用hashmap就好。
def allDouble(numbers):
	count = collections.defaultdict(int)
	onlyones = set()
	for num in numbers:
		count[num] += 1
		if count[num] == 1:
			onlyones.add(num)
		else:
			onlyones.remove(num)
	return len(onlyones) == 0
# 2. 扫描线，time interval overlapping。同时重叠三个及三个以上 -- True，否则 -- False。
# 其實就是meeting rooms II
def minMeetingRooms(self, intervals):
	if not intervals: return 0
	intervals.sort(key=lambda interval: (interval.start, interval.end))
	heap = []
	heapq.heappush(heap, (intervals[0].end, intervals[0].start))
	for i in range(1, len(intervals)):
		end, start = heapq.heappop(heap)
		if intervals[i].start >= end:
			end = intervals[i].end
		else:
			heapq.heappush(heap, (intervals[i].end, intervals[i].start))
		heapq.heappush(heap, (end, start))
	return len(heap) >= 3

# 给一个很长的字符串s，只包括正常英文单词，单词用单个空格隔开，
# 同时给你一个正整数k。请把字符串切分为若干行，
# 要求1：只能在单词之间换行，同一个单词不能被分开；
# 要求2：切分后每行不能超过k个字符。
# 我每次都问同一个问题，你们司程序员每天写代码和开会的时间分别占%多少...
# LC 418, greedy
def wordsTyping(self, sentence, rows, cols):
	s = ' '.join(sentence) + ' '
	l = len(s)
	start = 0
	for i in range(rows):
		start += cols
		if s[start%l] == ' ':
			start += 1
		else:
			while start > 0 and s[(start-1)%l] != ' ':
				start -= 1

	return start // l

def wordsTyping2(s, k):
# Modified from 418. I think it's too complicated
	s += ' '
	l = len(s)
	start = 0
	indices = [0]
	ans = []
	while start < l:
		runner = start
		while runner < l and s[runner] != ' ':
			runner += 1
		start += max(k, runner - start)
		if start >= l: break
		if s[start] == ' ':
			start += 1
		else:
			while start > 0 and s[start-1] != ' ':
				start -= 1
		indices.append(start)

	prev = 0
	for i in indices[1:]:
		ans.append(s[prev:i].strip())
		prev = i
	return ans

# Easier and much better imo
def solution(s, k):
	if len(s) == 0:
		return []

	words = s.split(' ')

	res = []
	cur_len = 0
	cur_line = []
	i = 0
	while i < len(words):
		new_len = len(words[i])
		if cur_len + new_len <= k:
			cur_len += new_len
			cur_line.append(words[i])
			i += 1
		elif cur_len == 0:
			res.append(words[i])
			cur_len = 0
			cur_line = []
			i += 1
		else:
			res.append(' '.join(cur_line))
			cur_len = 0
			cur_line = []
	res.append(' '.join(cur_line))
	return res


# 店面
# 第一题：里扣舞灵
def myPow(self, x, n):
	if n < 0:
        x = 1 / x
        n = -n
    pow = 1
    while n:
        if n & 1:
            pow *= x
        x *= x
        n >>= 1
    return pow


# 里扣儿思旧 变种，完了写test case。follow up，如果input非常非常大怎么办
def LC249():
as as as as    as as as as as as as as as as as as as
  as as        as
  as as 	   as as as as as
  as as 	   as
  as as        as

# 大致是给了一个数据结构，让实现两个methods，一个method是储存数据（input是数据本身和数据的index），储存的数据是按顺序到达的（index 一定是按从小到大的顺序到达），另一个method是根据给的index来读取数据。 follow up，现在储存的数据是无序到达的（index更大的数据可能先到，index小的数据后到），问怎么办？

# 里扣巴叁散 变种，更难一点，input不是string，是用一种数据结构表达出来的，但是本质一样其实不难。
# time O(n), space O(n)
def findReplaceString(self, S, indexes, sources, targets):
    sb = S
    l = len(S)
    indexValInvert = [-1] * l
    for i, val in enumerate(indexes):
        indexValInvert[val] = i
    for i in range(l-1, -1, -1):
        j = indexValInvert[i]
        if j < 0: continue
        source = sources[j]
        if S[indexes[j]:indexes[j]+len(source)] == source:
            sb = sb[:indexes[j]] + targets[j] + sb[indexes[j]+len(source):]
    return sb

# O(nlogn)
def findReplaceString(self, S, indexes, sources, targets):
    offset = 0
    for i, s, t in sorted(zip(indexes, sources, targets)):
        l = len(s)
        if S[i+offset:i+l+offset] == s:
            S = S[:i+offset] + t + S[i+l+offset:]
            offset += len(t) - l
    return S

# 给了一个graph，是以一堆原始数据的形式表现出来， 数据都是以map in map的形式展现， 让判断这个graph是不是一个ring。所以需要先把数据处理一下变成常用的graph表现形式，然后再来判断这个graph是不是一个ring。
def hasRing(graph, root):
	slow, fast = root, root
	while True:
		try:
			slow, fast = slow.next, fast.next.next
			if slow == fast: return True
  		except: return False

#   第一题问 给一个array， 请把它变成个bst， 然后问bst的deletion是什么运作的？
#   让我手动演一遍，然后问了runtime， 我说是logn， 然后突然想到如果树是憋的 就是n， 然后他说好。
def makeBST(nums):
	def helper(nums):
		if not not nums: return None
		lo, hi = 0, len(nums)-1
		mid = (lo + hi) // 2
		node = Node(nums[mid])
		node.left = helper(nums[:mid])
		node.right = helper(nums[mid:])
		return node
	nums.sort()
	return helper(nums)

def makeBST2(nums):
	# O(h). Or O(N) in the worst case and O(logN) if good
	def insertIntoBST(root, val)
        if (root == None)
            return new TreeNode(val);   # return a new node if root is null
        if (root.val < val)             # insert to the right subtree if val > root->val
            root.right = insertIntoBST(root.right, val)
        else                            # insert to the left subtree if val <= root->val
            root.left = insertIntoBST(root.left, val)
        return root
    root = None
    for num in nums:
    	root = insertIntoBST(root, num)
    return root

def deleteNode(root, key):
	# O(h). Or O(N) in the worst case and O(logN) if good
	def findSuccessor(root):
	    cur = root.right
	    while cur and cur.left:
	        cur = cur.left
	    return cur
    if not root: return None
    if (root.val == key)
        if (root.left == None):
            return root.right
        if (root.right == None):
            return root.left
        # replace root with its successor if root has two children
        p = findSuccessor(root)
        root.val = p.val
        root.right = deleteNode(root.right, p.val)
        return root
    if (root.val < key)
        root.right = deleteNode(root.right, key)
    else:
        root.left = deleteNode(root.left, key)
    return root


# 第二题，biggest sum subsequence without using neighbor，
# 比如 [1, 10, 100, 20] 回101， 因为1 + 100 比 10 + 20要大 。
# 我扯了下n方的解法然后说可以dp，
# dp: 截止第i位，最大和，
# dp = max(dp[i - 1], dp[i - 2] + num)，就是nums[i - 1]取和不取两种情况取最大
def bigSumWONeighbor(nums):
	dp = [None] * len(nums)
	dp[0] = nums[0]
	dp[1] = max(nums[0], nums[1])
	for i in range(2, len(nums)):
		num = nums[i]
		dp = max(dp[i - 1], dp[i - 2] + num)
	return dp[-1]



# 第一题，是写一个doublylinkedlist 然后remove first element of the target key
# 例如 1<->2<->3<->2 target key 是2，结果1<->3<->2
def remove(root, target):
	p = root
	while p and p.val != target:
		p = p.next
	if not p: return root
	prev = p.prev
	prev.next = p.next
	return root

# 第二题，环形ListNode， 隔一个删一个
# 例如 1->2->3->1 结果 1->3->1 （这里的两个1 是同一个node）. Waral 博客有更多文章,
# 1->2->3->4->1 结果1->3->1
# 第二题需要一个flag指向head,然后检查当前的下一个的下一个是不是这个flag，不是就删，是就停止。
def delete_interval_in_ring(root):
	p = root
	while p.next != root and p.next.next != root:
		next_p = p.next.next
		p.next = next_p
		p = next_p


# 第一题是给一个sorted int array, 和一个double值called center，根据array里的数到center的距离重新对array进行排序
# 第一题不用binary search 吧 两头往中间走    先找最大的 最大值肯定在两端～
def sortArrayByCenter(nums, center):
	i, j = 0, len(nums - 1)
	result = []
	while i < j:
		if abs(nums[j]-center) > abs(nums[i]-center):
			result = nums[j] + result
			j -= 1
		else:
			result = nums[i] + result
			i += 1
	return result

# print linked list in reverse using sub linear space
# sqrt decomposition
def printReverseLinkedList(head, N):
	h = head
	nodes = [h]
	for i in range(N):
		if i % int(sqrt(N)+1) == 0:
			nodes.append(h)
		h = h.next
	nodes.append(None)
	for i in range(len(nodes)-2, -1, -1):
		node = nodes[i]
		temp = []
		while node != nodes[i+1]:
			temp.append(node.val)
			node = node.next
		for val in temp[::-1]:
			print(val)
# 745
# 没做过…答出来了字典树的想法
# follow问到如果询问的前缀后缀一样长 怎么建树
def LC745():
as as as as    as as as as as as as as as as as as as
  as as        as
  as as 	   as as as as as
  as as 	   as
  as as        as

# 题目：给一个integer array, 找length of the longest consecutive subarray
# 如[1,3,5,7,8,9,2] -> 3（7-9的长度位）
def findLongestConseqSubarray(arr, n):
    two pointers, O(N)
    return ans

def findLongestConseqSubseq(arr):
    s = set(arr)
    ans = 0
    for i in range(n):
        # if current element is the starting element of a sequence
        if (arr[i]-1) not in s:
            # Then check for next elements in the sequence
            j = arr[i]
            while j in s:
                j += 1
            ans = max(ans, j - arr[i])
    return ans

# 河里有石头 人可以踩石头 跳过去 人可以选择跳一格 跳两个 或者不跳， check人能不能跳过去
# 比如 o_ o _ _ o _ 是河 o是石头 _ 是河 然后check 这种不能跳过去
# o_ o o _ 就可以
# 伍伍或者青蛙过河（肆零散
# LC55, jump game
def canJump(self, river):
	nums = [2 if _ == 'o' else 0 for _ in river]
    reach = 0
    i = 0
    while i < len(nums) and i <= reach:
        reach = max(reach, i + nums[i])
        i += 1
    return reach >= len(nums) - 1

# reverse strings
def reverseString(self, s):
    r = list(s)
    i, j  = 0, len(r) - 1
    while i < j:
        r[i], r[j] = r[j], r[i]
        i += 1
        j -= 1

    return "".join(r)

# binary tree to linked list, basically preorder
def flatten(self, root):
	if not root: return
	prev = ListNode(0)
    stack = [root]
    ans = []
    while stack:
        node = stack.pop()
        prev.right = node
        prev.left = None
        prev = node
        if node.right: stack.append(node.right)
        if node.left: stack.append(node.left)
    return ans

# basically inorder
def treeToDoublyList(self, root):
    if not root: return
    first, last = None, None
    stack = []
    while root or stack:
        while root:
            stack.append(root)
            root = root.left
        root = stack.pop()
        if not first: first = root
        if last:
            last.right = root
            root.left = last
        last = root
        root = root.right
    first.left = last
    last.right = first
    return first

# reverse linked list
def reverseLinkedList(self, head):
    prev = None
    runner = head
    while runner:
        nextNode = runner.next
        runner.next = prev
        prev = runner
        runner = nextNode
    return prev

# validate bst & merge intervals
# 第一题是合并间隔，第二题判断一颗树是不是二叉查找树。
# 第一题没什么好说的很简单。第二题先写了一个nlogn的算法，
# followup说了一下O(n)的算法, 没有写，然后说没问题，时间也到了，整个过程没有一点要为难的意思，面试官很nice
def isValidBST(self, root):
    stack = []
    prev = None
    while root:
        stack.append(root)
        root = root.left
    while root or stack:
        while root:
            stack.append(root)
            root = root.left
        root = stack.pop()
        if prev == None:
            prev = root.val
        elif root.val <= prev:
            return False
        prev = root.val
        root = root.right
    return True

def merge(self, intervals):
    if not intervals: return []
    tasks = sorted(intervals, key=lambda x: x.start)
    result = []
    lastStart = tasks[0].start
    lastEnd = tasks[0].end
    for task in tasks:
        if task.start <= lastEnd:
            lastEnd = max(lastEnd, task.end)
        else:
            result.append(Interval(lastStart, lastEnd))
            lastStart = task.start
            lastEnd = task.end
    result.append(Interval(lastStart, lastEnd))
    return result

# 给一组infinite的cards，每个都有各自的分数，分数是1-10. 然后给一个当前的分数sum (total)，
# 规则是：如果sum小于17，那么能再抽一张牌；如果处于17-21之间，就赢了；如果大于21，就输了。
# 问这个sum输的概率。 很简单的用dp搞定了，followup是如果17，21,10这些数字也是参数怎么办
# 题目是给一个sum，代表你手里的点数，让你求sum输的概率。
# 其实就是一个dp，从16开始从右往左填表，填到0。然后return sum的位置
# 爸三妻 W=10, K=17, N=21, total=total
# new21Game(N=21, K=17, W=10, total=total)

# Alice plays the following game, loosely based on the card game "21".
# Alice starts with 0 points, and draws numbers while she has less than K points.
# During each draw, she gains an integer number of points randomly from the range [1, W],
# where W is an integer.  Each draw is independent and the outcomes have equal probabilities.
# Alice stops drawing numbers when she gets K or more points.
# What is the probability that she has N or less points?

# N is loosing, K is winning, W is range
def new21Game(self, N, K, W, total):
    dp = [0.0] * (N + W + 1)
    # dp[x] = the answer when Alice has x points
    for k in range(K, N + 1):
        dp[k] = 1.0

    S = min(N - K + 1, W)
    # S = dp[k+1] + dp[k+2] + ... + dp[k+W]
    for k in range(K - 1, -1, -1):
        dp[k] = S / float(W)
        S += dp[k] - dp[k + W]

    return dp[total]



Given a screen that's represented as a 2d grid, in which 0s are off pixels and 1s are on pixels. Define a line as a having more than 2 adjcent black pixels. find the number of lines in rows, cols and diags.

# 562 Given a 01 matrix M, find the longest line of consecutive one in the matrix.
# The line could be horizontal, vertical, diagonal or anti-diagonal.
def longestLine(self, M):
    if len(M) == 0: return 0
    m, n = len(M), len(M[0])
    dp = [[ [0] * 4 for _ in range(n)] for j in range(m)]
    ans = 0
    for i in range(m):
        for j in range(n):
            if M[i][j] == 1:
                a = dp[i][j][0] = dp[i    ][j - 1][0] + 1 if j > 0               else 1
                b = dp[i][j][1] = dp[i - 1][j    ][1] + 1 if i > 0               else 1
                c = dp[i][j][2] = dp[i - 1][j - 1][2] + 1 if i > 0 and j > 0     else 1
                d = dp[i][j][3] = dp[i - 1][j + 1][3] + 1 if i > 0 and j < n - 1 else 1
                ans = max(ans, a, b, c, d)
    return ans

# 问两个树的inorder是否相同。先用了recursive方法，
# follow up说如果树很大怎么办，原意是想用Iterator，一个一个比较。
class TreeIterator:
	def __init__(self, root):
		self.next = root
		if not self.next: return
		while self.next.left:
			self.next = self.next.left

	def __iter__(self):
		return self

	def next(self):
		if self.next == None: raise StopIteration
		r = self.next
		if self.next.right:
			self.next = self.next.right
			while self.next.left:
				self.next = self.next.left
			return r

        while True:
        	if not self.next.parent:
        		self.next = None
        		return r
        	if self.next.parent.left == self.next:
        		self.next = self.next.parent
        		return r

# 题目是面经题，伞武久变种。input没有时间。我说需要一个get_ts的helper function，他说可以，并没有实现。
# follow up问了把时间限制改成qps怎么做。如果要在0.01秒的分度值内，qps也能被保证，如何改代码。如果只care一分钟这个量级，如何改代码。
def shouldPrintMessage(self, timestamp, message):
    if message in self.last and timestamp - self.last[message] < 10:
        return False
    self.last[message] = timestamp
    return True

# 给定一个字符串S，模式串P
# 要求匹配的时候，在P中连续出现的字符不能在S中连续出现，求匹配的数目
# 例如：
# S=acbccapt
# P=cat
# 答案应该是2，不是3，因为连续的ca不能计算在内
# 类似LCS的动态规划，用dp[i][j]表示S的前i个字符和P的前j个字符的匹配结果
def Q1(S, T):
    m, n = len(S), len(T)
    S = '0' + S      # append to the front to make indexing nicer later
    T = '1' + T
    dp = [[0] * (n+1) for i in range(m+1)]
    for i in range(m+1): dp[i][0] = 1
    for i in range(1, m+1):				 # i for S, j for P
        for j in range(1, n+1):
            dp[i][j] += dp[i-1][j]       # copy previous row
            if S[i] == T[j] and i >= 2:
                dp[i][j] += dp[i-2][j-1] # num_matches: i-2(在P中连续出现的字符不能在S中连续出现)
                                         # 				j-1(matching P till last index)
    return dp[m][n]

# 起三舅
# 给定一个数组，对于其中每一个元素，找到在它后面第一个比它大的元素的下标。
def dailyTemperatures(self, T):
    stack = []
    result = [0] * len(T)
    for i, t in enumerate(T):
        while stack and T[i] > T[stack[-1]]:
            ii = stack.pop()
            result[ii] =  i
        stack.append(i)
    return result
# 496
def nextGreaterElement(self, findNums, nums):
    stack = []
    result = collections.defaultdict(lambda:-1)
    for i, num in enumerate(nums):
        while stack and nums[i] > stack[-1]:
            nn = stack.pop()
            result[nn] =  num
        stack.append(num)
    return [result[num] for num in findNums]

# find peak element, LC 162
def findPeakElement(self, nums):
    A = nums
    lo, hi = 0, len(A) - 1
    while lo < hi:
        mi = (lo + hi) // 2
        if A[mi] < A[mi + 1]:
            lo = mi + 1
        else:
            hi = mi
    return lo

# 290 word pattern == 205 Isomorphic Strings???
# Given a pattern and a string str, find if str follows the same pattern.
# Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
def wordPattern(self, pattern, string):
    string = string.split(' ')
    dic = {}
    dic2 = {}
    if len(pattern) != len(string): return False
    for i, ii in zip(pattern, string):
        i, ii = str(i), str(ii)
        if i in dic:
            if dic[i] != ii: return False
        if ii in dic2:
            if dic2[ii] != i: return False
        dic[i] = ii
        dic2[ii] = i
    return True

# LC 240 group shifted strings (high freq!)
def groupStrings(strings):
    hashmap = defaultdict(list)
    for string in strings:
        offset = ord(string[0]) - ord('a')
        key = ""
        for c in string:
            new_ord = ord(c) - offset
            if new_ord >= ord('a'):
                key += chr(new_ord)
            else:
                key += chr(new_ord + 26)
        hashmap[key].append(string)
    return hashmap.values()

# 先问了给一个binary search tree，再给一个target value，如何找到树中和这个value的差最小的node。
# 然后下一步问了说如果有全世界的机场，然后给定你现在的当前位置，如何找到方圆X公里内的所有机场。
# 大概和他讨论了一下kd tree
def closestBSTValue(self, root, target):
    closest = root.val
    while root:
        closest = min((root.val, closest), key=lambda x: abs(target - x))
        root = root.left if target < root.val else root.right
    return closest

# 1. search in a binary search tree.
def BSTSearch(root, target):
	while root:
		if root.val = target: return root
		root = root.left if target < root.val else root.right
	return None
# 2. LCA (least common ancestor) in a binary tree
# follow up:
# 2. how to improve for binary search tree
# LC 236. Lowest Common Ancestor of a Binary Tree
def lowestCommonAncestor(self, root, p, q):
    if root in (None, p, q): return root
    left = self.lowestCommonAncestor(root.left, p, q)
    right = self.lowestCommonAncestor(root.right, p, q)
    if left and right: return root
    return left if left else right

# LC 235. Lowest Common Ancestor of a Binary Search Tree
def lowestCommonAncestor(self, root, p, q):
	if root in (None, p, q): return root
	if p.val < root.val and q.val < root.val: return self.lowestCommonAncestor(root.left, p, q)
    elif p.val > root.val and q.val > root.val: return self.lowestCommonAncestor(root.right, p, q)
    else: return root

def lowestCommonAncestor(self, root, p, q):
    while root:
        if p.val < root.val and q.val < root.val:
            root = root.left
        elif p.val > root.val and q.val > root.val:
            root = root.right
        else:
            return root

# Buy & Sell Stock
# Base cases:
# T[-1][k][0] = 0, T[-1][k][1] = -Infinity
# T[i][0][0] = 0, T[i][0][1] = -Infinity

# Recurrence relations:
# T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])      rest / sell
# T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])    rest / buy
# ans = T[len(prices)-1][k][0]

# one transaction
# T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
# T[i][1][1] = max(T[i-1][1][1], T[i-1][0][0] - prices[i]) = max(T[i-1][1][1], -prices[i])
def maxProfit(self, prices):
    minSoFar = float('inf')
    ans = 0
    for price in prices:
        minSoFar = min(minSoFar, price)
        ans = max(ans, price - minSoFar)
    return ans
# unlimited
# T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
# T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])
# 			 = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
def maxProfit(self, prices):
    ans = 0
    for i in range(1, len(prices)):
        if prices[i] > prices[i-1]:
            ans += prices[i] - prices[i-1]
    return ans
# k transactions, most general
# DP: t(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).
def maxProfit(self, k, prices):
    if k >= len(prices) // 2: return unlimited(prices)
    dp = [[0] * len(prices) for _ in range(k+1)]
    for i in range(1, k+1):
        tempMax = -prices[0]
        for j in range(1, len(prices)):
            dp[i][j] = max(dp[i][j-1], prices[j] + tempMax)
            tempMax = max(tempMax, dp[i-1][j-1] - prices[j])
    return dp[k][len(prices)-1]
# k = +Infinity but with cooldown
# 	T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
# 	T[i][k][1] = max(T[i-1][k][1], T[i-2][k][0] - prices[i])
def maxProfit(self, prices):
    cash_pre, cash, hold = 0, 0, -float('inf')
    for price in prices:
        cash_old = cash
        cash = max(cash, hold + price)
        hold = max(hold, cash_pre - price)
        cash_pre = cash_old
    return cash
# k = +Infinity but with transaction fee
#  pay fees when buying													pay when selling (might overflow)
# T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])       OR   T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i] - fee)
# T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i] - fee)      T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
def maxProfit(self, prices, fee):
    cash, hold = 0, -float('inf')
    for i in range(0, len(prices)):
        cash_old = cash
        cash = max(cash, hold + prices[i] - fee)
        hold = max(hold, cash_old - prices[i])
    return cash

# 给两个string src和dst，返回能否通过不限次数的转换把src变成dst
# 规则：
# 每次转换将src里的所有同一个字符转换成另一个字符，比如: abaca -> ebece, 将abacd里的a转换成e即可得到dst.
# 另一种情况是abba -> baab 这个时候可以先把a换成c（cbbc），然后b换成a （caac），最后c换成b （baab）
# 面试官让举出return false的例子，然后解题
# 然后追问，如果两个str里出现了所有alphabet怎么办
# 要考虑借一还一的情况，如果string里面用完了26个字母而又需要一个不同的字母完成转换就会出现问题

# 三个判据：
# 1. 两个字符串大小不一样，返回false
# 2. 从a->b的单向映射Map出现冲突，返回false
# 3.两个字符串都有26个字符，且Map不冲突，但是存在Map[x]!=x，
# 说明必定有成环的映射关系．这种情况下，因为无法借助第三变量（26个字母都用完了），所以返回false
def check(s, t):
	if len(s) != len(t): return False
	dic = {}
	for ss, tt in zip(s, t):
		if ss not in dic: dic[ss] = tt
	    if dic[ss] != tt: return False
	setS = set()
	setT = set()
	count = 0
	for ss, tt in zip(s, t):
		setS.add(ss)
		setT.add(tt)
		if dic[ss] != ss: count += 1
	if len(setS) == len(setT) == 26 and count > 0: return False
	return True

# LC 205 leetcode isomorphic
def isIsomorphic(self, s, t):
    dic = collections.defaultdict(int)
    dic2 = collections.defaultdict(int)
    if len(s) != len(t): return False
    for i, (ss, tt) in enumerate(zip(s, t)):
        ss, tt = str(ss), str(tt)
        if dic[ss] != dic2[tt]: return False
        dic[ss] = dic2[tt] = i + 1
    return True


# 题目：Input: String s, a List of Strings d. Output: the longest string ind which can be  obtained by deleting characters from s.
# 其实意思就是，找出list d里面最长的一个，并且是s的subsequence的string。
# Ex. s:"ekkkkbay". d={"amazon", "ebay", "eby"}. 返回“ebay”。
# d里有可能是s的sub，找出是sub并且最长的
# 题目比较简单，后面有些follow up也不难。就是问complexity，以及如果有多个符合条件，要找出最前面一个，或最后一个，或找出所有，应该怎么该代码。
# LC 524
def findLongestWord(self, s, d):
    def isSubSeq(s, t):
        j = 0
        for i in range(len(s)):
            if s[i] == t[j]:
                j += 1
            if j == len(t): return True
        return False
    ans = ""
    for word in d:
        if isSubSeq(s, word):
            if len(word) > len(ans) or (len(word) == len(ans) and word < ans):
                ans = word
    return ans

# 和lc792有些类似，有parallel处理的办法，复杂度可以做到O(slength + sum(字典里word.length))。不过面试的时候很难想出来。。。
# LC 792
def numMatchingSubseq(self, S, words):
    waiting = collections.defaultdict(list)
    for it in map(iter, words):
        waiting[next(it)].append(it)
    for c in S:
        for it in waiting.pop(c, ()):
            waiting[next(it, None)].append(it)
    return len(waiting[None])







# 1. Calculate the sum of the leaves of a tree in O(1) space complexity.
# 2. Write an iterator that does run-length decoding.
# Write an iterator that unpacks a run-length encoding. T
# he encoding is an array of integers, where the i'th element tells you how many times to repeat
#  the i+1'th. For example, given the array [3,8,0,9,2,12], the iterator should return "8" the
#  first 3 times it's called, then "12" the next two, then end. Note that it's not returning
#  [8,8,8,12,12] all at once, but one at a time, each time it's pinged.
#  Also note that "0" is a valid repeat number.

def Q1(root):
	current = root
	total = 0
	while current:
		if not current.left:
			current = current.right
		else:
			predecessor = current.left
			while predecessor.right != current and predecessor.right:
				predecessor = predecessor.right
			# if right node is null then go left after establishing link from predecessor to current.
			if predecessor.right == None:
				if not predecessor.left: total += predecessor.val
				predecessor.right = current
				current = current.left
			# left is already visit. Go rigth after visiting current.
			else:
				predecessor.right = None
				current = current.right
	return total

def MorrisTraversal(root):
	current = root
	while current:
		if not current.left:
			visit(current)
			current = current.right
		else:
			predecessor = current.left
			while predecessor.right != current and predecessor.right:
				predecessor = predecessor.right
			if predecessor.right == None:
				# if PREORDER, visit(current)
				predecessor.right = current
				current = current.left
			else:
				#if INORDER, visit(current)
				predecessor.right = None
				current = current.right

class RLEIterator:
	def __init__(self, A):
        self.A = A
        self.i = 0
        self.q = 0

	def next(self, n):
	    while self.i < len(self.A):
	        if self.q + n > self.A[self.i]:
	            n -= self.A[self.i] - self.q
	            self.q = 0
	            self.i += 2
	        else:
	            self.q += n
	            return self.A[self.i+1]
	    return -1

# 说有很多loud speaker，每个loud speaker在一些时间区间会发出声音。每个区间的声音响度可能不同。
# 比如对于某一个loud speaker，发声音的间隔是[3, 5], [ 7, 10], [13, 15]，响度分别为50,30,40。
# 问这些loud speaker发声的总体效果。
# 其实就是区间的merge，如果两个speaker同时响了，响取较大的那个
# 其实就是skyline

# sort critical points
# when left, add rectangle to heap
# when right, remove rectangle from heap
# set height of critical point to max in heap
# for each critical point c
#     c.y gets the height of the tallest rectangle over c

def getSkyline(self, buildings): #Lazy deletion
	if not buildings: return []
    # sort critical points
    points = []
    for l, r, h in buildings: # left before right
        points += [(l, -h), (r, h)]
    points.sort()
    # Use a heap to store heights
    result, heights, prev = [], [0], 0
    # Save the heights that will be removed later
    ignored = defaultdict(int)
    for x, h in points:
        if h < 0:  # when left, add rectangle to heap
            heappush(heights, h)
        else: # when right, remove rectangle from heap
            ignored[-h] += 1
        # Remove heights if they become the root of the heap
        while ignored[heights[0]] > 0:
            ignored[heights[0]] -= 1
            heappop(heights)
        # The first element is value of the heap's root node
        cur = heights[0]
        if cur != prev:
            result.append((x, -cur))
            prev = cur
    return result

# 在一个2D 数组中如何找到从上到下的和是最小的路径
# 左上到右下
# 2D dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))	start from bottom right
# 1D dp(j)=grid(i,j)+min(dp(j),dp(j+1))			start from bottom right
# O(1) modifies original grid(i,j)=grid(i,j)+min(grid(i+1,j),grid(i,j+1))
def minPathSum(self, grid):
	for i in range(len(grid)-1, -1, -1):
        for j in range(len(grid[0])-1, -1, -1):
            if i == len(grid)-1 and j != len(grid[0])-1:
                grid[i][j] = grid[i][j] +  grid[i][j + 1]
            elif j == len(grid[0])-1 and i != len(grid)-1:
                grid[i][j] = grid[i][j] + grid[i + 1][j]
            elif j != len(grid[0])-1 and i != len(grid) - 1:
                grid[i][j] = grid[i][j] + min(grid[i + 1][j], grid[i][j + 1])
    return grid[0][0]

# n-child tree。
# 说root node是一个watertank，里面装很多水，然后每个edge上面都标了数字，数字代表需要多少mins能装满这个child node。
# 第一问是让我自己选个data structure写出来，方便后面做题
# 写个method来找出最少需要多少mins能把所有的child node都装满水。也是磕磕绊绊的写完了，dfs



# 给一个source string 和error_locations tuple list，
# source = " !\ndefn foo(x, y):\n..."，error_locations = [(0, 1), (1, 3),(1, 5), ...] # (line, column), each 0-indexed
# 然后让 写一个method来把这些tuple变成absoluteindices in the source string.  所以刚刚的例子output 就是 [1, 6, 8] .
def relativeToAbsolute(source, error_locations):
	starts = [0] + [m.start() + 1 for m in re.finditer('\n', source)]
	error_locations = [(0, 1), (1, 3),(1, 5)]
	return list(map(lambda x: starts[x[0]]+x[1], error_locations))

car fleet

399

一个DAG，问你指向某个节点的所有节点
topological sort, return all nodes that come before the given node
follow up是问如果需要保证遍历的层级顺序怎么办，回答用bf

isCollapsible 给定一个单词判断能不能每次删掉一个单词最后变成一个长度为1的单词，要求每一步都在字典里
用了BFS和DFS两种方法

让找出某个单词里所有连续多余3个相同字符字符串的起始位置，比如heeellooo返回[[1,3],[6,8]]



一个string在某些位置比另个string多了些chars，把他们找出来
关于trie的问题。每个edge上有weight，如何找从root到leaf最heavy weight的path。
然后follow-up把所以的root-to-leaf path weight 用sorted order return。
最后follow-up如何找heaviest weight path，但不一定要从root开始（
比如可以从leaf开始往上爬，然后在下到某个weight），leetcode有类似的题
蠡口 腰②偲

用+或者- 连接一串小数，使得结果在0-0.12之间。返回所有组合。用的dfs
preserve order

有一串zipcode，每个zipcode会有一定人数，从中选取不超过n人，使得对于每个zipcode都公平。人数要尽量多。
就是说zipcode1 有一人，zipcode2 有2人，zipcode3有三人，如果选不超过4人，就是111，如果不超过5人就是122。

就是有n个bucket，对每个bucket而言尽量公平；
公平的解释，假如bucket A 比 B 多选了 >= 2个，且 B尚有未被选的，则不公平

解法：
按bucket size sort，假设最小bucket size = k，共有n个bucket，则取 n * k， 并抛掉最小bucket，因为满了；
如果n*k 多于可取的数，答案找到；
否则，每个bucket size -= k，继续进行

补充内容 (2018-8-28 06:22):
应该是A比B多选了>= 1个，且B尚未空，则不公平


陆捌肆变种，用union find和BFS解决。把root放进queue里，对于每个邻居做find，
如果是同一个集合就删掉这个边并返回，否则就union, 并把邻居加入queue做下一层检查
followup1：同样的方法，只是找到第一个边不返回，接着找完所有的边并删除
followup2：每找到一个边加入一个list里面



# 1：二叉树多一条边变成graph了，找到并删去
# directed graph
# follow up1: 多了好多边，删到tree property满足为止. 1point 3acres 论坛
# follow up2: 打印所有多余边
# 输入就一个Node root
# 就是BFS/DFS，遇到访问过的就删掉这条边？

# 楼主您好 想问一下 可以用bfs做 每一层删掉任意一个多出来的node 这样可以吗 还是说有规定某些边不能删

# 因为题目给出的是root，那么遇到任何多于一个parent的节点，可以任意删除edge以恢复到该节点只有一个parent.
# 注意，root如果有parent的话，那也是需要删掉的
# 此题如果改一下，给出的不是root，而是有向边的集合的话，那么就不可以任意删除了．
# 是的，有向边集合没法这样做， 如果给出的是root，确实可以用，遇到多于一个parent的节点就删除来做
def removeRedundantLinkInBinaryTree(root):
	visited = {}
	q = deque([root])
	redundant = set()
	if root.parent:
		redundant.add((root, root.parent))
		root.parent = None
	while q:
		node = q.popleft()
		visited.add(node)
		if node.left:
			if node.left in visited:
				redundant.add((node, node.left))
				node.left = None
			q.append(node.left)
		if node.right:
			if node.right in visited:
				redundant.add((node, node.right))
				node.right = None
			q.append(node.right)
	return rundundant

# 2：secret word matching，类似利口word pattern I
# ababa->xyxyx true, ababa->xxxxx false
def wordPattern(self, pattern, string):
    string = string.split(' ')
    dic = {}
    dic2 = {}
    if len(pattern) != len(string): return False
    for i, ii in zip(pattern, string):
        i, ii = str(i), str(ii)
        if i in dic:
            if dic[i] != ii: return False
        if ii in dic2:
            if dic2[ii] != i: return False
        dic[i] = ii
        dic2[ii] = i
    return True


# 给你一个List of String，和另外一个string作为prefix，要返回list里面所有的前缀和给定prefix匹配的string。
# 题目不难，直接用trie就解决了，写了大概20分钟。之后问了点follow up，
# 比如要对输出的list排序，应该怎么做，随便聊了聊没写代码，最后尬聊到45分钟挂的电话。。

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        current = self.root
        for letter in word:
            if letter not in current.children:
                current.children[letter] = TrieNode()
            current = current.children[letter]
        current.is_word = True

    def search(self, word):
        current = self.root
        for letter in word:
            if letter in current.children:
                current = current.children[letter]
            else:
                return False
        return current.is_word

    def startsWith(self, prefix):
        current = self.root
        for letter in prefix:
            if letter in current.children:
                current = current.children[letter]
            else:
                return False
        return True


第一轮：烙印小哥，是在一个 tree 里面 deleteNode，但是这个 tree 是以ArrayList 给的：
eg：[{A, -1}, {B, 0}, {C, 0}, {D, 1}]
       0        1       2       3
即{node, parentIndex}
第一问：给一个 node index，删掉 node 留下 null
第二问：删掉 node 不留空
第三问：删掉 node 顺便删除整个 subtree


# 第二轮：感觉是个欧洲大叔，743变种，变成了水灌溉，一个 tree，每个 edge 有灌溉到孩子的时间，求最短多久把所有 leave 灌满
# 第二问：如果变成了 graph 怎么做
# 第三问：如果一个 child node 有好几个 parent 来源怎么

# Dijsktra's Algorithm
def networkDelayTime(self, times, N, K):
    graph = collections.defaultdict(list)
    for u, v, w in times:
        graph[u].append((v, w))

    pq = [(0, K)]
    dist = {}
    total = 0
    while pq:
        d, node = heapq.heappop(pq)
        if node in dist: continue
        dist[node] = d
        if node is leaf: total += d
        for nei, d2 in graph[node]:
            if nei not in dist:
                heapq.heappush(pq, (d+d2, nei))
    return total if len(dist) == N else -1

# 楼主 请问第二轮的第三问 是不是等于就是将单源最短路径 变成了 多源最短路径？用Floyd-Warshall可以吗？
# shortestPath(i,j,0)=w(i,j)
# shortestPath(i,j,k)=min(shortestPath(i,j,k-1),shortestPath(i,k,k-1)+shortestPath(k,j,k-1))
# O(V^3)
def floydWarshall(graph, V, w):
	dist = |V| × |V| array of minimum distances initialized to float('inf')
	for each edge (u,v)
    	dist[u][v] = w(u,v)
    for each vertex v
    	dist[v][v] = 0
    for k in range(V):
        for i in range(V):
            for j in range(V):
                dist[i][j] = min(dist[i][j], dist[i][k]+ dist[k][j])


最近高频的投票题，就是有一个list，每个元素是谁在什么时间投票给了谁。给定一个结束时间，问谁赢了。多出来的要求是如果一个人投了两次票，他的票全部作废。
follow up是说如果要多次query，可以preprocess一次，怎么做能让query 变成o(n)的。
写了好久的代码，写完了，自己过了一个test， 找到了几个bug中间改了

query的输入是结束时间，输出是谁赢了这个这个选举
要求比线性快



# 给一个full binary tree (除了最后一层可能不是满的，其他都是满的), root的编号为1， root.left编号2， root.right编号3.... 问给定一个位置， 该点是否存在， 要求O(lgn);
# follow up 求这个tree的size.  follow up 我只给出了O((lgn)**2)的解，加上一点pruning.
# 这个基本就是LC222了吧
def countNodes(root):
	if not root: return 0
	left, right = root, root
	height = 0
	while right:
		left = left.left
		right = right.right
		height += 1
	if not left: return (1 << height) - 1
	return 1 + countNodes(root.left) + countNodes(root.right)



题目是一个类似数组形式的森林，每个树存有他父母的位置（唯一），大概就是：[0,0,1,1,2]这样一个森林，在位置0的是根，父母是自己；位置1的父母是0；位置2和3的父母是1；位置4的父母是2。
问删除某一些树的操作。
我的想法大概就是把要删的所有子孙后代找到；然后还有一个操作就是更改没有被删的父母信息，因为他们父母很可能位置改了，但是我这段代码被面试官问好久，最后意思好像就是你到底想干啥？然后我自己写几个例子给他讲这步有啥用。。就很谜。主要还是python写这种结构比较混乱吧。。。
. 1point 3acres 论坛
然后就这样一个题结束了。。。不知所措



一上来讲题目，用红蓝棋子将围棋棋盘（为什么是围棋，因为这时候大哥说了个这个棋盘跟“围棋”是一样的，感觉是在对暗号一样，哈哈）的上下边，或者左右边连起来。判断此时哪一方胜利，或者双方都还没有成功连接两边。其实就是很简单的用DFS就可以解决了。或者遍历棋盘用UnionFind也可以。

只要判断当前哪一方已经把左右或上下两个边连通了就可以了
所以给的是一个布局，不是两个人轮流下棋？
连通是指上下左右四个方向相邻？所以就是dfs，从上（左）面的每一点看看能不能走到下（右）面的任一点？
对，虽然设定很多，但实际上只要判断一个布局有没有赢家就可以了。

就是说输入是一个二维的数组，假设r和b分别代表红蓝棋子。那么先从第一行检查，如果有棋子就用DFS接着往下搜，
并用一个set存储防止重复访问，如果能到达某个row number是matrix长度的cell就返回true，否则false。
同理再对最左边一列做同样的操作。对吗
417




二叉树层连接，假设每个树节点指向父节点，另有一个sibling指针，求把sibling指向同层右边的邻居。开始很快bfs写完了，结果小哥问dfs怎么写
后来我想他期待的应该是通过父指针的sibling找到第一个孩子
dfs维护一下每一层到过的最右侧的节点，然后把该节点的sibling设为当前正在搜索的节点即可吧
116

给一个树，表示方法是array，array中第一个数是parent的index，第二个数是val，删除其中一个node，并把所有subtree的node的parent改成-1
      A
     /  \. 一亩-三分-地，独家发布
   B    C
  /     / \-google 1point3acres
D    E   F
[[0,A], [0, B], [1,D], [0,C], [3,E], [3,F]]
给要删除node的index， 比方说1， 删完就是[[0,A], [-1, B], [-1,D], [0,C],  [3,E], [3,F]]

follow up：如果不仅要改成-1，还要删除entry，还需要做什么处理： 答需要把后面node的parent index更新 -> [[0,A], [0,C], [1,E], [1,F]]

做法类似bfs，每轮拿到需要重置的parent node，然后把children都改掉加入新的queue里面



一面：
对一个单词中有连续三个以上字母相同的情况（如goooooooodbyeeeeee中o和e部分）认为是用户卖萌所打。
基础问题：找到所有这种情况的位置。
Followup：给一个API判断某单词是否为合法字典词，返回这个卖萌延长词是否为一个合法单词延长所得。
二面：开场闲聊，表明偏系统方向。

热身系统题：
如何在一个分布式系统中（数据中心）找到不同机器上的重复文件。
给出中心化解法后，要求去中心化解法。
算法题（包了层壳，本质如下）：

输入一个正整数，求小于这个数的正整数里有几个数含数字⑦。这个数本身不会含⑦。

一面题：合法单词最多只会有两个连续相同字母。
二面系统题：题目要求是找到重复文件，并把这些重复文件删到只剩一个。要求去中心化解法。
查了一下，二面题是蠡口儿散散的简化版，因为给出的数不会含⑦，少了特殊情况。





题目很简单，给一个unsorted list，里面包含一系列投票指向的候选人和时间，问在T时间之前得票最多的候选人是谁。一开始被unsorted字眼给绕了一下，第一反应先sort，在小哥的提示下发现根本不需要sort，然后分析时间复杂度是O(n)。
然后follow-up是T时间之前的K个最高得票人，没让写码，问了用什么数据结构来处理，答PriorityQueue，然后在原代码的基础上稍微改了改伪代码。
比如说[[name1, 0], [name2, 3], [name3, 7], [name4, 1], [name1, 4]]这样，就是每个候选人的名字和对应的时间，非常简单
input不是stream所以不需要sort吧 可以全处理完再看 要不然还是需要按时间sort
followup是全count完了放到PQ里面？nlogk？用quick select如何 o（n）？






# 就是lc的844了，只不过原题用#，换了个特殊字符*，思路是一样的。
# follow up：如果还有另外一个特殊字符表示大写，比如a^b^c == aBc，同样要求比较字符串是否相同。
def backspaceCompare(self, S, T):
    i, j = len(S) - 1, len(T) - 1
    backS = backT = 0
    while True:
        while i >= 0 and (backS or S[i] == '#'):
            backS += 1 if S[i] == '#' else -1
            i -= 1
        while j >= 0 and (backT or T[j] == '#'):
            backT += 1 if T[j] == '#' else -1
            j -= 1
        if not (i >= 0 and j >= 0 and S[i] == T[j]):
            return i == j == -1
        i, j = i - 1, j - 1



 743变种，变成了水灌溉一个 tree， edge 是灌溉到child的时间，求多久灌溉到所有 leaves

 写一个iterator。next() 是输出tree的下一个node in order。hasNext() 是返回是否还有下一个node。
这次我又被那个in order绕进去了，他一直跟我强调in order, 但是又说不一定是binary tree。后来又给了个例子，原来就是普通的traverse，dfs就好了。


定义了一个Tree Class, 有getValue(), getLeft(), getRight()。 第一题是inorder traverse。第二题判断一个list是不是从root到leaf的path。都用dfs就好了



白人小哥没多废话，上来给了个用dictionary存undirected graph， 给了一个存target_nodes的list，
让返回一个存其他所有点到target_nodes最短距离的dictionary。
例子： 有ABCD四个点的complete graph，target_nodes是['A', 'C'],
返回应该是{'A':0, 'B':1, 'C':0, 'D':1}，顺序无所谓

直接BFS，跑了一个testcase，问了一下时间复杂度，worst case是什么情况
贰捌陆?



在google的office中有一列desks。现在有三个长度为100的micro kitchen，
判断摆放这三个kitchen能否serve（cover）到所有的desk，input为一个数组比如，
arr : [20, 100, 140, 230, 280, 300], 每个position i有一个desk，arr[i]代表这个desk离左边墙的距离

第二题是排好序的数列嘛？反正每一个桌子都要被cover，难道不就是从第一个开始算然后100以内的被cover，
然后从下一个没有被cover到的开始算第二个table然后算完三个就行了？遍历一遍O(n)?



刚结束的狗家店面，题目输入是一个string s和List<Replacement>，Replacement class有三个methods，GetIndex(),Before(), After(). GetIndex()返回s里需要被replace的位置，Before()就是从这个位置开始的原substring，After()就是需要替换的string。 来源一亩.三分地论坛.
例子 s=abcd
GetIndex()返回1
Before()返回“bc”
After()返回"e"
那么转换之后的s变成aed

题目不难，但是有很多edge case要处理，比如List是无序的，List里的Replacement可能会有overlap，Before（）可能不存在
蠡口巴伞伞变形


求问楼主~~无序的话应该怎么处理呢
应该先替换哪一个再替换哪一个呢
例子 s=abcd
Relacement1            Replacement2
GetIndex()返回1.    GetIndex()返回2
Before()返回“bc”   Before()返回“c”
After()返回"e"        After()返回"cc"
先1后2 abcd -> aed -> aed
先2后1 abcd -> abccd -> aecd
这样得到的结果就不一样诶
求楼主指教

这个假设是atomic operation，如果同一个index出现多于一次要报错

嗯嗯 是的，这些是不是都是要和面试官探讨才能得出结论哇。
比如如果overlap 需要报错。
然后又因为是无序的，是按照无序的里面 那个idx 第一个碰到的输出。. From 1point 3acres bbs
还是 面试官有自己的有序的顺序，感觉都得讨论，很有启发性


全程都是基于triangle sorted array, 就是一个先增后减的array，无duplicates，比如[1,3,5,4,2], 基本和利口巴吾儿一样的设定
1. 给出一个最小triangle array的例子。就随便打一个就行，注意不能有重复元素. visit 1point3acres for more.
2. 如何验证一个给定数组是否是triangle array, 写代码，space and time complexity，go through a test case。我说了一个比较正常的, [1,3,5,4,2]. .1point3acres网
说完又问了还有什么样的test case可以考虑，我举了递增，递减，长度小于2，最后一个值和前面重复，最大值偏左，最大值偏右，多个peak，随机数列。面试官全程cool，emm感觉也就是个口头禅吧
最后还问了从language角度写的code有什么可以修改的地方，不用implement。我代码写的有点丑，用了两个很重复的while循环，我就说应该能把俩循环合并成一个...
3. 在一个triangle array搜索target是否存在，space and time complexity
我说做三次binary search，先找最大值，再在两边搜。没准有更好的办法，但是我每次企图多想想的时候面试官都让我think out loud，所以只能顺着最开始的想法说下去了...
4. 应该是接着3问的，写出找最大值的代码，go through a test case
5. 如何把triangle sorted array变成sorted array。我说了用two pointer，她问知不知道什么算法干这个事情。这个问题我没有太听懂，就说和merge sort的merge有点像但是不完全一样，问她是不是想问这个，她就又cool就过去了 来源一亩.三分地论坛.
6. 如何balance 一个triangle sorted array, 是不是所有这样的array都可以被balance
依然让我think out loud...我的想法是先sort好，再从头开始往两头分配，其实细想一想应该说一下前半部分和后半部分用的数据结构，但是当时没多长时间了，我没说她也没问。我觉得只要是奇数个元素都能balance，她让我证明...我就随便说了说有个invariant啥的




新人发个谷歌19年HQ冬季实习电面, 两轮背靠背，面完第二天通知送HC，一周后通知进pool
1. 利口844，但是#换成两个char，index处理起来比想象中会麻烦不少，注意edge cases就好
2. 题目简化下来就是给一个stream of strings：. 一亩-三分-地，独家发布
随时检查一个string出现来多少次，用map
随时query最频繁的那个, 用map
随时query出现第k多的那个
最主要是最后一个follow up, 前两个比较无脑。做法我用了min heap，但是由于很多语言都不支持在heap里update key/priority，所以如果heap里面已经有一个element + 它出现的次数，之后stream里面再看到的时候update heap就有点麻烦

>>>>第二题followup可以用一个set的iterator来指着第K多出现的次数，当有新的出现次数进来时来++或者--这个itr，再用一个hashmap<int, vector<string>> 来存储出现次数对应的string。


>>>> 你这个代码当k是个固定值时候才好用吧？
from heapq import heappush, heappop, heapify. more info on 1point3acres
from collections import Counter

class StringStream:
  def __init__(self, k):
    self.count_map = Counter().本文原创自1point3acres论坛
    self.min_heap  = []. From 1point 3acres bbs
    self.k = k # k must be >= 1
. 1point 3acres 论坛
  def min_heap_push(self, count, string):
    if len(self.min_heap) == self.k:
      if self.min_heap and self.min_heap_peek()[0] > self.count_map[string]:
        return
      self.min_heap_pop(). from: 1point3acres
    heappush(self.min_heap, [count, string])

  def min_heap_pop(self):
    return heappop(self.min_heap)

  def min_heap_peek(self):. 牛人云集,一亩三分地
    return self.min_heap[0]

  def max_heap_replace(self, count, string):
    for i in range(len(self.min_heap)):
      if self.min_heap[1] == string:
        self.min_heap[0] = count
        break
    heapify(self.min_heap)

  def add(self, input_str):
    if input_str in self.count_map and self.min_heap and self.min_heap_peek()[0] <= self.count_map[input_str]:
      # already in heap, needs to be update
      self.count_map[input_str] += 1
      self.max_heap_replace(self.count_map[input_str], input_str)
    else:
      self.count_map[input_str] += 1
      self.min_heap_push(self.count_map[input_str], input_str). visit 1point3acres for more.

  def query_k(self):
    if self.min_heap:
      return self.min_heap_peek()[1]. from: 1point3acres

s = StringStream(1)
s.add("a")
s.add("a"). 牛人云集,一亩三分地
s.add("a")
s.add("b")
s.add("b")
print(s.min_heap)
print(s.query_k())


844 is high freq!!
399, 833 high freq
91 decode ways


最近高频的投票题，就是有一个list，每个元素是谁在什么时间投票给了谁。
给定一个结束时间，问谁赢了。多出来的要求是如果一个人投了两次票，他的票全部作废
follow up是说如果要多次query，可以preprocess一次，怎么做能让query 变成o(n)的。
query的输入是结束时间，输出是谁赢了这个这个选举
要求比O(n)快
多次query是给不同截止时间的意思
提前算好所有可能的截止时间的结果，这样query就二分查找 logn 复杂度
as as as as    as as as as as as as as as as as as as
  as as        as
  as as 	   as as as as as
  as as 	   as
  as as        as
