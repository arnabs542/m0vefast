//return in accesding order
//no duplicate in both arr
public List<Integer> common(List<Integer> a, List<Integer> b) {
  List<Integer> res = new ArrayList<Integer>();
  HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
  for(Integer each : a){
    if(!set.containsKey(each)){
      set.put(each, 1);
    }else{
      set.put(each, set.get(each)+1);
    }
  }
  for(Integer each : b){
    if(set.containsKey(each)){
      res.add(each);
    }
  }
  Collections.sort(res);
  return res;
  }
