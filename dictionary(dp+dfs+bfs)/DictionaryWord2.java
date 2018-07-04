// add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
// given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"], the solution is ["cats and dog", "cat sand dog"].
//https://www.programcreek.com/2012/12/leetcode-solution-word-break/
//dp + dfs
// Instead of using a boolean array to track the matched positions, we need to track the actual matched words
public static List<String> wordBreak(String s, Set<String> dict) {
    //create an array of ArrayList<String>
    List<String> dp[] = new ArrayList[s.length()+1];
    dp[0] = new ArrayList<String>();

    for(int i=0; i<s.length(); i++){
        if( dp[i] == null )
            continue;

        for(String word:dict){
            int len = word.length();
            int end = i+len;
            if(end > s.length())
                continue;

            if(s.substring(i,end).equals(word)){
                if(dp[end] == null){
                    dp[end] = new ArrayList<String>();
                }
                dp[end].add(word);
            }
        }
    }

    List<String> result = new LinkedList<String>();
    if(dp[s.length()] == null)
        return result;

    ArrayList<String> temp = new ArrayList<String>();
    dfs(dp, s.length(), result, temp);

    return result;
}
//depth first search to get all the possible paths, i.e., the list of strings.
public static void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
    if(end <= 0){
        String path = tmp.get(tmp.size()-1);
        for(int i=tmp.size()-2; i>=0; i--){
            path += " " + tmp.get(i) ;
        }

        result.add(path);
        return;
    }

    for(String str : dp[end]){
        tmp.add(str);
        dfs(dp, end-str.length(), result, tmp);
        tmp.remove(tmp.size()-1);
    }
}
