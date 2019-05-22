# construct a random subset of size k+1 given randome subset of size k
# solution: brute force: iteration + select with probablity of k/n, there might be more thatn k entries in the end
# solution2: enumerate all subsets of size k and random select one, there are (n, k) subsets of size k
# solution3:
import random


def random_sampling(k, A):
    for i in range(k):
        # generate a random index in [i, len(A) - 1]
        r = random.randint(i, len(A) - 1)  #range index[0, length(A)-1], all index
        A[i], A[r] = A[r], A[i]