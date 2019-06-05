//M*N matrix clock-wise traverse
//solution1: iterative
public List<Integer> spiralII(int[][] matrix) {
    // Write your solution here.
    List<Integer> res = new ArrayList<>();
    int m = matrix.length;
    if(m == 0)
    	return res;
    int n = matrix[0].length;
    int left = 0;
    int right = n-1;
    int up = 0;
    int down = m-1;
    //base case: nothing left; one row left; one column left
    while(left < right && up < down){
      for(int i = left; i < right; i++)
        res.add(matrix[up][i]);
      for(int i = up; i < down; i++)
        res.add(matrix[i][right]);
      for(int i = right; i > left; i--)
        res.add(matrix[down][i]);
      for(int i = down; i > up; i--)
        res.add(matrix[i][left]);   
    	left++;
    	right--;
    	up++;
    	down--;
    }
	//base case1: nothing left
	if(left > right || up > down)
		return res;
	//base case2: one col left
	if(left == right){
		for(int i = up; i <= down; i++)
			res.add(matrix[i][left])
	}else{ //base case3: one row left
		for(int i = left; i <= right; i++)
			res.add(matrix[up][i]);
	}
    return res;
}
