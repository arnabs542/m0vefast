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


//================randomly pick 100 from flow 
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
    if(prob < 100)
    	sample = value;
  }
  //return the sample of whatever read before
  public Integer sample() {
    // Write your implementation here.
    return sample;
  }
}
