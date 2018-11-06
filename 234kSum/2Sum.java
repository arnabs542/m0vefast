//solution1: sort + 2 pointers
//O(nlgn) if unsorted, O(n) sorted; O(1)
public boolean 2Sum(int[] arr, int target){
	Arrays.sort(arr);  //O(nlgn)
	int left = 0;
	int right = arr.length -1;
	while(left < right){
		int sum = arr[left] + arr[right];
		if(sum == target)
			return true;
		else if(sum < target)
			left++;
		else
			right--;
	}
	return false;
}

//solution2: good for unsorted
//O(n) O(n)
public boolean 2Sum(int[] arr, int target){
	Set<Integer> set = new HashSet<>();
	for(int sum : arr){
		if(set.contains(target-sum))
			return true;
		set.add(num);
	}
	return false;
}
//no duplicate, return index, can reuse element, no sorted O(n) O(n)
public int[] twoSum(int[] arr, int target) {
        int[] res = new int[2];
        if(arr == null || arr.length == 0)
            return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(target - arr[i])){
                res[0] = map.get(target-arr[i]);
                res[1] = i;
                return res;
            }else{
                map.put(arr[i], i);
            }
        }
        return res;
    }
