https://www.jiuzhang.com/solution/kth-smallest-sum-in-two-sorted-arrays/
public int kthSmallestSum(int[] A, int[] B, int k) {
    // Write your solution here
    return 0;
  }

  class Pair {
      public int x, y, sum;
      public Pair(int x, int y, int sum) {
          this.x = x;
          this.y = y;
          this.sum = sum;
      }
  }
  class PairComparator implements Comparator<Pair> {
      public int compare(Pair a, Pair b) {
          return a.sum - b.sum;
      }
  }

  public class Solution {
      public int kthSmallestSum(int[] A, int[] B, int k) {
          int[] dx = new int[]{0, 1};
          int[] dy = new int[]{1, 0};
          boolean[][] visited = new boolean[A.length][B.length];
          PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
          minHeap.add(new Pair(0, 0, A[0] + B[0]));
          visited[0][0] = true;
          //while(k > 1){...k--}
          for(int i = 0; i < k - 1; i++){
              Pair cur = minHeap.poll();
              //2 directions to attempt based on the current coordiante
              for(int j = 0; j < 2; j++){
                  int next_x = cur.x + dx[j];
                  int next_y = cur.y + dy[j];
                  Pair next_Pair = new Pair(next_x, next_y, 0);
                  if(next_x < A.length && next_y < B.length && !visited[next_x][next_y]){
                      hash[next_x][next_y] = true;
                      next_Pair.sum = A[next_x] + B[next_y];
                      minHeap.add(next_Pair);
                  }
              }
          }
          return minHeap.peek().sum;
      }
  }
