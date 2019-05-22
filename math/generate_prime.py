# generate all primes up to and including n

# solution1: brute force: O(n * sqrt(n))

# solution2: iterate, if prime then eleimtate all its muptiles   O(nloglogn), O(n)
def generate_primes(n):
    primes = []
    is_prime = [False, False] + [True] * (n - 1) # boolean, if prime or not, not considering 0 and 1
    for p in range(2, n+1):  # including n
        if is_prime[p]:
            primes.append(p)
            for i in range(p, n+1, p):  # from p to n, every p    O(n/p), so overall is O(n/2)+O(n/3)+O(n/5)+...=O(nloglogn)
                is_prime[i] = False
    return primes