# O(n) inplace solution 3
def wigglesort(A):
    for i in range(len(A)):
        A[i:i+2] = sorted(A[i:i+2], reverse=i%2)   # index=1, decending from here
        # A[0,2) index 0 and 1
# solution1: O(nlgn) soring
# solution2: o(n) find median + interleave
