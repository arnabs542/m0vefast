Boolean has potential to compress space

TAKE THE HINTS!
要写comment
Delete all the dead code
Cirlular linkedlist and circular array implementation
//actual O(n) = 3*(n-1)
for(int I = 0; (true); I++){

if(i == arr.length-1){
      i = -1;
    }

}





ListNode{
  int value;
  ListNode next;
  public ListNode(int value){
    this.value = value;
  }
}

public int 3->1game(int n){
  int counter = 0;
  int size = n;
  while(true){

    if(counter == 3)
      //delete the node
      size--;
      if(size == 1)
        break;




  }
  return head.value;
}
//circular list, how to analysis the time complexity
0,1,2,3,4,5,6  3
0,1,3,4,5,6    3
0,1,3,4,6      3
0,3,4,6        3
0,3,4          3
0,3            3
3

public int game(int n){
  if(n <= 1)
    return 0;
  boolean[] arr = new boolean[n];
  for(boolean each: arr){
    each = true;
  }
  int counter = 0;
  int trueTrack = n;
  i = 0;
  //while(true){}
  //while(trueTrack >=1){
// how to better use the break condition!!!
//COMMENT: return one true winner
  for(int i = 0; trueTrack > 1 ; i++){
    //if (i==arr.length)
    //{
    //  i=0;
    //}
    if(arr[i]){
      counter++;
      if(counter == 3){
        arr[i] = false;
        counter = 0;
        trueTrack--;
        //find winer

        if(trueTrack == 1){
          break;
          //
        //   for(int j = 0; j < arr.length; j++){
        //     if(arr[j]){
        //       return j;
        //     }
        //   }
        }

      }

    }
    //i++;
    if(i == arr.length-1){
      i = -1;
    }

  }
   return findWinner(arr);


  //for(int i = 0; i < arr.length; i++){

  }
//user helper function
  private int findWinner(boolean[] arr){
    int res;
    for(int j = 0; j < arr.length; j++){
            if(arr[j]){
              res = j;
              break;
              //return j;
            }
          }
    return res;

  }



}
