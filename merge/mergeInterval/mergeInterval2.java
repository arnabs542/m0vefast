给定一系列的会议时间间隔intervals，包括起始和结束时间[[s1,e1],[s2,e2],...] (si < ei)，找到所需的最小的会议室数量。
//count overlap
//We can use a priority query to record the end time, so we can get the minimum end time in O(logN) time.
public int minMeetingRooms(Interval[] intervals) {
    if(intervals==null||intervals.length==0)
        return 0;
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            return i1.start-i2.start;
        }
    });
    //most avaiable rooem: earleast ending time
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int count=1;
    queue.offer(intervals[0].end);

    for(int i=1; i<intervals.length; i++){
        if(intervals[i].start<queue.peek()){
            count++;
        }else{
            queue.poll();
        }
        queue.offer(intervals[i].end);
    }
    return count;
}

static class myComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] i1, int[] i2){
      return i1[0] - i2[0];
    }
  }
