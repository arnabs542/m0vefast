def findMedianSortedArrays(self, A, B):
    n = len(A) + len(B)
    if n % 2 == 1:
        return self.helper(A, 0, B, 0, n//2 + 1)
    else:
        smaller = self.helper(A, 0, B, 0, n//2)
        bigger = self.helper(A, 0, B, 0, n//2+1)
        return (smaller + bigger)/2

def helper(self, A, aleft, B, bleft, k):
    if aleft == len(A):
        return B[bleft + k - 1]
    if bleft == len(B):
        return A[aleft + k - 1]
    if k == 1:
        return min(A[aleft], B[bleft])
    ak = A[aleft + k//2 - 1] if aleft + k//2 <= len(A) else float('inf')   # <= compare length
    bk = B[bleft + k//2 - 1] if bleft + k//2 <= len(B) else float('inf')
    if ak < bk:
        return self.helper(A, aleft + k//2, B, bleft, k-k//2)
    else:
        return self.helper(A, aleft, B, bleft +k//2, k-k//2)





    \
