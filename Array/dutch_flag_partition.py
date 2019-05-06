# rainbow sort 变种
def dutch_flag_partition(pivot_index, A):
    pivot = A[pivot_index]
    # invariant:
    # bottom group: A[:smaller]
    # middle group: A[smaller:equal]
    # unclassified group: A[equal:larger]
    # top group: A[larger: ]
    # 3 个顶板 exclusive: small, equal, right
    smaller, equal, larger = 0, 0, len(A)
    while equal < larger:
        if A[equal] < pivot:
            A[smaller], A[equal] = A[equal], A[smaller]
            smaller, equal = small +1, equal+1

        elif A[equal] == pivot:
            equal -= 1
        else:
            larger -= 1
            A[equal], A[larger] = A[larger], A[equal]

def dutch_flag_partition(pivot_index, A):
    pivot = A[pivot_index]
    # invariant:
    # bottom group: A[:smaller]
    # middle group: A[smaller:equal]
    # unclassified group: A[equal:larger]
    # top group: A[larger: ]
    # 3 个顶板 exclusive: small, equal, right
    smaller, equal, larger = 0, 0, len(A)-1
    while equal <= larger:
        if A[equal] < pivot:
            A[smaller], A[equal] = A[equal], A[smaller]
            smaller, equal = small +1, equal+1

        elif A[equal] == pivot:
            equal -= 1
        else:
            A[equal], A[larger] = A[larger], A[equal]
            larger -= 1
