//with duplicate
//solution1: O(nlgn)
public List<List<Integer>> allTriples(int[] arr, int target) {
	//assume length >= 3
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	Arrays.sort(arr);
	for(int i = 0; i < arr.length-2; i++){
		//to find index i,j,k such that arr[i]+arr[j]+arr[k] = target
		//chooosing i: ingnore all duplicate possible i
		//eg: if we have 222, only the last 2 will be selected as i
		if(i > 0 && arr[i] == arr[i-1])
			continue;
		int left = i + 1;   //choosing j, left from index = 1, 2nd element
		int right = arr.length - 1;  //choosing k, right from the last index
		//notice! dont go ouside left and right bound
		while(left < right){
			int temp = arr[left] + arr[right];
			if(temp + arr[i] == target){
				res.add(Arrays.asList(arr[i], arr[left], arr[right]));
				left++;
				//right--;
				//choosing j: ignore all posssible duplicate j as well
				while(left < right && arr[left] == arr[left-1])
					left++;
			}else if(temp + arr[i] < target){
				left++;
			}else
				right--;
			}
		}
		return res;
}
