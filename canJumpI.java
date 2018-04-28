//solution1: dp, arr[i] = from index 0 can jump to index i
public boolean canJump(int[] array){
	boolean[] arr = new boolean[array.length];
	arr[0] = true;
	for(int i = 1; i < array.length; i++){
		for(int j = 0; j < i; j++){
			//if j is reachable from 0, and from j it is possibel to jump to i
			if(arr[j] && array[j] + j >= i){
				arr[i] = true;
				break;
			}
		}
	}
	return arr[array.length-1];
}
//solution2: dp, arr[i] = from index i can jump to last element/target
public boolean canJump(int[] arr){
	//basecase
	if(arr.length == 1)
		return true;
	boolean[] arr = new boolean[arr.length];
	//induction rule
	for(int i = arr.length-2; i >= 0; i--){
		if(i + arr[i] >= arr.length-1)
			arr[i] = true;
		else{
			for(int j = arr[i]; j >= 1; j--){
				if(arr[j+i]){
					arr[i] = true;
					break;
				}
			}
		}
	}
	return arr[0];
}
//solution3: greedy
