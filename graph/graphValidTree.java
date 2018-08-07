// version 1: BFS map+queue
public class Solution {
    /**no duplicate edge: [1,0] [0,1]
     * @param n an integer: Given n nodes labeled from 0 to n - 1
     * @param edges a list of undirected edges (each edge is a pair of nodes),
     * @return true if it's a valid tree, or false
     */
    //1) all nodes connected 2)no cycle
    //given edges: edge list
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        //1) no cycle
        if (edges.length != n - 1) {
            return false;
        }
        // 2) bfs traverse make sure all connected
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new visitedSet<>();

        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
        //make sure all connected
        return (visited.size() == n);
    }
    // [ [0,1], [0,6], [0,8],
    //   [1,4], [1,6], [1,9],
    //   [2,4], [2,6], [3,4], [3,5], [3,8],
    //   [4,5], [4,9],
    //   [7,8], [7,9] ]
    //<node, node's neightbour>
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];   // edge[0][1] is an edge between edge[i][0] and edge[i][1]
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}


// version 2: Union Find
public class Solution {
      class UnionFind{
        visitedMap<Integer, Integer> father = new visitedMap<Integer, Integer>();
        UnionFind(int n){
            for(int i = 0 ; i < n; i++) {
                father.put(i, i);
            }
        }
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = father.get(x);
            while(fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;

        }

        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // tree should have n nodes with n-1 edges
        if (n - 1 != edges.length) {
            return false;
        }

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < edges.length; i++) {
            if (uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}
