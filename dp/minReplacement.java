//all a to the left of b
//"abaab", the minimum number of replacements needed is 1
//(replace the first 'b' with 'a' so that the string becomes "aaaab").
// 00111
// 22100
// 22211
//应该用DP吧，我们想找到最后a和b的分界线应该在哪里，
//所以统计下每个位置左边的b数量，还有每个位置右边的a数量。
//最后找到左边b+右边a数量最小的位置。这个数量就是最小的replacement个数
//维护两个counter，一个是此时此刻为全a的最小replacement。一个是维护此时此刻当前位置为b的最小replacement。
public int minReplacements(String input) {
  if (input == null || input.length() <= 1)
    return 0;
  //每个位置左边的b数量, not including the current index
  int[] bCount = new int[input.length()];
  for (int i = 1; i < bCount.length; i++) {
    if (input.charAt(i - 1) == 'b') {
      bCount[i] = bCount[i - 1] + 1;
    } else {
      bCount[i] = bCount[i - 1];
    }
  }
  //每个位置右边的a数量 not including the current index
  int[] aCount = new int[input.length()];
  for (int i = aCount.length - 2; i >= 0; i--) {
    if (input.charAt(i + 1) == 'a') {
      aCount[i] = aCount[i + 1] + 1;
    } else {
      aCount[i] = aCount[i + 1];
    }
  }
  int min = Integer.MAX_VALUE;
  for (int i = 0; i < input.length(); i++) {
    min = Math.min(min, aCount[i] + bCount[i]);
  }
  return min;
}

public int minReplacements(String input) {
    if (input == null || input.length() < 2) return 0;
    char[] ca = input.toCharArray();
    int allA = 0;
    int preB = 0;
    if (ca[0] == 'a')
      preB = 1;
    else
      allA = 1;
    for (int i = 1; i < ca.length; i++) {
      if (ca[i] == 'a')
        preB = Math.min(preB + 1, allA + 1);
      else {
        preB = Math.min(preB, allA);
        allA++;
      }
    }
    return Math.min(allA, preB);
  }

//O(n) O(n)
  public int minReplacements(String input) {
    // Write your solution here
    if(input.length() == 0)
      return 0;
    char[] arr = input.toCharArray();
    int n = arr.length;
	// Sa[i] is the intermediate result where size = (i + 1) and  replacedAOrMaintainB = false. It means that we have decided the previous value (input[n - i - 2] should be ‘a’ (either it’s originally ‘a’ or we replaced ‘b’ with ‘a’).
	int[] Sa = new int[n];
	// Sb[i] is the intermediate result where size = (i + 1) and  replacedAOrMaintainB = true. It means that we have decided the previous value (input[n - i - 2] should be ‘b’ (either it’s originally ‘b’ or we replaced ‘a’ with ‘b’).
	int[] Sb = new int[n];

	// init Sb
	// The value of Sb[i] should be the count of As in input.substring(i+1, n), which we want to replace with b.
	// Sb[i] can be calculated from the value of Sb[i-1].
	Sb[0] = (arr[n - 1] == 'a') ? 1 : 0;
	for (int i = 1; i < n; i ++)
		Sb[i] = Sb[i-1] + ((arr[n - i - 1] == 'a') ? 1 : 0);

	// Init Sa
	// Sa[i] depends on both Sa[i-1] and Sb[i-1], so we initiated Sb first.
	Sa[0] = 0;
	for (int i = 1; i < n; i ++){
		// Sa[i] should be the minimum of the two decisions — make the current character to be either ‘a’ or ‘b’.
		Sa[i] = Math.min(Sa[i-1] + ((arr[n - i - 1] == 'a') ? 0 : 1), Sb[i-1] + ((arr[n - i - 1] == 'a') ? 1 : 0));
    // Decide to make the current character to be ‘a’. no replacement needed if it’s already ‘a’, otherwise replacement + 1.
    // Decide to make the current character to be ‘b’. no replacement needed if it’s already ‘b’, otherwise replacement + 1.
	}
	return Sa[n - 1];
    // We should return the min of Sa and Sb here, but Sa is definitely no greater than Sb since assuming the previous character to be ‘a’ is more relaxed than ‘b’.

  }
  //O(n^2) O(1)
  private int minReplacement(String str){
    char[] arr = str.toCharArray();
    int global_min = Integer.MAX_VALUE;
    //int count = Integer.MAX_VALUE;
    //i: space pointer, make sure all left replace to a, all right replace to b
    for(int i = 0; i <= arr.length; i++){

      int count = countChar(arr, 0, i, 'b')+ countChar(arr, i, arr.length - i, 'a');

      global_min = Math.min(global_min, count);
    }
    return global_min;
  }
  private int countChar(char[] arr, int index, int length, char c){
    int res = 0;
    for(int i = index; i <= index+length; i++){
      if(arr[i] == c)
        res++;
    }
    return res;
  }
