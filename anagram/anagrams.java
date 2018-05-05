//anagram
//当两个string排序以后相同，则它们是anagrams。这样anagrams会有相同的key
//可以使用一个hashtable，string s的key是它自己排序后的string，
//这样anagrams会有相同的key。用一个vector<int>来记录相同key的string
//在input vector<string>中的index。最后扫描一遍hashtable，
//当有两个或以上string有相同的key时，将它们输出到结果。

//solution2: sort
	public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        //(sorted String-anagram collection)
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray(); 
            Arrays.sort(arr); //use arrays.sort(int[]) 
            String s = String.valueOf(arr);
            if (!map.containsKey(s)) {
                //ArrayList<String> list = ;
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(strs[i]);
        } 
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                result.addAll(entry.getValue());
            }
        }
        return result;
	}
//solution1: hashtable
public List<String> anagrams(String[] strs) {
	ArrayList<String> res = new ArrayList<>();
	HashMap<Integer, ArrayList<String>> map = new HashMap<>();

	for(Stirng str : strs){
		int[] count = new int[26];
		for(int i = 0; i < str.length(); i++)
			count[str.charAt(i) - 'a']++;
		int hash = getHash(count);
		if(!map.containsKey(hash))
			map.put(hash, new ArrayList<String>());
		else
			map.get(hash).add(str);
	}
	for(ArrayList<String> temp : map.values()){
		if(temp.size() > 1)
			res.addAll(temp);
	}
	return res;
}
private int getHash(int[] count){
	int hash = 0;
	int a = 378551;
	int b = 63689;
	for(int num : count){
		hash = hash * a + num;
		a = a*b;
	}
	return hash;
}