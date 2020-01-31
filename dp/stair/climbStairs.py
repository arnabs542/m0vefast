#choises of 1 and 2, return how many differen ways to climb
#dp + memorization

# public int climbStairs(int n){
# 	if (n <= 2)
#       return n;
#     int lastlast = 1;
#     int last = 2;
#     int now = 0;
#     for(int i = 2; i < n; i++){
#     	now = lastlast + last;
#       lastlast = last;
#       last = now;
#     }
#     return now;
#   }
# }
def stairs(n):
  if n <= 1:
    return n

  m = []
  m.append(1)
  m.append(2)
  
  ### dom not use
  # m[0] = 1
  # m[1] = 2

  for i in range(2, n):
    m.append(m[i-1] + m[i-2])

  return m[n-1]
/*
题目问的是到n级台阶有多少种可能，从任意低级台阶到达n级台阶（n>=2）只有两种可能，要么从n-2上来要么从n-1上来，
如果f(n)是到n级的可能性，那么它必然是f(n-1):(到达n-1级台阶的可能性，
  走了一级台阶到达n) 加上f(n-2):(到达n-2级台阶的可能性， 走了两级台阶到达n) 之和，
这题中，lastlast就是n-2级台阶的可能性，last就是n-1级台阶的可能性，now就是当前n级台阶的可能性
*/