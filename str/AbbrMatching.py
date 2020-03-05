#pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.


# iterative 
def abbrMatching(source, pattern):
  i, j = 0, 0
  while i < len(source) and j < len(pattern):
    if source[i] == pattern[j]:   # same char 
      i += 1
      j += 1

    elif pattern[j].isdigit() and pattern[j] != '0':   # a number 
      start = j
      while j < len(pattern) and pattern[j].isdigit():
        j += 1
      i += int(pattern[start:j])

    else:                     # not same char , fasle 
      return False

    return i == len(source) and j == len(pattern)




# recursion, didnt pass the test, might be the return statement 
def abbrMaching(input, pattern):
  return helper(list(input), list(pattern), 0, 0)
def helper(source, pattern, si, pi):
  # base case
  if si == len(source) and pi == len(pattern):
    return True
  if si >= len(source) or pi >= len(pattern):   # has to be >= not >
    return False

  # t is a char
  if pattern[pi] < '0' or pattern[pi] > '9':     # if not str.isDigit()
    if pattern[pi] == source[si]:
      return helper(source, pattern, si+1, pi+1)
    else:
      return False
  else: # t is digit
    count = 0
    while pi < len(pattern) and pattern[pi] >= '0' and pattern[pi] <= '9':
      count = count * 10 + (ord(pattern[pi]) - ord('0'))
      pi += 1
    return helper(source, pattern, si+count, pi)







