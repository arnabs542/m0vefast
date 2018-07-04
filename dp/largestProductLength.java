//largest product of two words’ lengths, such that the two words do not share any common characters.
//solution1: DP(bit mask)
public int largestProductLength(String[] dict) {
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

//other solutions
//max length product && no common char in 2 strings
// bit mask
public int largestProduct(String[] words) {
    // Write your solution here.
   if(words==null || words.length==0)
        return 0;

    int[] bitMask = new int[words.length];
    for(int i=0; i<words.length; i++){
        for(int j=0; j<words[i].length(); j++){
            //note0
            char c = words[i].charAt(j);
            //note1!
            bitMask[i] |= (1 << (c-'a'));
        }
    }

    int result = 0;

    for(int i=0; i<words.length; i++){
        for(int j=i+1; j<words.length; j++){
          //note2!: bracket
            if((bitMask[i] & bitMask[j]) == 0){
                result = Math.max(result, words[i].length()*words[j].length());
            }
        }
    }

    return result;
  }

//antoehr solution :
public class LargestProductOfLength {
    static class Pair {
        int first;
        int second;
        int product;
        Pair(int first, int second, int product) {
            this.first = first;
            this.second = second;
            this.product = product;
        }
        //我们只取最大的那一个，而不是前k个，所以就算有重复也不会对结果有影响。
//         @Override
// public boolean equals(Object obj) {
//     if (this == obj) {
//         return true;
//     }
//     if (!(obj instanceof Pair)) {
//         return false;
//     }
//     Pair another = (Pair) obj;
//     return this.first == another.first && this.second == another.second;
// }
// @Override
// public int hashCode() {
//     return first * 101 + second;
// }
    }
    public int largestProduct(String[] dict) {
        // Write your solution here.
        // sort bitMaskay by length
        Map<String, Integer> map = getBitMasks(dict);
        bitMaskays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return 0;
                }
                return o1.length() < o2.length() ? 1 : -1;
            }
        });
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(11, new Comparator<Pair>() {
           @Override
           public int compare(Pair o1, Pair o2) {
               if (o1.product == o2.product) {
                   return 0;
               }
               return o1.product < o2.product ? 1 : -1;
           }
        });
        Set<Pair> visited = new HashSet<>();
        Pair curr = new Pair(0, 1, dict[0].length() * dict[1].length());
        visited.add(curr);
        maxHeap.offer(curr);
        while (!maxHeap.isEmpty()) {
            curr = maxHeap.poll();
            if ((map.get(dict[curr.first]) & map.get(dict[curr.second])) == 0) {
                return curr.product;
            }
            if (curr.first + 1 < dict.length) {
                Pair newNode = new Pair(curr.first + 1, curr.second, dict[curr.first + 1].length() * dict[curr.second].length());
                if (visited.add(newNode)) {
                    maxHeap.offer(newNode);
                }
            }
            if (curr.second + 1 < dict.length) {
                Pair newNode = new Pair(curr.first, curr.second + 1, dict[curr.first].length() * dict[curr.second + 1].length());
                if (visited.add(newNode)) {
                    maxHeap.offer(newNode);
                }
            }
        }
        return 0;
    }
    private Map<String, Integer> getBitMasks(String[] dict) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : dict) {
            int bitMask = 0;
            for (int i = 0; i < str.length(); i++) {
                bitMask |= 1 << (str.charAt(i) - 'a');
            }
            map.put(str, bitMask);
        }
        return map;
    }
}
