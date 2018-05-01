public int largest(Point[] points){
  //sort points by y and then by x
  Arrays.sort(points, new MyComparator());
  //similar to longest accesnding subsequence
  //longest[] and points[] are different concept
  //when long[i] > long[j] + 1   ==>> 2345067, long=1,2,3,4,1,5,6
  //when long[i] > long[j] + 1   ==>> 2345367, long=1,2,3,4,2,5,6
  int globalMax = 0;
  //# of qualified points (all positive slope) for each point
  int[] longest = new int[points.length];
  for(int i = 0; i < longest.length; i++){
    //dont put longest[i] = 1 here
    for(int j = 0; j < i; j++){
      if(points[j].x < points[i].x && points[j].y < points[i].y){
        longest[i] = Math.max(longest[i], longest[j]);
      }
    }
    //compare and +1
    longest[i]++;  //++once if input contains only one point, point itself
    globalMax = Math.max(longest[i], globalMax);
  }
  //if there does not even exist 2 points can form a line with positive slope, should return 0.
  //that is only one point in the given array
  return globalMax == 1 ? 0 : globalMax;
}
static class MyComparator implements Comparator<Point>{
  @Override
  public int compare(Point p1, Point p2){
    if(p1.y < p2.y)
      return -1;
    else if(p1.y > p2.y)
      return 1;
    else if(p1.x < p2.x)
      return -1;
    else if(p1.x > p2.x)
      return 1;
    return 0;
  }
}
