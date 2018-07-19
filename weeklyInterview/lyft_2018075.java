class Interval{
  int start;
  int end;
}
//given list is 1) sorted 2) disjoint
public list<Interval> mergeIntervals(List<Interval> list, Interval toAdd){
  List<Inteval> res = new ArrayList<>();
  if(list == null || list.size() == 0 || toAdd == null)
    return res;
  boolean toAddIn;
  for(int i = 0; i < list.size(); i++){
    Interval cur = list.get(i);
    if(toAdd.start > cur.end){
      if(!toAddIn){
        res.add(toAdd);
        toAddIn = true;
      }
      res.add(cur);
      break;
    }else if(toAdd.end < cur.start){
      res.add(cur);
    }else{
      a.start = Math.min(a.start, cur.start);
      a.end = Math.max(a.end, cur.end);
      if(i == list.size() -1){
        res.add(toAdd);
      }
    }
  }
  return res;
}

algorithm to maximise trading profit on a series of prices
Phone Screen: Question related to a queue
Onsite: Question involving a trie data structure
