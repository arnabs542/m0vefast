public int[] intersect(int[] arr1, int[] arr2) {
    // Write your solution here
    Map<Integer, Integer> map = new HashMap<>();
    for(int i : arr1){
      if(map.containsKey(i))
        map.put(i, map.get(i)+1);
      else
      map.put(i, 1);
    }
    List<Integer> list = new ArrayList<>();
    for(int i : arr2){
      if(map.containsKey(i)){
        if(map.get(i) > 1)
          map.put(i, map.get(i)-1);
        else
          map.remove(i);
        res.add(i);
      }
    }
    int[] res = new int[list.size()];
    int index = 0;
    res[index++] = list.get(index);
    return res;
}
