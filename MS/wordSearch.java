https://leetcode.com/problems/word-search/
public boolean exist(char[][] board, String word) {
  if(word == null || board == null || board.length == 0 || word.size() == 0)
    return true;
  for(int i = 0; i < board.length; i++){
    for(int j = 0; j < board[i].length; i++){
      if(dfs(board, word, i, j, 0)){
        return true;
      }
    }
  return false;
}
//dfs:
//level: there are k levels, each level represent matching condition of board with kth word
//branch: 4 directions to go if cur word match
private boolean dfs(char[][] board, String word, int i, int j, int k){
  //prune
  if(!isValid(board,i, j){
    return false;
  }
  //basic condition
  if(grid[i][j] == word.charAt(k)){
    //base cases
    if(k == word.length())
      return true;

    else{
      //mark as visited, grid boolean map passed in, save space
      char cur = board[i][j];
      board[i][j] = '#';
      //for options
      if(dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1) || dfs(board, word, i-1, j, k+1) || dfs(board, word, i+1, j, k+1)){
          return true;
      }
      //back trace mark as unvisited
      board[i][j] = cur;
    }
  }
  return false;
}
private boolean isValid(char[][] board, int i, int j){
  if(i < 0 || i >= board.length || j < 0 || j >= board[i].length)
    return false;
  return true;
}

//follow up:
https://www.programcreek.com/2014/06/leetcode-word-search-ii-java/
Given a 2D board and a list of words from the dictionary, find all words in the board.
//solution1: dfs runtime too long
for each word:
  for x
    for y
      newboard
      dfs(x, y, word, new board)
  if one of dfs is true, add result

//solution2: trie tree: If the current candidate does not exist in all words' prefix,
// we can stop backtracking immediately. This can be done by using a trie structure.
public List<String> findWords(char[][] board, String[] words){
  Set<String> res = new HashSet<>();
  //build prefiex tree
  Trie trie = new Trie();
  for(String each : words){
    trie.insert(each);
  }
  boolean[][] visited = new boolean[board.length][board[0].length];
  for(int i = 0; i < board.length; i++){
    for(int j = 0; j < board[0].length; j++){
      dfs(board, visited, "", i, j, trie, res);
    }
  }
  return res;
}
private void dfs(char[][] grid, boolean[][] visited, String str, int i, int j, Trie trie, Set<String> res){
  //pruen
  if(!isValid(grid, i, j))
    return;
  if(visited[i][j])
    return;
  if(!trie.startsWith(grid, str))
    return;
  //base case
  str = str + board[i][j];
  if(trie.search(str)){
    res.add(str);
    return;
  }else{
    //mark as visited
    visited[i][j] = true;
    dfs(grid, visited, str, i+1, j, trie, res);
    dfs(grid, visited, str, i-1, j, trie, res);
    dfs(grid, visited, str, i, j+1, trie, res);
    dfs(grid, visited, str, i, j-1, trie, res);
    visited[i][j] = false;
  }
}
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
