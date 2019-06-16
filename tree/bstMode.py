# traverse, map record freq
def bstmode(root):
    if root is None:
        return []
    counter = collections.Counter()
    preorder(root, counter)  # other traversal....bfs...
    most_freq = max(counter.itervalues())   # python3: counter.values()
    return [k for k,v in counter.iteritems() if v == most_freq]   # counter.items()

def preorder(root, counter):
    if root:
        counter[root.val] += 1
    if root.left:
        preorder(root.left)
    if root.right:
        preorder(root.right)

# follow up: O(1) space
# 1 pass, record hightest fre with inorder
# 2 pass, collect and return
def bstmode(root):

    self.res = []
    self.cur_value = None
    self.cur_count=0
    self.max_count = 0
    self.mode_count=0
    inorder(root)

    inorder(root)
    return res

def inorder(root):
    if root is None:
        return
    inorder(root.left)
    handle_value(root.value)
    inorder(root.right)

def handle_value(value):
    if value != self.cur_value:
        self.cur_value = value
        self.cur_count = 0

    self.cur_count += 1
    if self.cur_count > self.max_count:
        self.max_count = self.cur_count
        mode_count = 1
    elif self.cur_count == self.max_count:
        if self.res:
            res.append(self.cur_value)
        mode_count += 1
