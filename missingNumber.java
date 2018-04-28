//solution1: hashset
public int missing(int[] array) {
	int n = arr.length+1;
	HashSet<Integer> set = new HashSet<>();
	for(int number : array)
		set.add(number);
	//actually = is not necessary
	for(int i = 1; i <= n; i++){
		if(!set.contains(i))
			return i;
	}
	return n;
}
//solution2: sum  a math trick
//1+2+..n = n*(n+1)/2
public int missing(int[] array) {
	int n = array.length + 1;
	//0L: 0 in long type
	long targetSum = (n+0L)*(n+1)/2;
	long actualSum = 0L;
	for(int number : array){
		actualSum += num;
	}
	return (int)(targetSum - actualSum);
}

//solution3: bit manipulaton