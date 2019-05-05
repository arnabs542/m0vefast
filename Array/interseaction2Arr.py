# with duplicate, but return no duplicate
# brute force  O(mn)
def intersect(A, B):
    return [a for i, a in enumerate(A)
            if (i == 0 or a != A[i-1]) and a in B
        ]

# iterate one array and use binary search to check if in the other one
# O(mlgn)
def intersect(A, B):
    def is_present(k):
        # bisect.bisect_left: insert k in a sorted B list (left if duplicate entries)
        i = bisect.bisect_left(B, k)
        return i < len(B) and B[i] == k

    return [
        a for i, a in enumerate(A)
        if (i == 0 or a != A[i-1]) and is_present(a)
        ]

# enumrage all elemtns in A
a for i, a in enumerate(A)
# if statment
if (i == 0 or a != A[i-1]) and condition_B


# 2 pointers: O(m+n)
def intersect(A, B):
    i, j, intersection_A_B = 0, 0, []
    while i < len(A) and j < len(B):
        if(A[i] == B[j]):
            if i == 0 or A[i] != A[i-1]:
                intersection_A_B.append(A[i])
            i, j = i+1, j+1
        elif A[i] < B[j]:
            i += 1
        else:
            j += 1
    return intersection_A_B
    
