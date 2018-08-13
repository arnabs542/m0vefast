http://massivealgorithms.blogspot.com/2015/06/leetcode-254-factor-combinations.html
public List<List<Integer>> factors(int n) {
    // Write your solution here
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(res, path, n, 2);
    return res;
  }
private void dfs(List<List<integer>> res, List<Integer> path, int n, int startIndext){
  if(n == 1){
    if(path.size() > 1){
      res.add(path);
      return res;
    }
  }
  for(int i = startIndex; i <= n; i++){
    if(n % i){
      path.add(i);
      dfs(res, path, n/i, i);
      path.remove(path.size()-1)
    }
  }
}
  因子从小到大的顺序排列
由于题目中说明了1和n本身不能算其因子，那么我们可以从2开始遍历到n，如果当前的数i可以被n整除，
说明i是n的一个因子，我们将其存入一位数组out中，然后递归调用n/i，此时不从2开始遍历，
而是从i遍历到n/i，停止的条件是当n等于1时
