// Given a 2D board and a word, find if the word exists in the grid.
// dfs
public boolean wordSearch1(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;

    boolean result = false;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
           if(dfs(board,word,i,j,0)){
               result = true;
           }
        }
    }

    return result;
}

public boolean dfs(char[][] board, String word, int i, int j, int k){
      int n = board.length;
      int m = board[0].length;
      //validation
      if(!isValid(i, j, n, m)){
          return false;
      }
      //validation
      if(word.charAt(index) != board[i][j]){
          return false;
      }
      //base case
      if(index == word.length() - 1)
          return true;

      //dfs options for
      //1)
      char temp = board[i][j];
      board[i][j] = '#';
      //2)
      if(dfs(board, word, i+1, j, index+1) || dfs(board, word, i, j+1, index+1) || dfs(board, word, i-1, j, index+1) || dfs(board, word, i, j-1, index+1)){
          return true;
      }
      //3)
      board[i][j] = temp;
      return false;
  }

  private boolean isValid(int i, int j, int n, int m){
      return i >= 0 && i < n && j >= 0 && j < m;
  }
