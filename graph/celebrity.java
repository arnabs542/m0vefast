//binary matrix: facebook
//given the matrix length n*n
//https://www.jiuzhang.com/solution/find-the-celebrity/
//The idea is to use two pointers, one from start and one from the end. Assume
//the start person is A, and the end person is B. If A knows B, then A must not be the celebrity. Else, B must not be the celebrity.
//We will find a celebrity candidate at the end of the loop. Go through each person again and check whether this is the celebrity.
public int celebrity(int[][] matrix) {
   // Write your solution here
   int n = matrix.length;
   int left = 0;  //celebrity
   int right = n-1;
   //celebreity sits between left and right
   while(left < right){
     if(matrix[left][right] == 1)
        left++;
     else
        right--;
   }
   //now left = right, check left/right if it is a celebreity
   for(int i = 0; i < n; i++){
     if(i != left && (matrix[i][left] == 0 || matrix[left][i] == 1))
      return -1;
   }
   return left;
 }
