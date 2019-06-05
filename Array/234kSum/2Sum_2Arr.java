public boolean existSum(int[] a, int[] b, int target) {
    // Write your solution here
    Set<Integer> set = new HashSet<>();
    for(Integer each : a){
      set.add(each);
    }
    for(Integer each : b){
      if(set.contains(target - each))
        return true;
    }
    return false;
}
