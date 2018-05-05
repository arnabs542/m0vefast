//solution1: convert 2d arr to 1d arr and binary search
public boolean searchMatrix(int[][] matrix, int target){
	int[] res = new int[]{-1,-1};
	if(matrix == null || matrix.length == 0) 
		return res;
	if(matrix[0] == null || matrix[0].length == 0)
		return res;

	int row = matrix.length;
	int col = matrix[0].length;
	int left = 0;
	int right = row*col -1; //go through all element in matrix

	while(left <= right){
		int mid = left + (right - left)/2;
		//given index of array in matrix, get position in matrix
		int midx = mid/col;
		int midy = mid%col;
		int value = matrix[midx][midy];
		if(value == target)
			return new int[]{midx, midy};
		else if(value > target)
			right = mid-1;
		else
			left = mid+1;
	}
	return res;
}
//solution2: 2 tiems binary search
http://www.jiuzhang.com/solutions/search-a-2d-matrix/
