// map<candidate, counter>
// step1: if check if cur is key
  // case1: if cur is key, counter++
  // case2.1: if map.size == k-1, all counter--; remove counter== 0
  // case2.2: if map.size < k-1, add cur as key
// step2: iterate list to select results

// time complexity: O(nk)-> n
// space complexity: O(k)

public List<Integer> majority(int[] array, int k) {
    //assumption: number, k >=2, array is not null or empty
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < array.length; i++){
				if(map.get(array[i]) != null){ //case 1
        	map.put(array[i], map.get(array[i])+1);
        }else{   //case 2
        	if(map.size() == k-1)  //case 2.1
            reduce(map);
          else    //case 2.2
            map.put(array[i], 1);
        }

    }
    //since the real occurance has been reduced a couple times
    setZero(map);  //case 2.1
    return getResults(map, array, k);
}
private void reduce(Map<Integer, Integer> map) {
    for(Integer key : map.keySet()) {           //map.keySet()
        Integer freq = map.get(key);
        map.put(key, freq - 1);
    }
    Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();    //Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator()
    while(iter.hasNext()) {
        Map.Entry<Integer, Integer> cur = iter.next();
        if(cur.getValue() == 0) {     //entry.getValue()
            iter.remove();            //itr.remove()
        }
    }
}
private void setZero(Map<Integer, Integer> map) {
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {   //map.entrySet()
        entry.setValue(0);    //setValue(value)
    }
}
private List<Integer> getResults(Map<Integer, Integer> map, int[] array, int k) {
    for(int i = 0; i < array.length; i++) {
        Integer freq = map.get(array[i]);
        if(freq != null) {
            map.put(array[i], freq + 1);
        }
    }
    List<Integer> result = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if(entry.getValue() * k > array.length) {
            result.add(entry.getKey());
        }
    }
    return result;
}
