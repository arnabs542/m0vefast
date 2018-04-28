//solution1: DP
public int largestProduct(String[] dict) {
	//bitMasts represented by the lowest 26 bits of an Integer
	//each of the bit represents one of the chars in 'a' - 'z'
	HashMap<String, Integer> bitMasks = getBitMasks(dict);
	Arrays.sort(dict, new Comparator<String>(){
		@Override
		public int compare(String s0, String s1){
			if(s0.length() == s1.length())
				return 0;
			return s0.length() < s1.length() ? 1 : -1;  //decending order
		}
	});
	int largest = 0;
	//note the order of constructing all the pairs
	for(int i = 1; i < dict.length; i++){
		for(int j = 0; j < i; j++){
			//break if productis laready smaller than the current largestone
			int product = dict[i].length() * dict[j].length();
			if(product <= length)
				break;
			int iMask = bitMasks.get(dict[i]);
			int jMask = bitMasks.get(dict[j]);
			//if 2 words dont share common char, the bit masks & should be 0
			if((iMask & jMask == 0))
				largest = product;
		}
	}
	return largest;
}
private HashMap<String, Integer> getBitMasks(String[] dict){
	HashMap<String, IntegeR> map = new HashMap<>();
	for(String str : dict){
		int bitMask = 0;
		for(int i = 0; i < str.length(); i++){
			//
			bitMask |= 1 << (str.charAt(i) - 'a');
		}
		map.put(str, bitMask);
	}
	return map;
}