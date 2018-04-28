
public List<String> subSets(String set){
  List<String> res = new ArrayList<>();
  if(set == null) return res;
  char[] input = set.toCharArray();
  //to record the curret subset
  StringBuilder sb = new StringBuilder();
  dfs(input, sb, 0, res);
  return res;
}
//[abc, ab, ac, a, bc, b, c, ]%
private void dfs(char[] input, StringBuilder sb, int index, List<String> res){
  //base case: when reach the 3rd level
  if(index == input.length){
    res.add(sb.toString());
    return;
  }
  //case1: pick the char at index
  sb.append(input[index]);
  dfs(input, sb, index+1, res);
  sb.deleteCharAt(sb.length()-1);
  //case2: not pick the char at index
  dfs(input, sb, index+1, res);
}

	//[, a, ab, abc, ac, b, bc, c]
private void dfs(char[] input, StringBuilder sb, int index, List<String> res){
  res.add(sb.toString());
  //accesding order of the indces of the picked chars
  for(int i = index; i < input.length; i++){
    sb.append(input[i]);
    dfs(input, sb, i+1; res);
    sb.deleteCharAt(sb.length()-1);
  }
}
