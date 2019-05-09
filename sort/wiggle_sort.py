# O(n) inplace
def wigglesort(A):
    for i in range(len(A)):
        A[i:i+2] = sorted(A[i:i+2], reversed=i%2)
