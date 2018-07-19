//duplicate, index_pairs
public List<List<Integer>> 2SumPairs(int[] array, int target){
	List<List<Integer>> res = new ArrayList<>();
	//map(arrayi], value: i, j, k.....
	Map<Integer, List<Integer>> map = new HashMap<>();
	for(int i = 0; i < array.length; i++){
		List<Integer> indexs = map.get(target - array[i]);
		if(indexs != null){
			for(int j : indexs)
				//i is the larger index
				res.add(Arrays.asList(j, i));
		}
		//add cur index i to all the possible indexs for value of arr[i]
		if(!map.containsKey(array[i])){
			map.put(array[i], new ArrayList<Integer>());
		}
		map.get(array[i]).add(i);
	}
	return res;
}
