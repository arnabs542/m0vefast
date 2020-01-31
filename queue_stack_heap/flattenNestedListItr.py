'''
Your NestedIterator object will be instantiated and called as such:
i, v = NestedIterator(nestedList), []
while i.hasNext(): v.append(i.next())

Input: list = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]

class NestedInteger(object):
    def isInteger(self):
        # @return {boolean} True if this NestedInteger holds a single integer,
        # rather than a nested list.

    def getInteger(self):
        # @return {int} the single integer that this NestedInteger holds,
        # if it holds a single integer
        # Return None if this NestedInteger holds a nested list

    def getList(self):
        # @return {NestedInteger[]} the nested list that this NestedInteger holds,
        # if it holds a nested list
        # Return None if this NestedInteger holds a single integer
'''



class NestedIterator:
    def __init__(nestedlist):
        self.next_item = None
        self.stack = []
        for item in reversed(nestedlist):
            stack.append()

    def hasNext():
        # when will this be possible ? call hasNext() and then hasNext()
        if self.next_item is not None:
            return True
        while stack:
            top = self.stack[-1]
            if top.isInteger():
                self.stack = top.getInteger()
                return True
            else:
                for each in top.getList():
                    self.stack.append(each)
        return True


    def next():
        if next_item is None:
            self.hasNext()
        res = next_item
        self.next_item = None
        return res
