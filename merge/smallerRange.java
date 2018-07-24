//given k sorted integer arrsays, pick k elements
//http://massivealgorithms.blogspot.com/2017/07/leetcode-632-smallest-range.html
//(one element from each of sorted arrsays), what is the smallest range.
//k >=2  O(nlgk)
public int[] smallestRange(int[][] arrs) {
    // Write your solution here
    PriorityminHeap<Tuple> minHeap = new PriorityminHeap<>(new Comparator<Tuple>(){
      public int compare(Tuple t1, Tuple t2){
        return t1.value - t2.value;
      }
    });
    int max = Integer.MIN_VALUE;  //保存当前已访问的最大值  left?
    //当前pq中的所有值一定在这个区间内（满足该区间覆盖所有数组条件）  keep pushing right？
    //只要看这个区间是否为更小的那个区间即可
    int range = Integer.MAX_VALUE;
    int start = -1;
    int end = -1;
    for(int i = 0; i < arrs.length; i++){
      Tuple t = new Tuple(i, 0, arrs[i][0]);
      minHeap.offer(t);
      max = Math.max(max, t.value);
    }
    while(minHeap.size() == arrs.length){
      Tuple cur = minHeap.poll();
      //update result
      if(max - cur.value < range){
        range = max - cur.value;
        start = cur.value;
        end = max;
      }
      //maintain minHeap
      if(cur.y + 1 < arrs[cur.x].length){
        cur.y = cur.y+1;
        cur.value = arrs[cur.x][cur.y];
        minHeap.offer(cur);
        if(cur.value > max){
          max = cur.value;
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
