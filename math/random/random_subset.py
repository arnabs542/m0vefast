# given n and size k<= n, return a sizek-k subset of {0,1,...n-1}
import random

# O(k) O(k)

def random_subset(n, k):
    changed_elements = {}
    for i in range(k):
        # generate a random index between i and n-1 []
        random_index = random.randrange(i, n)
        random_index_mapped = changed_elements.get(random_index, random_index)
        i_mapped = changed_elements.get(i,i)
        changed_elements[random_index] = i_mapped
        changed_elements[i] = random_index_mapped

    return [changed_elements[i] for i in range(k)]

