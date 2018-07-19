//234sum exist/list
public boolean 2sum(int[] arr, int target){
  Set<Integer> set = new HashSet<>();
  for(int each : arr){
    if(set.contains(target - each))
      return true;
    set.add(each);
  }
  return false;
}
public boolean 2sum2arr(int[] a, int[] b, int target){
  Set<Integer> set = new HashSet>();
  for(int each : a){
    set.add(each);
  }
  for(int each : b){
    if(set.contains(target - each))
      return true;
  }
  return false;
}
public boolean 3sum(int[] arr, int target){
  Arrays.sort(arr);
  for(int i = 0; i < arr.length; i++){
    int left = i+1;
    int right = arr.length;
    while(left < right){
      int cur_target = target - arr[i];
      if(arr[left] + arr[right] = cur_target){
        return true;
      }else if(arr[left] + arr[right] < cur_target){
        left++;
      }else{
        right--;
      }
    }
  }
  return false;
}
public boolean 3sum3arr(int[] a, int[] b, int target){
  Set<Integer> set = new HashSet>();
  for(int each : a){
    set.add(each);
  }
  for(int each : b){
    for(int second : c){
      if(set.contains(target - each - second))
        return true;
    }
  }
  return false;
}
public boolean 4sum(int[] arr, int target){
  for(int i = 0; i < arr.length-3; i++){
    for(int j = i+1; j < arr.length-2; j++){
      int left = j+1;
      int right = arr.length;
      while(left < right){
        int cur_target = target - arr[i] - arr[j];
        if(arr[left] + arr[right] == cur_target)
          return true;
        else if(arr[left] + arr[right] < cur_target)
          left++;
        else
          right--;
      }
    }
    return false;
}
//23 valuepari, indexpari,
public List<Integer> 2sumIndexPair(int[] arr, int target){
  //<arr[i], i>
  Map<Integer, List<Integer>> map = new HashMap<>();
  for(int i = 0; i < arr.length; i++){
    if(map.containsKey(target - arr[i])){
      for(int each : map.get(target- arr[i]))
        res.add(Arrays.asList(each, i));
    }else{
      map.put(arr[i], new ArrayList<>());
    }
    map.get(arr[i]).add(i);
  }
  return res;
}
public List<Integer> 3sumIndexPair(int[] arr, int target){
  List<Integer> res = new ArrayList<>();
  for(int i = 0; i < arr.length-2; i++){
    int left = i+1;
    int right = arr.length-1;
    if(left > 0 && arr[left] == arr[left-1]){
      //left++;
      continue;
    }
    while(left < right){
      if(arr[i] + arr[left] + arr[right] == target){
        res.add(Arrays.asLsit(i, left, right));
        left++;
        if(left< right && arr[left] == arr[left-1]){
          left++;
          //continue;
        }
      }else if(arr[i] + arr[left] + arr[right] < target){
        left++;
      }else{
        right--;
      }

    }
    return res;
}
public List<Integer> 2sumValuePair(int[] arr, int target){

}
public List<Integer> 2sumValuePair(int[] arr, int target){

}
//23_closetvaluepari
public int 2sumCloset(int[] arr, int target){
  List<Integer> res = new ArrayList>();
  int left = 0;
  int right = arr.length-1;
  int mindiff = 0;
  while(left < right){
    if(arr[left] + arr[right] == target){
      res.set(0, arr[left]);
      res.set(1, arr[right]);
      return;
    }
    if(target - arr[left] - arr[right] < mindiff){
      minDiff = target - arr[left] - arr[right];
      res.set(0, arr[left]);
      res.set(1, arr[right]);
    }
    if(arr[left] + arr[right] < target){
      left++;
    }else{
      right--;
    }
  }
  return res;
}
public int 3sumCloset(int[] arr, int target){
  List<Integer> res = new ArrayList>();
  int left = 0;
  int right = arr.length-1;
  int mindiff = 0;
  for(int i = 0; i < arr.length-2; i++){
    int left = i+1;
    int right = arr.length-1;
    while(left < right){
      if(arr[i] + arr[left] + arr[right] == target){
        res.set(0, arr[i]);
        res.set(1, arr[left]);
        res.set(2, arr[right]);
        return;
      }
      if(target - arr[i] - arr[left] - arr[right] < mindiff){
        minDiff = target - arr[left] - arr[right];
        res.set(0, arr[i]);
        res.set(1, arr[left]);
        res.set(2, arr[right])
      }
      if(arr[i] + arr[left] + arr[right] < target){
        left++;
      }else{
        right--;
      }
    }


  }
  return res;

}
//23_smallerValuePAri
public int 2sumSmallerPair(int[] arr, int target){
  int left = 0;
  int right= arr.length-1;
  while(left < right){
    if(arr[left]+  arr[right] <= target){
      right--;
    }else{
      res += right - left;
      left++;
    }
  }
  return res;

}
public int 3sumSmallerPair(int[] arr, int target){
  for(int i = 0; i < arr.length-2; i++){
    int left = i+1;
    int right = arr.length;
    while(left< right){
      if(arr[left]+arr[right] + arr[i] >= target){
        right--;
      }else{
        res += right - left;
        left++;
      }
    }
    return res;
  }
//anagram(long, short)
public List<Integer> substringAnagram(String l, String s){
  Map<Character, Integer> map = buildMap(s);
  List<Integer> res = new ArrayList<>();
  for(int i = 0; i < l.length(); i++){
    //right mnos chars
    char left = l.charAt(i);
    Integer count = map.get(left);
    if(count != null){
      map.put(left, count--);
      if(count == 1)
        match++;
    }

    //left most char
    if(i >= s.length()){
      char right = l.charAt(i - s.length());
      Integer count = map.get(right);
      if(count != null){
        map.put(map.get(right), count++);
        if(count == 0)
          match--;
      }

    }
    if(match == map.size()){
      res.add(i-s.length());
    }
  }
  return res;
}
//anagram(string[])
public List<String> allAnagramElement(Stirng[] arr){
  Map<String, List<String>> = new HashMap<>();
  for(int i =0; i < arr.length; i++){
    String s = String.valueOf(Arrays.sort(arr[i].toCharArray()));
    if(map.contians(s)){
      map.put(s, new ArrayList<Stirng>());
    }
    map.put(s, map.get(s).add(arr[i]));
  }
  List<String> res = new ArrahLsit<>();
  for(Entry<String, List<String> entry : map.entrySet()){
    if(entry.values.size() > 2){
      res.add(entry.getKey());
    }
  }
  return res;
}
//anagram(a, b)
public boolean 2strAnagram(String a, String b){

}
//duplciat1234
//move zero

//numebr of island
static class Element{
  int x;
  int y;
  public Element(int x, int y){
    this.x = x;
    this.y = y;
  }
}
public int islands(int[][] matrix){
  if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
    return -1;
  int row = matrix.length;
  int col = matrix[0].length;
  int res = 0;
  for(int i = 0; i < rowl i++){
    for(int j = 0; j < col;j++){
      if(matrix[j][j] == 1){
        res++;
        dfs(matrix, i, j);
      }
    }
    return res;
  }
  private void dfs(int[][] matrix, int row, int col){
    int[] dx = new int[]{0,1,-1,0};
    int[] dy = new int[]{-1,0,0,1};
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(new Element(row, col));
    //matrix[row][col] = 0;

    while(!queue.isEmpty()){
      int cur = queue.poll();
      matrix[cur.x][cur.y] = 0;
      for(int i = 0; i < 4; i++){
        Element next = new Element(cur.x + dx[i], cur.y + dy[i]);
        if(!validPosition(matrix, next)){
          continue;
        }
        if(matrix[next.x][next.y] == 1){
          matrix[next.x][next.y] = 1;
          queue.offer(next);
        }
      }
    }





    public int[] moveZero2(int[] arr){
    	if(arr.length <= 1)
    		return arr;
    	int slow = 0;  //not included in the non-zero subarr
    	int fast = 0;
    	for(fast = 0; fast < arr.length; fast++){
    		if(arr[fast] != 0)
    			arr[slow++] = arr[fast];
    	}
    	//fill in right part with 0
    	for(int i = slow; i < arr.length; i++){
    		arr[i] = 0;
    	}
    	return arr;
    }










  }
