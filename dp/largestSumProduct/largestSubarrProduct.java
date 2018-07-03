//Given an unsorted array of doubles, find the subarray that has the greatest product. Return the product.
//non-dp solution
arr: 2, -0.1,  4,    -2,   -1.5
pos: 2,  0,    4,    1.6,  12
neg: 0, -0.2, -0.8,  -8,   -8
public double largestSubarrProduct(double[] array) {
  if (array.length == 1)
    return array[0];
    //current product status can be either pos or neg
    // record the max & min product up to the i-th element (not necessarily inclusive)
    // maxProd is positive number or 1, minProd is negative number or 1
  double pos = Math.max(array[0], 0);
  double neg = Math.min(array[0], 0);
  double globalMax = array[0];
  for (int i = 1; i < array.length; i++) {
    if (array[i] > 0) {
      pos = Math.max(pos * array[i], array[i]);
      neg = neg * array[i];
    } else if (array[i] < 0) {
      neg = Math.min(pos * array[i], array[i]);
      pos = neg * array[i];
    } else {
      pos = 0;
      neg = 0;
    }
    globalMax = Math.max(globalMax, pos);
  }
  return globalMax;
}
//dp solution
public double largestProduct(double[] array) {
    // write your solution here
    // record the max & min product up to the i-th element (not necessarily inclusive)
    // maxProd is positive number or 1, minProd is negative number or 1
    double[] maxProd = new double[array.length + 1];
    double[] minProd = new double[array.length + 1];
    maxProd[0] = 1;
    minProd[0] = 1;
    double globalMax = array[0];
    for(int i = 0; i < array.length; i++) {
      if(array[i] > 0) {
        maxProd[i + 1] = Math.max(maxProd[i], 1) * array[i];
        minProd[i + 1] = minProd[i] < 0 ? minProd[i] * array[i] : 1;
        globalMax = Math.max(globalMax, maxProd[i + 1]);
      } else if (array[i] < 0) {
        maxProd[i + 1] = Math.max(minProd[i] * array[i], 1);
        minProd[i + 1] = Math.min(maxProd[i] * array[i], array[i]);
        globalMax = Math.max(globalMax, minProd[i] * array[i]);
      } else { //array[i] = 0
         maxProd[i + 1] = 1;
         minProd[i + 1] = 1;
         globalMax = Math.max(globalMax, 0.0);
      }
    }
    return globalMax;
  }

//longest subarr sum
  //basecase: dp[0] = arr[0];
  //induction: dp[i] = max(dp[i-1]+arr[i], arr[i])
  //                 = dp[i-1]+arr[i]   when dp[i-1] >= 0
  //				   = arr[i]           ow

  public int largestSum(int[] arr){
  	int glbalMax = arr[0];
  	int cur = arr[0];  //largest subarr including arr[i]
  	for(int i = 1; i < arr.length; i++){
  		cur = Math.max(cur + arr[i], arr[i]);
  		globalMax = Math.max(globalMax, cur);
  	}
  	return globalMax;
  }
