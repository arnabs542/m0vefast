# greedy solution
# from left to right
def canjump2(self, A):
    res = 0
    edge = 0  # temp, last farest index can be reached
    maxEdge = 0  # from index i, which far index can i reach
    for i in range(len(A)):
        if i > edge:     # if out of reachable area, need a new step
                         # previous index and be reached
            edge = maxEdge
            res += 1
        maxEdge = max(maxEdge, i + A[i])
    return res


'''
从左往右扫描，维护一个覆盖区间，每扫过一个元素，就重新计算覆盖区间的边界。
比如，开始时区间[start, end], 遍历A数组的过程中，不断计算A[i]+i最大值（
即从i坐标开始最大的覆盖坐标），并设置这个最大覆盖坐标为新的end边界。而新的start边界则为原end+1。
不断循环，直到end> n.
'''
# dp solution:
