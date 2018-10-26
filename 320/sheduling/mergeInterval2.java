给定一系列的会议时间间隔intervals，包括起始和结束时间[[s1,e1],[s2,e2],...] (si < ei)，找到所需的最小的会议室数量。
//count overlap
public int minMeetingRooms(Interval[] intervals) {
    if(intervals==null||intervals.length==0)
        return 0;
    //Arrays.sort(intervals, (i1,i2)->i1.start-i2.start);
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            return i1.start-i2.start;
        }
    });
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int count=1;
    queue.offer(intervals[0].end);

    for(int i=1; i<intervals.length; i++){
        if(intervals[i].start<queue.peek()){  //why  <= is not working 
            count++;
        }else{
            queue.poll();
        }
        queue.offer(intervals[i].end);
    }
    return count;
}
