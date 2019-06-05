# working backwards, inplace, O(m+n)
# assuming m > n
def merge_2_sorted_arr(A, m, B, n):
    a, b, index = m - 1, n - 1, m + n - 1
    while a >= 0 and b >= 0:
        if A[a] > B[b]:
            A[index] = A[a]
            a -= 1
        else:
            A[index] = B[b]
            b -= 1

        index -= 1

    while b >= 0:
        A[index] = B[b]
        index, b = index - 1, b - 1
