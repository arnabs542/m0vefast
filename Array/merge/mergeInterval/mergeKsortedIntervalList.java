class Pair {
    int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        int k = intervals.size();
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair e1, Pair e2) {
                return intervals.get(e1.row).get(e1.col).start - intervals.get(e2.row).get(e2.col).start;
            }
          }
        );

        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).size() > 0) {
                queue.add(new Pair(i, 0));
            }
        }

        List<Interval> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            result.add(intervals.get(pair.row).get(pair.col));
            pair.col++;
            if (pair.col < intervals.get(pair.row).size()) {
                queue.add(pair);
            }
        }
        return merge(result);
    }
    private List<Interval> merge(List<Integerval> intervals){
      if (intervals.size() <= 1) {
          return intervals;
      }
      List<Interval> res = new ArrayList<>();
      Interval toAdd = intervals.get(0);
      for(int i = 1; i < intervals.size(); i++){
        Interval cur = interval.get(i);
        if(toAdd.end < cur.start){
          res.add(toAdd);
          toAdd = cur;
        }else{
          toAdd.end = Math.max(toAdd.end, cur.end);
        }
      }
      res.add(toAdd);
      return res;
    }
}
