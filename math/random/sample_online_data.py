# continusly maintain a subset of size k given it and k
# assumption: at least k elements in it
import itertools
import random


def online_random_sample(it, k):
    sample_res = list(itertools.islice(it, k))   # Make an iterator (iterable, stop), first k iterable items forming a list

    num_seen_sofar = k
    for x in it:
        num_seen_sofar += 1

        # random generate number in [0, num_seen_sofar - 1]
        # if such number is in [0, k-1]
        # replace from the sample with current number x
        index_to_replace = random.randrange(num_seen_sofar)  # return random selected number from range(k)
        if index_to_replace < k:
            sample_res[index_to_replace] = x

    return sample_res


if __name__ == '__main__':
    A = [7, 8, 9, 10]

    online_random_sample(A, 3)
