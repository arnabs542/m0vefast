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
