//all subsequences of sorted string
public List<String> subSetsII(String set) {
  List<String> res = new ArrayList<>();
  if(set == null)
    return res;
  char[] arr = set.toCharArray();
  Arrays.sort(arr);
  StringBuilder sb = new StringBuilder();
  dfs(arr, sb, 0, res);
  return res;
}
private void dfs(char[] arr, StringBuilder sb, int index, List<String> res){
  res.add(sb.toString());
  for(int i = index; i < arr.length; i++){
    if(i == index || arr[i] != arr[i-1]){
      sb.append(arr[i]);
      dfs(arr, sb, i+1, res);
      sb.deleteCharAt(sb.length()-1);
    }
  }
}
  //[, a, ab, abc, ac, b, bc, c]
private void dfs(char[] arr, 
                   StringBuilder path, 
                   int index, 
                   List<String> res){
    if(index == arr.length){
      res.add(path.toString());
      return;
    }
    dfs(arr, path.append(arr[index]), index+1, res);
    path.deleteCharAt(path.length()-1);
    while(index < arr.length-1 && arr[index] == arr[index+1]){
      index++;
    }
    dfs(arr, path, index+1, res);
}