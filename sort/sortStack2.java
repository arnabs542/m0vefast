//assusming s1 is not null
//from top to bottom sorted in acsding order
public void sortArray3Stacks(LinkedList<Integer> s1){
	LinkedList<Integer> s2 = new LinkedList<>();  //BUFFER
	LinkedList<Integer> s3 = new LinkedList<>();  //RESULT 
	sort(s1, s2, s3, s1.size());
}
//mergeSort 的思想
private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length){
	if(length <= 1)
		return;
	int mid1 = length/2;
	int mid2 = length - length/2;
	for(int i = 0; i < mid1; i++)
		s2.offerFirst(s1.pollFirst());
	//use the other stacks to sort s2/s1
	//after soring s2/s1 are in accending order from top to bottomw in 2 stacks
	//merge sort s1 and s2, s3 as temp
	sort(s2, s3, s1, mid1);
	sort(s1, s3, s2, mid2);
	int i = 0;
	int j = 0;
	//mergeSort->merge
	while(i<mid1 && j < mid2){
		if(s2.peekFirst() < s1.peekFirst()){
			s3.offerFirst(s2.pollFirst());
			i++;
		}else{
			s3.offerFirst(s1.pollFirst());
			j++;
		}
	}
	while(i < mid1){
		s3.offerFirst(s2.pollFirst());
		i++;
	}
	while(j < mid1){
		s3.offerFirst(s1.pollFirst());
		j++;
	}
	//after merging, nums are in decending order from top to bottome in s3
	//need to push them back to s1 so they are in accending order
	for(int index = 0; index < length; index++){
		s1.offerFirst(s3.pollFirst());
	}
}
