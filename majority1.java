//solution1: O(n), O(n) using hashmap
public int majority(int[] array) {
    // Write your solution here.
    return 0;
}
//solution2: O(n), O(1) using k-1 counter

// map<candidate, counter>
// case1: counter==0,counter++, update candidate
// case2.1: if cur == candidate, counter++
// case2.2: if not, counter--

public int majority(int[] arr) {
  int candidate = arr[0];
  int counter = 1;
  for(int i = 1; i < arr.length; i++){
    if(counter == 0){
      counter++;
      candidate = arr[i];
    }else if(candidate == arr[i]){
      counter++;
    }else{
      counter--;
    }
  }
  return candidate;
}
