//determin if a word can be composed by concatenating words from the given dictionary.
//solution1: dp: 左大段 右xiao段， O(string length * dict size). similar to array hopper1
public boolean canBreak(String input String[] dict){
	Set<String> set = buildSet(dict);
	//arr[i]: input[i-1] or input.substring(0,i), good to have the matching!
	boolean[] arr = new boolean[input.length()+1];
	arr[0] = true;
	for(int i = 1; i < arr.length; i++){
		for(int j = 0; j < i; j++){
			if(set.contains(input.substring(j, i)) && arr[j]){
				arr[i] = true;
				break;
			}
		}
	}
	return arr[arr.length-1];
}
private Set<String> buildSet(String[] dict){
	Set<String> set = new HashSet<>();
	for(String s : dict)
		set.add(s);
	return set;
}
//optimization from O(n^3) - > O(n^2) Trie + dp
public boolean wordBreak1(string str, String[] dict){
	Trie trie = new Trie();
	for(String each : dict){
		trie.insert(each);
	}
	boolean[] dp = new boolean[str.length()+1];
	dp[0] = true;
 	int size = s.length();
	for(int i = 0; i < s.length(); i++){
		if(trie.search(str.substring(i, size-i)) && dp[i])
			dp[i] = true;
	}
	return dp[dp.legnth - 1];
}

//Trie
//https://leetcode.com/problems/word-break/discuss/197410/Java-Implementation-with-Trie-and-DP-beats-99-of-Java-solutions
//space: O(nm) n words with each length on average of m
private class TrieNode{
	int counter;  //how many words are on this subtree
	Map<Character, TrieNode> children;
	boolean isWord;  //is the end of a word
	public TrieNode(){
		this.counter = 0
		this.children = new HashMap<Character, TrieNode>();
		this.isWord = false;
	}
private class Trie{
	TrieNode root ;
	public Trie(){
		this.root = new TrieNode();
	}
	// common API: insert, search, start with
	public boolean insert(String word){
			if(search(word))
				return true;
			TrieNode cur = root;
			for(int i = 0; i < word.length(); i++){
				TrieNode next = cur.children.get(word.charAt(i));
				if(next == null){
					next = new TrieNode();
					cur.children.put(word.charAt(i), next);
				}
				cur = next;
				cur.counter++;
				return true;
	}

	public boolean delete(String word){
		if(!search(word))
			return false;
		TrieNode cur = root;
		for(int i = 0; i < word.length(); i++){
			TrieNode next = cur.children.get(word.charAt(i));
			next.count--;
			if(next.count == 0){
				cur.children.remove(word.charAt(i;
				return true;
			}
			cur = next;
		}
		cur.isWord = false;
		return true;
	}

	public boolean search(String word){
			TrieNode cur = root;
			for(int i = 0; i < word.length(); i++){
				TrieNode next = cur.children.get(word.charAt(i));
				if(next == null){
					return false;
					cur = next;
				}
				return cur.isWord;
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
