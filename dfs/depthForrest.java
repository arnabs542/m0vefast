// https://piazza.com/class/j0eqhhdregb3i?cid=2698
//检测环的方法有问题，我设了set但是只能用于检测dfs里面有环的情况，对于没有进到dfs function的元素，
// 我是通过看set有没有加过这个元素来判断环
//你的环最后是剩出来的，因为环里没有任何一个node的parent是-1，所以不会被搜索到。
public int depth(int[] forest) {
		int depth = 0;
		//<forest[i], i>
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < forest.length; i++) {
			List<Integer> list = map.get(forest[i]);
			if (list == null) {
				list = new ArrayList<Integer>();
			}
			list.add(i);
			map.put(forest[i], list);
		}

		//record if an element in the array has been visited or not
		Set<Integer> visited = new HashSet<Integer>();

		for (int i = 0; i < forest.length; i++) {
			if (forest[i] == -1) {
				int[] deep = new int[1];
				visited.add(i);
				if (dfs(forest, map, i, 1, deep, visited)) {
					depth = Math.max(depth, deep[0]);
				} else {
					return -1;
				}
			}
		}

		for (int i = 0; i < forest.length; i++) {
			if (!visited.contains(i)) {
				return -1;
			}
		}

		return depth;
	}

	private boolean dfs(int[] forest, HashMap<Integer, List<Integer>> map, int index, int level, int[] deep, Set<Integer> visited) {
		//base case: if there is no index value in the forest
		if (!map.containsKey(index)) {
			deep[0] = Math.max(deep[0], level);
			return true;
		}

		List<Integer> list = map.get(index);
		if (list != null) {
			for (Integer cur : list) {
				if (visited.add(cur)) {
					dfs(forest, map, cur, level + 1, deep, visited);
				} else {
					return false;
				}
			}
		}
		return true;
	}
