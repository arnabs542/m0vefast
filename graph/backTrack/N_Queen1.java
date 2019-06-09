// http://bangbingsyb.blogspot.com/search?q=N+queen
// 需要判断当前位置是否在同一行、列、对角线上这三个条
// 1. 逐行放置皇后：排除在同一行的可能。
// 2. 记录之前所放皇后的列坐标：col[i]=j表示第i行的皇后在第j列。这样在放置第i+1行时，只要保证col[i+1] != col[k], k=0...i 即可。
// 3. 对角线判断：对于任意(i1, col[i1])和(i2, col[i2])，只有当abs(i1-i2) = abs(col[i1]-col[i2])时，两皇后才在同一对角线。
public List<List<Integer>> nQueen1(int n) {
	//notice the difference on return type:
	1)
	//List<List<Integer>>
    //List<List<Integer>> res = new ArrayList<>();
	2)
	//return: List<List<Integer>>
	//ArrayList<List<Integer>> res = new ArrayList<List<>>();
    3)
	//ArrayList<ArrayList<String>>
 	ArrayList<ArrayList<String>> res = new ArrayList<>();
 	// if(n <= 0)
 	// 	return res;
 	dfs(res, new ArrayList<Integer>(), n);
 	return res;
}
private void dfs(ArrayList<ArrayList<String>> res,
				//for each row, which col locate the chess contains[colIndex, colIndex...] for each row
				 ArrayList<Integer> cols, //path
				 int n){
	if(cols.size() == n){
		res.add(cols);  //render return path
		return;
	}
	for(int colIndex = 0; colIndex < n; colIndex++){
		if(isValid(cols, colIndex)){ //check 3 conditions
			cols.add(colIndex); //逐行放置皇后：排除在同一行的可能。
			dfs(res, cols, n);
			cols.remove(cols.size()-1);
		}
	}
}
private boolean isValid(ArrayList<Integer> cols, int column){
	int row = cols.size();  //=column
	for(int rowIndex = 0; rowIndex < cols.size(); rowIndex++){
			//check vertical for each row
		if(cols.get(rowIndex) == column ||
			//check diagnoal
			//对于任意(i1, col[i1])和(i2, col[i2])，
			//只有当abs(i1-i2) = abs(col[i1]-col[i2])时，两皇后才在同一对角线。
			Math.abs(rowIndex - row) == Math.abs(cols.get(rowIndex) - column)
			// rowIndex + cols.get(rowIndex) == row + column ||
			// rowIndex - cols.get(rowIndex) == row - column)
			return false;
	}
	return true;
}
//laicode
public List<List<Integer>> nqueens(int n) {
    // Write your solution here.
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> cols = new ArrayList<>();
    dfs(res, cols, n);
    return res;
}
private void dfs(List<List<Integer>> res,
				ArrayList<Integer> cols,  //path
				int n){
	if(cols.size() == n)
		//todo
		//res.add(cols);
		res.add(new ArrayList<>(cols));

	else{
		for(int colIndex = 0; colIndex < n; colIndex++){
			if(isValid(cols, colIndex)){
				cols.add(colIndex);
				dfs(res, cols, n);
				cols.remove(cols.size()-1);
			}
		}
	}
}
private boolean isValid(List<Integer> cols, int colIndex){
	int row = cols.size();
	for(int rowIndex = 0; rowIndex < cols.size(); rowIndex++){
		if(cols.get(rowIndex) == colIndex || Math.abs(rowIndex - row) == Math.abs(cols.get(rowIndex) - colIndex))
			return false;
	}
	return true;
}
