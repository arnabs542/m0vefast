public class Solution {
  private LinkedList<Integer> in;   //when out is empty, in->out
  private LinkedList<Integer> out;  //main

  public Solution() {
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }

  public Integer poll() {
    move();
    return out.isEmpty()? null : out.pollFirst();
  }

  public void offer(int element) {
    in.offerFirst(element);
  }

  public Integer peek() {
    move();
    return out.isEmpty()? null : out.peekFirst();
  }

  public int size() {
    return in.size() + out.size();
  }

  public boolean isEmpty() {
    return in.size() == 0 && out.size() == 0;
  }

 	private void move(){
  	if(out.isEmpty()){
      while(!in.isEmpty()){
      	out.offerFirst(in.pollFirst());
      }
    }
  }
}
