//N*N matrix clock-wise traverse
//solution1: recursion
public List<Integer> spiralI(int[][] matrix) {
    // Write your solution here.
    List<Integer> res = new ArrayList<>();
    traverse(matrix, 0, matrix.length, res);
    return res;;
}
private void helper(int[][] matrix, int offset, int size, List<Integer> res){
	//base case when onely 1 or 0 element left
	if(size == 0)
		return;
	if(size == 1){
		res.add(matrix[offset][offset])
		return;
	}
	//dealing with 4 edges, each edge run size-1 times!
	for(int i = 0; i < size-1; i++){
		res.add(matrix[offset][offset+i]);
	}
	for(int i = 0; i < size-1; i++){
		res.add(matrix[offset+i][offset+size-1]);
	}
	for(int i = size-1; i >=1; i--){
		res.add(matrix[offset+size-1][offset+i]);
	}
	for(int i = size-1; i >=1; i--){
		res.add(matrix[offset+i][offset]);
	}
	//inner circle traverse
	//rule: size-2(bound), offset+1
	helper(matrix, offset+1, size-2, res);
}
//solution2: iterative
public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
    List<Integer> res = new ArrayList<>();
    int n = matrix.length;
    int start = 0;
    int end = n-1;
    while(start < end){
    	for(int i = start; i <= end; i++){
    		res.add(matrix[start][i]);
    	}
    	for(int i = start+1; i <= end; i++){
    		res.add(matrix[i][end]);
    	}
    	for(int i = end; i>= start+1; i--){
    		res.add(matrix[end][i]);
    	}
    	for(int i = end-1; i>= start+1; i--){
    		res.add(matrix[i][start]);
    	}
    	start++;
    	end--;
    }
    //if at last we have 1 element left
    if(start == end)
    	res.add(matrix[start][end]);
    return res;
}