# brute force: use hashtable O(n) O(n)

# sort and remove duplicate O(nlgn + n)   O(1)
def eliminate_duplicate(A):
    A.sort()
    index = 1
    for each in A[1:]:
    # a for i, a in enumerate(A)
        if each != A[index - 1]:
            A[index] = each
            index += 1
    del A[index:]
