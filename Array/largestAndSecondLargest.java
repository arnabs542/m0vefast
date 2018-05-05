public class Solution{
	static class Element{
    	int value;
    	List<Integer> compareValues;
    	Element(int value){
    		this.value = value;
    		this.compareValues = new ArrayList<>();
   	 	}
	}
	public int[] largestAndSecond(int[] arr) {
    // Write your solution here.
    // The first element is the largest number,
    // the second element is the second largest number.
	  //1) construct strcture
    	Element[] helper = convert(arr);
		//2) compare and swap
    	int larger_length = arr.length;
    	while(larger_length > 1){
    		compareAndSwap(helper, larger_length);
				//since compare one time, so tobedetection length is reduced
    		larger_length = (larger_length + 1)/2;
    		//keep modifying the left larger partition,
    		//so the largest one will be on the leftmost index
    	}
		return new int[]{helper[0].value,
					largest(helper[0].compareValues)};
	}

	private Element[] convert(int[] arr){
		Element[] helper = new Element[arr.length];
		for(int i = 0; i < arr.length; i++){
			helper[i] = new Element(arr[i]);  //construct Element!!!!
		}
		return helper;
	}
	private void compareAndSwap(Element[] helper, int larger_length){
		for(int i = 0; i < larger_length/2; i++){
			if(helper[i].value < helper[larger_length - 1 - i].value)
				swap(helper, i, larger_length-1-i);
			helper[i].compareValues.add(helper[larger_length - 1 - i].value);
		}
	}
	private void swap(Element[] helper, int left, int right){
		Element temp = helper[left];
		helper[left] = helper[right];
		helper[right] = temp;
	}
	//O(1)
	private int largest(List<Integer> list){
		int max = list.get(0);
		for(int each : list){
			max = Math.max(max, each);
		}
		return max;
	}
}
