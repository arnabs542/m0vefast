//23:["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// stringbuilder: deleteCharAt(path.size()-1)
// list: remove(path.size()-1)
// arr: ??
public List<String> letterCombinations(String digits) {
    Map<Character, char[]> map = new HashMap<Character, char[]>();
    map.put('2', new char[]{'a','b','c'});
    map.put('3', new char[]{'d','e','f'});
    map.put('4', new char[]{'g','h','i'});
    map.put('5', new char[]{'j','k','l'});
    map.put('6', new char[]{'m','n','o'});
    map.put('7', new char[]{'p','q','r','s'});
    map.put('8', new char[]{'t','u','v'});
    map.put('9', new char[]{'w','x','y','z'});

    List<String> result = new ArrayList<String>();
    if(digits == null || digits.length() == 0)
        return result;

    helper(result, new StringBuilder(), digits, 0, map);

    return result;

}

public void helper(List<String> result, StringBuilder path, String digits, int index, hMap<Character, char[]> map){
    if(index>=digits.length()){
        result.add(path.toString());
        return;
    }

    char number = digits.charAt(index);
    char[] candidates = map.get(number);
    //loop throught the map value, not the input digits array
    //use index to track and loop the given input array
    for(int i=0; i<candidates.length; i++){
        path.append(candidates[i]);
        helper(result, path, digits, index+1, map);
        path.deleteCharAt(path.length()-1);
    }
}
