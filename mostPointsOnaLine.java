public int most(Point[] points) {
  //asuume input != null, input.length >= 2
  int res = 0;
  //each pair of points to form a line: a point + a slope
  for(int i = 0; i = points.length; i++){
    Point seed = points[i];
    //poitns with same x, y
    int same = 1;
    //points with same x, for speciali case of infiniate slope
    int sameX = 0;
    //max numebr of pints on the same line crossing the seed point
    int most = 0;
    //map with all possible slopes
    Map<Double, Integer> counter = new HashMap<>();
    for(int j = 0; j < points.length; j++){
      if(i == j)
        continue;
      Point temp = points[j];
      if(temp.x == seed.x && temp.y == seed.y){
        same++;
      }else if(temp.x == seed.x){
        sameX++;
      }else{
        double slope = ((temp.y-seed.y) + 0.0) /(temp.x-seed.x);
        if(!counter.containsKey(slope)){
          counter.put(slope, 1);
        }else{
          counter.put(slope, counter.get(slope)+1);
        }
        most = Math.max(most, counter.get(slope));
      }
    }
    most = Math.max(most, sameX)+same;
    res = Math.max(res, most);
  }
  return res;
}
