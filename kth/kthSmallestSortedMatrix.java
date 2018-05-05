//n*n matrix
public class Solution{
	//poll() 1th...k-1th smallest, then kth smallest is the res
	public int kthSmallest(int[][] matrix, int k){
		int n = matrix.length < k ? matrix.length : k;
		PriorityQueue<Tuple> minHeap = new PriorityQueue<>(n, new Comparator<Tuple>(){
			@Override
			public int compare(Tuple t1, Tuple t2){
				if(t1.val == t2.val)
					return 0;
				return t1.val < t2.val ? -1 : 1;
			}
		});
		for(int i = 0; i < n; i++)
			minHeap.offer(new Tuple(0, i, matrix[0][i]));
		for(int j = 0; j < k-1; j++){
			Tuple t = minHeap.poll();
			//since .x is zero-based while n minHeap size is 1-based
			if(t.x == n-1)
				continue;
			minHeap.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
		}
		return minHeap.poll().val;
	}
}
class Tuple{
	int x;
	int y;
	int val;
	public Tuple(int x, int y, int val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
}
//n*m matrix
public class Solution{
	//poll() 1th...k-1th smallest, then kth smallest is the res
	public int kthSmallest(int[][] matrix, int k){
		int rows= matrix.length;
		int cols = matrix[0].length;
		PriorityQueue<Tuple> minHeap = new PriorityQueue<>(k, new Comparator<Tuple>(){
			@Override
			public int compare(Tuple t1, Tuple t2){
				if(t1.val == t2.val)
					return 0;
				return t1.val < t2.val ? -1 : 1;
			}
		});
		//to avoid being generated more than once
		boolean[][] visited = new boolean[rows][cols];
		minHeap.offer(new Tuple(0, 0, matrix[0][0]));
		visited[0][0] = true;
		//iterate k-1 rounds,
		for(int j = 0; j < k-1; j++){
			Tuple t = minHeap.poll();
			if(t.x + 1 < rows && !visited[t.x+1][t.y]){
				minHeap.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
				visited[t.x+1][t.y] = true;
			}
			if(t.y + 1 < cols && !visited[t.x][t.y+1]){
				minHeap.offer(new Tuple(t.x, t.y+1, matrix[t.x][t.y+1]));
				visited[t.x][t.y+1] = true;
			}
		}
		return minHeap.peek().val;
	}
}
class Tuple{
	int x;
	int y;
	int val;
	public Tuple(int x, int y, int val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
}
