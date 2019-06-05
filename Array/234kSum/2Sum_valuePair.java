//distinct value_pairs
//A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
//solution1: sort + 2 pointers
//
public List<List<Integer>> 2SumPairs(int[] arr, int target){
	Arrays.sort(arr);
	List<List<Integer>> res = new ArrayList<>();
	int left = 0;
	int right = arr.length -1;
	while(left < right){
		//ignore consecutive duplicate values when determine the
		//smaller element of the pair
		if(left > 0 && arr[left] == arr[left - 1]){
			left++;
			continue;
		}
		int cur = arr[left] + arr[right];
		if(cur == target){
			res.add(Arrays.asList(arr[left], arr[right]));
			left++;
			right--;
		}else if(cur < target){
			left++;
		}else{
			right--;
		}
	}
	return res;
}
//solution2: hashset
//
public List<List<Integer>> 2SumPairs(int[] arr, int target){

}

public int[] 2Sum(int[] numbers, int target){
	HashMap<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < numbers.length; i++){
		if(map.get(numbers[i]) != null){
			int[] res = {map.get(numbers[i]) + 1, i+1}
			return res;
		}
		//map(minused_value, minused_index)
		map.put(target - numbers[i], i);
	}
	//when solution not exists
	int[] result = {}; //int[] result = new int[0];
	return result;
}
