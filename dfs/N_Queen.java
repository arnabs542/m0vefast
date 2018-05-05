public ArrayList<ArrayList<String>> solveNQueens(int n) {
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
				//for each column, which row locate the chess
				//contains[colIndex, colIndex...] for each row
				 ArrayList<Integer> cols, //path 
				 //int row,  //startIndex
				 int n){
	if(cols.size() == n){
		res.add(renderBoard(cols));  //render return path
		return;
	}
	for(int colIndex = 0; colIndex < n; colIndex++){
		if(isValid(cols, colIndex)){ //check each vertically is valid
			//cols: 记录之前所放皇后的列坐标
			cols.add(colIndex); //逐行放置皇后：排除在同一行的可能。
			dfs(res, cols, colIndex, n);
			cols.remove(cols.size()-1);
		}
	}
}
private ArrayList<String> renderBoard(ArrayList<Integer> cols){
	ArrayList<String> chessboard = new ArrayList<>();
	for(int i = 0; i<cols.size(); i++){
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < cols.size(); j++){
			sb.append(j == cols.get(i)? 'Q' : '.');
		}
		chessboard.add(sb.toString());
	}
	return chessboard;
}
private boolean isValid(ArrayList<Integer> cols, int column){
	int row = cols.size(); //cols.size() is dynamic 
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
    dfs(res, cols, 0, n);
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
		if(cols.get(rowIndex) == colIndex ||
			Math.abs(rowIndex - row) == Math.abs(cols.get(rowIndex) - colIndex))
			return false;
	}
	return true;
}
