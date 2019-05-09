def removeduplicate_zuma(A):
    if not A or len(A) <= 1:
      return A

    slow = 0
    fast = 0
    while fast < len(A):
        fast += 1
        if (slow == -1 or A[slow] != A[fast]):
            slow+= 1
            A[slow] = A[fast]

        else:
            while (fast + 1 < len(A) and A[fast+1] == A[slow]):
                fast += 1
            slow -= 1

    return A[:slow+1]
