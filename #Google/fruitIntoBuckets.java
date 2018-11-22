//http://massivealgorithms.blogspot.com/2018/11/leetcode-904-fruit-into-baskets.html
//longest subarr with at most 2 different elements
//sliding window of 2
//consider all valid subarrays that end at index j.
//There must be one with the smallest possible starting index i: lets say opt(j) = i.
public int totalFruit(int[] tree) {
  int slow = 0;
  int fast = 0;
  int n = tree.length;
  int maxLen = 0;
  //<fruite_type, index>
  Map<Integer, Integer> map = new HashMap<>();
  for(fast = 0; fast < n; fast++){
    map.put(tree[fast], fast);
    if(map.size() > 2){
      int minIndex = Collections.min(map.values());
      map.remove(tree[minIndex]);
      left = minIndex+1;
    }
    maxLen = Math.max(maxLen, fast - slow + 1);
  }
  return maxLen;
}
