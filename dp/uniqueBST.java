public int numTrees(int n) {
  //n+1 as given 1-n not zero-based index
  //i: given i nodes,
  //arr[i]: how many unique bst can be generated
  int[] arr = new int[n+1];
  arr[0] = 1;  //-(left)1(right)-2-3 there is nothing on the left, only one way
  arr[1] = 1;
  //for all possible n
  for(int i = 2; i <= n; i++){
    //given n, all possible root candidate
    for(int j = 1; j <= i; j++){
      arr[i] += arr[i-1] * arr[i-j];
    }
  }
  return arr[n];
}

//follow up: yahoo
https://leetcode.com/problems/unique-binary-search-trees-ii/description/
arr[i]: for n = i, how many unique bst are there
    n = 5; 1 2 3 4 5
    n = 4: 1 2 3 4
    n = 3: 1 2 3
    n = 2: 1 2
    n = 1: 1    //base case
    n = 0:

       n = 5 , root can be picked from 1 2 3 4 5
            take 3 as root
                3
         (12)       (45)
                3        3             3               3
              2     1                     4                 5
            1          2                    5            4
            take 1 as root
                1
                   2....   -> base case arr[0]
