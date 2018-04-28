public int largest(Point[] points){
  //sort points by y and then by x
  Arrays.sort(points, new MyComparator());
  int res = 0;
  int[] longest = new int[points.length];
  for(int i = 0; i < longest.lenth; i++){
    for(int j = 0; j < i; j++){
      if(points[j].x < points[i].x && points[j].y < points[i].y){
        longest[i] = Math.max(longest[i], longest[j]);
      }
    }
    longest[i]++;
    res = Math.max(longest[i], longest[j]);
  }
  return res == 1 ? 0 : res;
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
