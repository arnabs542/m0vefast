public String[] topKFrequent(String[] combo, int k) {
    if(combo == null || combo.length == 0){
      return new String[k];
    }
    String[] results = new String[k];
    Map<String,Integer> map = new HashMap<String,Integer>();
    PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(k,new Comparator<Map.Entry<String,Integer>>(){
     @Override
     public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
       return o1.getValue().compareTo(o2.getValue());
     }
    });
    //step1: iterate over and count the freq</em>
    for(String word : combo){
      if(!map.isEmpty()){
        map.put(word, map.get(word) + 1);
      }
      else{
        map.put(word, 1);
      }
    }
    //step2: sort by minHeap</em>
    for(Map.Entry<String, Integer> entry : map.entrySet()){
      if(minHeap.size() < k){
        minHeap.offer(entry);
      }else if(entry.getValue().compareTo(minHeap.peek().getValue()){</strong>
        minHeap.poll();
        minHeap.offer(entry);
      }
    }
    //get results</em>
    for(int i = k -1; i >= 0; i--){
     results[i] = minHeap.remove().getKey();
    }
    return results;
   }
