//given k sorted integer arrays, pick k elements
//(one element from each of sorted arrays), what is the smallest range.
//k >=2
public int[] smallestRange(int[][] arr) {
    // Write your solution here
    PriorityQueue<Tuple> queue = new PriorityQueue<>(new Comparator<Tuple>(){
      public int compare(Tuple t1, Tuple t2){
        return t1.value - t2.value;
      }
    });
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length; i++){
      Tuple cur = new Tuple(i, 0, arr[i][0]);
      queue.offer(cur);
      max = Math.max(max, cur.value);
    }
    int range = Integer.MAX_VALUE;
    int start = -1;
    int end = -1;
    while(queue.size() == arr.length){
      Tuple t = queue.poll();
      if(max - t.value < range){
        range = max - t.value;
        start = t.value;
        end = max;
      }
      if(t.y + 1 < arr[t.x].length){
        t.y = t.y+1;
        t.value = arr[t.x][t.y];
        queue.offer(t);
        if(t.value > max){
          max = t.value;
        }
      }
    }
    return new int[]{start, end};
  }
static class Tuple{
  int x;
  int y;
  int value;
  public Tuple(int x, int y, int value){
    this.x = x;
    this.y = y;
    this.value = value;
  }
