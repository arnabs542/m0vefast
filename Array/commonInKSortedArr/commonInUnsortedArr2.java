//return in accesding order
//exist duplicate in any of the arr
public List<Integer> common(List<Integer> a, List<Integer> b) {
    // write your solution here
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
        if(set.get(each) > 1){
          set.put(each, set.get(each)-1);
        }else{
          set.remove(each);
        }
      }
    }
    Collections.sort(res);
    return res;
}
