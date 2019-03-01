//Given a 2D board and a list of words from the dictionary, find all words in the board.
//https://www.programcreek.com/2014/06/leetcode-word-search-ii-java/
//optimal solution: dfs + trie
public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        Trie trie = new Trie();
        for(String each : words){
            trie.insert(each);
        }
         //注意去重问题
// [["a","a"]]
// ["a"]
// Output:
// ["a","a"]
// Expected:
// ["a"]
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(board, trie, visited, i, j, "", res);
            }
        }
        return new ArrayList<String>(res);
    }
    private void dfs(char[][] board, Trie trie, boolean[][] visited, int i, int j, String path, Set<String> res){
        int n = board.length;
        int m = board[0].length;
        //validation
        if(!isValid(i, j, n, m))
            return;
        if(visited[i][j])
            return;
        path = path + board[i][j];
        if(!trie.startsWith(path))
            return;
        if(trie.search(path))
            res.add(path);
        //dfs optiosn
        visited[i][j] = true;
        dfs(board, trie, visited, i+1, j, path, res);
        dfs(board, trie, visited, i-1, j, path, res);
        dfs(board,  trie, visited, i, j+1, path, res);
        dfs(board,  trie, visited, i, j-1, path, res);
        visited[i][j] = false;
    }
    private boolean isValid(int i, int j, int n, int m){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
//Trie Node
class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
}

//Trie
class Trie{
    public TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null){
                node.children[c-'a']= new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.item = word;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        if(node.item.equals(word)){
            return true;
        }else{
            return false;
        }
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}
//brute force solution: dfs
public List<String> wordSearch2(char[][] board, String[] words){
  List<String> res = new ArrayList<>();
  int n = board.length;
  int m = board[0].length;
  for(String word : words){
    boolean isFound = false;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        char[][] newBoard = new char[n][m];
        for (int x = 0; x < n; x++){
					for (int y = 0; y < m; y++){
						newBoard[x][y] = board[x][y];
          }
        }
        if (dfs(newBoard, word, i, j, 0)) {
					isFound = true;
				}
      }
    }
    if (isFound) {
      result.add(word);
    }
    return res;
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
