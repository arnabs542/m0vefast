//Number of Connected Components in Undirected Graph
https://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/
https://www.jiuzhang.com/solution/number-of-connected-components-in-an-undirected-graph/
Union-Find Algorithm can be used to check whether an undirected graph contains cycle or not.
undirected graph with self loop:https://www.geeksforgeeks.org/?p=18516
undirected graph with no self loop: https://www.geeksforgeeks.org/union-find/
Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.
Union: Join two subsets into a single subset.

private int[] father = new int[n];
private int set;

public int countComponents(int n, int[][] edges) {
    // Write your solution here
    set = n;
    for(int i = 0; i < n; i++){
      father[i] = i;  //initial father as number itself
    }
    for(int[] each : edges){
      union(each[0], each[1]);
    }
    return set;
  }
private void union(int[] father, int a, int b){
  int root_a = find(father, a);
  int root_b = find(father, b);
  if(root_a != root_b){
    father[root_b] = root_a;
    set--;
  }
}
private int find(int[] father, int x){
  if(x == father[x])
    return x;
  return find(father, father[x]);
}
