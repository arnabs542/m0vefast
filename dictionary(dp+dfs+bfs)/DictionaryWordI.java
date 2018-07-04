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
//https://www.programcreek.com/2012/12/leetcode-solution-word-break/
//solution2: O(n^2) good if the dict is big
public boolean wordBreak(String s, Set<String> wordDict) {
    int[] pos = new int[s.length()+1];

    Arrays.fill(pos, -1);

    pos[0]=0;

    for(int i=0; i<s.length(); i++){
        if(pos[i]!=-1){
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i, j);
                if(wordDict.contains(sub)){
                    pos[j]=i;
                }
            }
        }
    }

    return pos[s.length()]!=-1;
}
