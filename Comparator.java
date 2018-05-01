public int largest(Point[] points){
  Arrays.sort(points, new MyComparator());
  //....
}
static class MyComparator implements Comparator<Element>{
  @Override
  public int compare(Element p1, Element p2){
    //conditions
    return 0, -1, 1;
  }
}

public int largest(Point[] points){
  PriorityQueue<Element> minHeap = new PriorityQueue<>(11, new Comparator<Element>(){
    @Override
    public int compare(Element p1, Element p2){
      //conditions
      return 0, -1, 1;
    }
  });
}
