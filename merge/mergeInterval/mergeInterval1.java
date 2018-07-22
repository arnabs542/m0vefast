给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。
// is interval overlap
public boolean canAttendMeetings(Interval[][] intervals) {
  if(intervals == null || intervals.length == 0)
    return true;
  Arrays.sort(intervals, new Comparator<Interval>(){
      public int compare(Interval i1, Interval i2){
          return i1.get(0) - i2.get(0);
      }
  });
  int end = intervals[0].get(1);
  for(int i = 1; i < intervals.length; i++){
      if(intervals[i].get(0) < end) {
          return false;
      }
      end = Math.max(end, intervals[i].end);
  }
  return true;
}


public boolean canAttendMeetings(int[][] intervals) {
   // Write your solution here
   if(intervals == null || intervals.length == 0)
   return true;
 Arrays.sort(intervals, new Comparator<int[]>(){
     public int compare(int[] i1, int[] i2){
         return i1[0]-i2[0];
     }
 });
 int end = intervals[0][1];
 for(int i = 1; i < intervals.length; i++){
     if(intervals[i][0] < end) {
         return false;
     }
     end = intervals[i][1];
 }
 return true;


 }
