public double largestProduct(double[] array) {
  if (array.length == 1)
    return array[0];
  double pos = Math.max(array[0], 0);
  double neg = Math.min(array[0], 0);
  double globalMax = array[0];
  for (int i = 1; i < array.length; i++) {
    if (array[i] > 0) {
      pos = Math.max(pos * array[i], array[i]);
      neg = neg * array[i];
    } else if (array[i] < 0) {
      double prev = pos;
      pos = neg * array[i];
      neg = Math.min(prev * array[i], array[i]);
    } else {
      pos = 0;
      neg = 0;
    }
    globalMax = Math.max(globalMax, pos);
  }
  return globalMax;
}
