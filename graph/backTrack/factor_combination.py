'''
Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
'''
def factor_combination(n):
    if n<=1:
        return []
    res = []
    i = 2
    while i*i <= n:    # avoid dup: 12: 2*6, 6*2
        if n % i == 0:
            q = n/i
            res.append([i,q])
            sols = factor_combination(q)
            # print(sols)
            for sol in sols:
                if sol[0] >= i:
                    res.append([i] + sol)
        i+=1
    return res
'''
func(12)
    12 = 6 * 2       =    4 * 3
    func(6)  i=2     func(4) i=3
        6 = 3 * 2         4 = 2 * 2
        func(3)          func(4)
            3=3*1              4=4*1   = 2 * 2(2<i)

Your input
12

stdout
[]
[[3, 2]]
[]
[[2, 2]]

Output
[[6,2],[2,3,2],[4,3]]
Expected
[[2,6],[3,4],[2,2,3]]
'''
