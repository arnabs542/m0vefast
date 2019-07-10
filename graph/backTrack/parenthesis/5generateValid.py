'''
generate: dfs()
### remianing for each backet
### rule to define palindrome order

private static final char[] input = new char[]{'(',')','[',']','{','}'};
l for (, m for [, n for {
'''
def generateValidParenthesis2(l, m, n):
    remian = [l, l, m, m, n, n]
    self.input = ['(',')','[',']','{','}']
    res = []
    targetlen = 2 * (l + n + m)
    stack = []
    dfs(res, remain, "", stack, targetlen)
    return res

def dfs(res, remian, path, stack, targetlen):
    # depth: when path reach target_len
    if len(path) == targetlen:
        res.append(path)
        return

    # branching factor: write which bracket at the path[index/depth]
    for i in range(len(input)):
        if i % 2 == 0:  # left bracket
            if remain[i] > 0:
                remain[i] -= 1
                stack.append(input[i])
                dfs(res, remain, path+remain[i], stack, targetlen)
                remain[i] += 1
                stack = stack[:-1]

        else:  # right bracket
            if(stack and stack[-1] == input[i-1]): # right bracket is the same type of bracket
                remain[i] -= 1
                stack.append(input[i])
                dfs(res, remain, path+[i], stack, targetlen)
                remain[i] += 1
                stack = stack[:-1]





    for(int i = 0; i < remain.length; i++){
      //if on index 0,2,4... ready for left
      if(i % 2 == 0){
        if(remain[i] > 0){
          path.append(input[i]);
          stack.offerFirst(input[i]);
          remain[i]--;

          dfs(res, path, targetlen, remain, stack);

          path.deleteCharAt(path.length()-1);
          stack.pollFirst();
          remain[i]++;
        }
      }else{ //ready for right 1) cannot start with ) and 2) last is a
        if(!stack.isEmpty() && stack.peekFirst() == input[i-1]){
          path.append(input[i]);
          stack.pollFirst();
          remain[i]--;

          dfs(res, path, targetlen, remain, stack);

          path.deleteCharAt(path.length()-1);
          stack.offerFirst(input[i-1]);
          remain[i]++;
        }
      }
    }
  }
}
