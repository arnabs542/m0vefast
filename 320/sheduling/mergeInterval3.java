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
    if(toAdd.end < cur.start){
      if(!toAddIn){
        res.add(toAdd);
        toAddIn = true;
      }
      res.add(cur);
      //copyRest(list, res, i);
      //break;
    }else if(toAdd.start > cur.end){
      res.add(cur);
    }else{
      toAdd.start = Math.min(toAdd.start, cur.start);
      toAdd.end = Math.max(toAdd.end, cur.end);
      if(i == list.size() -1){
        res.add(toAdd);
      }
    }
  }
  return res;
}
https://www.jiuzhang.com/solution/merge-intervals/ merge the overlap intervals
public List<Interval> merge(List<Interval> intervals) {
       if (intervals == null || intervals.size() <= 1) {
           return intervals;
       }
       Collections.sort(intervals, (i1, i2)->i1.start - i2.start);
       //Collections.sort(intervals, new IntervalComparator());
       List<Interval> result = new ArrayList<>();
       //toAdd 来记录最后一个还没有被放到 merge results 里的 Interval，用于和新加入的 interval 比较看看能不能合并到一起。
       Interval toAdd = intervals.get(0);
       for (int i = 1; i < intervals.size(); i++) {
           Interval curt = intervals.get(i);
           if (toAdd.end < curt.start){
             result.add(toAdd);
             toAdd = curt;
           }else{
               toAdd.end = Math.max(toAdd.end, curt.end);
           }
       }
       result.add(toAdd);
       return result;
   }

   private class IntervalComparator implements Comparator<Interval> {
       public int compare(Interval a, Interval b) {
           return a.start - b.start;
       }
   }

}


// version: 高频题班
class Solution {
   /**
    * @param intervals, a collection of intervals
    * @return: A new sorted interval list.
    */
   public List<Interval> merge(List<Interval> intervals) {
       // write your code here
       List<Interval> ans = new ArrayList<>();

       intervals.sort(Comparator.comparing(i -> i.start));  //lambda 匿名函数：输入i  返回i.start

       Interval last = null;
       for (Interval item : intervals) {
           if (last == null || last.end < item.start) {
               ans.add(item);
               last = item;
           } else {
               last.end = Math.max(last.end, item.end); // Modify the element already in list
           }
       }
       return ans;
   }
