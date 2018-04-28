public List<Integer> majority(int[] arr, int k) {
  public List<Integer> majority(int[] arr) {
  Map<Integer, Integer> map = new HashMap<>();
for(int i = 0; i < arr.length; i++){
  if(map.get(arr[i]) != null){
    map.put(arr[i], map.get(arr[i])+1);
  }else{
    if(map.size() == 2){
      reduce(map);
    }else{
      map.put(arr[i], 1);
    }
  }
}
setZero(map);
return getResults(map, arr, 3);
}
private void reduce(Map<Integer, Integer> map){
for(Integer key : map.keySet()){
  map.put(key, map.get(key)-1);
}
Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
while(itr.hasNext()){
  Map.Entry<Integer, Integer> cur = itr.next();
  if(cur.getValue() == 0){
    itr.remove();
  }
}
}
private void setZero(Map<Integer, Integer> map){
for(Map.Entry<Integer, Integer> entry : map.entrySet()){
  entry.setValue(0);
}
}
private List<Integer> getResults(Map<Integer, Integer> map, int[] arr, int k){
List<Integer> res = new ArrayList<>();
for(int i = 0; i < arr.length; i++){
  if(map.get(arr[i]) != null)
    map.put(arr[i], map.get(arr[i]) + 1);
}
for(Map.Entry<Integer, Integer> entry : map.entrySet()){
  if(entry.getValue() > arr.length/k){
    res.add(entry.getKey());
  }
}
return res;
}
