//return the total number of distinct solutions.
public int totalNQueens(int n) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    dfs(res, cols, n);
    return res.size();
  }
private void dfs(List<Integer> res, List<Integer> cols, int n){
  if(cols.size() == n){
    res.add(cols);
    return;
  }
  for(int colIndex = 0; colIndex < n; colIndex++){
    if(isValid(cols, column)){
      cols.add(colIndex);
      dfs(cols, cols, n);
      cols.remove(cols.size()-1);
    }
  }
}
private boolean isValid(List<Integer> cols, int column){
  int row = cols.size();
  for(int rowIndex = 0; rowIndex < row; rowIndex++){
    if(cols.get(rowIndex) == column || Math.abs(row - rowIndex) == Math.abs(cols.get(rowIndex) - column))
      return false;
  }
  return true;
}
