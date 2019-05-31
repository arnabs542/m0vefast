//solution1: sorted in one direction
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
//sorect in x and sorted in y
https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
//do binary search in 2 directions  O(m+n)
public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
