public int randomLargestIndex(int[] arr){
	//assume not null and lenght != 0
	int cur_max = arr[0];
	int cur_max_count = 1;
	int cur_max_sample_index = 0;
	//int cur_sample_object;
	for(int i = 0; i < arr.length; i++){
		if(arr[i] < cur.max)
			continue;
		if(arr[i] == cur_max){
			cur_max_count++;
			cur_max_sample_index = reservoirSampling();  //Math.random(cur_max_count);
		}
		if(arr[i] > cur_max){
			cur_max = arr[i];
			cur_max_count = 1;
			cur_max_sample_index = i;
		}
	}
	return cur_max_sample_index;
}

//================randomly pick 1 from flow 
//the class will be used as a reader 
public class Solution {
  public ReservoirSampling() {
    // Write your constructor code here if necessary.
    private int count;
    private Integer sample;
    public ReservoirSampling(){
    	this.count = 0; //nothing has been read so far
    	this.sample = null;
    }
  }
  //read each of the element 
  public void read(int value) {
    // Write your implementation here.
    count++;
    int prob = (int)(Math.random()*count);
    //cur read value has the prob of 1/count to be as the cur sample
    if(prob == 0)
    	sample = value;
  }
  //return the sample of whatever read before
  public Integer sample() {
    // Write your implementation here.
    return sample;
  }
}