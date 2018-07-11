//rightside 90 degree rotate
public void rotate(int[][] matrix){
    int n = matrix.length;
    if(n <= 1)
        return;
    rotateY(matrix, n);
    rotateYX(matrix, n);
}
private void rotateY(int[][] matrix){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n/2; j++)
            swap(matrix, i, j, i, n-1-j);
    }
}
private void rotateYX(int[][] matrix){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n - 1 -i; j++){
            swap(matrix, i, j, n - 1 - j, n - 1- i);
        }
    }

}
//multiplication
//res = one * two  1332
public double[][] multiply(double[][] one, double[][] two){
    if(one == null || one.length == 0 || one[0] == null || one[0].length == 0)
        return new RuntimeException("illegal");
    if(one == null || one.length == 0 || one[0] == null || one[0].length == 0)
        return new RuntimeException("illegal");
    int row1 = one.length;
    int col1 = one[0].length;
    int row2 = two.length;
    int col2 = two[0].length;
    if(row1 != col2)   //col1 should == row1
        return new RuntimeException("illegal input matrix demension")
    double[][] res = new double[row1][col2];
    for(int i = 0; i < row1; i++){
        for(int j = 0; j < col2; j++){
            for(int k = 0; k < col1; k=+){
                res[i][j] = one[i][k] * two[k][j];
            }
        }
    }
    return res;
}
//generator
//iterative nn
public int[][] generator(int n){
    int[][] res = new int[n][n];
    if(n < 1)
        return res;
    int start = 0;
    int end = n-1;
    int num = 1;
    while(start < end){
        for(int i = start; i <= end; i++){
        res[start][i+start] = num++;
    }
    for(int i = start+1; i <= end-1; i++){
        res[i][end] = num++;
    }
    for(int i = end; i >= start; i--){
        res[end][i] = num++;
    }
    for(int i = end-1; i >= start+1; i--){
        res[i][start] = num++;
    }

        start++;
        end--;
    }
    return res;
}
//recursion nn
public List<Integer> traversal(int[][] matrix){
    List<Integer> res = new ArrayList<>();
    int n = matrix.length;
    if(n < 1)
        return res;
    helper(matrix, 0, n, res);
    return res;
}
private void helper(int[][] matrix, int offset, int size, List<Integer> res){
    if(size == 0)
        return;
    for(int i = 0; i < size-1; i++)
        res.add(matrix[offset][i+offset]);
    for(int i = 0; i < size-1; i++)
        res.add(matrix[i+offset][size-offset+1]);
    for(int i = size-1; i >= 1; i--)
        res.add(matrix[size-offset+1][i+offset]);
    for(int i = size-1; i >= 1; i--)
        res.add(matrix[offset+i][offset]);
    helper(matrix, offset+1, size-2, res);
}
//generator mn
public int[][] generator2(int n, int m){
    int[][] res = new int[n][m];
    if(n == 0 || m == 0)
        return res;
    int left = 0;
    int right = m-1;
    int up = 0;
    int bottom = n-1;
    int num = 1;
    while(left < right && up < bottom){
        for(int i = left; i < right; i++)
            matrix[left][i] = num++;
        for(int i = up+1; i < bottom-1; i++)
            matrix[i][right] = num++;
        for(int i = right; i >= left; i--)
            matrix[bottom][i] = num++;
        for(int i = bottom-1; i > up+1; i--)
            matrix[i][left] = num++;
        left++;
        right--;
        up++;
        bottom--;
    }
    while(right > left || up > down)
        return matrix;
    while(left <= right)
        matrix[up][left++] = num++;
    while(up < bottom)
        matrix[left][up++] = num++;
    return res;
}
public List<Integer> traversal2(int[][] matrix){
    List<Integer> res = new ArrayList<>();
    int n = matrix.lenght;
    int m = matrix[0].length;
    if(n == 0 || m == 0)
        return res;
    int left = 0;
    int right = n-1;
    int up = 0;
    int bottom = m-1;
    while(left < right && up < bottom){
        for(int i = left; i <= right; i++)
            res.add(matrix[up][i]);
        for(int i = up+1; i <= right-1; i++)
            res.add(matrix[i][right]);
        for(int i = right; i>= left; i--)
            res.add(matrix[bottom][i])
        for(int i = bottom+1; i>= up+1; i--)
            res.add(matrix[i][left])
        left++;
        right--;
        up++;
        bottom--;

    }
    while(left > right || up > bottom)
        retrun res;
    while(left < right)
        res.add(matrix[up][left++]);
    while(up < bottom)
        res.add(matrix[left][up++]);
    return res;
}

