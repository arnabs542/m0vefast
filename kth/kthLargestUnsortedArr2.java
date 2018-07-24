https://www.jiuzhang.com/solution/kth-largest-in-n-arrays/
public int KthLargestInArrays(int[][] arrays, int k) {
        // Write your code here
        PriorityQueue<Node> maxHeap =  new PrioritymaxHeap<Node>(k, new Comparator<Node>() {
                public int compare(Node o1, Node o2) {
                    if (o1.value > o2.value)
                        return -1;
                    else if (o1.value < o2.value)
                        return 1;
                    else
                        return 0;
                }
            });

        int n = arrays.length;
        int i;
        //1 ≤ k ≤ array's length.
        for (i = 0; i < n; ++i) {
            Arrays.sort(arrays[i]);
            //first add in n biggest one
            if (arrays[i].length > 0) {
                int x = i;
                int y = arrays[i].length - 1;
                int value = arrays[i][y];
                maxHeap.offer(new Node(value, x, y));
            }
        }

        for (i = 1; i <= k - 1; ++i) {
            Node temp = maxHeap.poll();
            if (temp.y > 0) {
                value = arrays[temp.x][temp.y-1];
                maxHeap.offer(new Node(value, temp.x, temp.y-1));
            }
        }
        return maxHeap.peek().value();
    }

static class Node{
  int value;
  int x;
  int y;
  public Node(int value, int x, int y){
    this.value = value;
    this.x = x;
    this.y = y;
  }
}
