//solution1: O(n^3)
//assuming arr.length >=4
public boolean exist(int[] arr, int target){
	Arrays.sort(arr);
	for(int i = 0; i < arr.length - 3; i++){
		for(int j = i+1; j < arr.length-2; j++){
			int left = j+1;
			int right = arr.length-1;
			int curTarget = target - arr[i] - arr[j];
			//notice! dont go ouside left and right bound
			while(left < right){
				int sum = arr[left] + arr[right];
				if(sum == curTarget)
					return true;
				else if(sum < curTarget)
					left++;
				else
					right--;
			}
		}
	}
	return false;
}

//solution2: O(n^2*lgn), get all paris of numebrs and apply 2 sum
