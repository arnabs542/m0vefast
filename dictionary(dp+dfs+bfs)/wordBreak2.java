// add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
// given s = "acatsanddog", dict = ["a", "cat", "cats", "and", "sand", "dog"],
// the solution is ["acats and dog", "acat sand dog"].
// https://www.jiuzhang.com/solutions/word-break-ii/
// solution1: memorization + dp  O(n^3)
// Instead of using a boolean array to track the matched positions, we need to track the actual matched words
public List<String> wordBreak(String s, Set<String> dict) {
  Map<String, ArrayList<String>> dp = new HashMap<>();
  return dfs(s, dict, dp);
}
//dfs组合: dp {str : [concatination combination]} eg: {sanddog:[sand dog, san ddog]}
//return list of concatination combination given a key(string)
private ArrayList<String> dfs(String s, Set<String> dict,  Map<String, List<String>> dp){
  //base case1: suffix cached before
  if(dp.containsKey(s))
    return dp.get(s);
  //base case2, length = 0
  List<String> res = new ArrayList<>();
  if(s.length() == 0)
    return res;
  //suffix 在dict存在, prefix+suffix是一个结果
  if(dict.contains(s))
    res.add(s);
  //analysing suffix as input 
  for(int i = 1; i < s.length(); i++){
    String prefix = s.substring(0, i);  //zuodaduan
    if(dict.contains(prefix)){
      String suffix = s.substring(i);   //possible youxiaoduan
      List<String> segmentations = dfs(suffix, dict, dp);
      for(String seg : segmentations){
        res.add(prefix + " " + seg);
      }
    }
  }
  dp.put(s, res);
//printout dp:
// {dog=[dog]}
// {sanddog=[sand dog], dog=[dog]}
// {sanddog=[sand dog], nddog=[], dog=[dog]}
// {anddog=[and dog], sanddog=[sand dog], nddog=[], dog=[dog]}
// {anddog=[and dog], sanddog=[sand dog], nddog=[], dog=[dog], catsanddog=[cat sand dog, cats and dog]}
// {anddog=[and dog], sanddog=[sand dog], acatsanddog=[a cat sand dog, a cats and dog], nddog=[], dog=[dog],
//         catsanddog=[cat sand dog, cats and dog]}
  return res;
}
abcd  a b+cd; a bc+d
      ab c+d; ab cd
res: [a b cd, a bc d, ab c d, ab cd]
-> abcd : [a b cd, a bc d]  i = 1
-> abcd : [ab c d, ab cd] i = 2
//solution2: trie + dfs
//The original solution will have bad performance if the String s is relatively short but the wordDict is relatively large
//trie is good for string matching, search the wordDict in O(minn(len(s), depth of Trie))
https://leetcode.com/problems/word-break-ii/discuss/44314/10ms-java-solution-with-dp-and-trie
