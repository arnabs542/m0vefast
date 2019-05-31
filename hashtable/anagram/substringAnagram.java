//substring anagram
public List<Integer> substringAnagram(String s, String p){
	List<Integer> res = new ArrayList<>();
	if(s.length() < p.length())
		return res;
	char[] sc = s.toCharArray();
	char[] pc = p.toCharArray();
	int[] count_p = new int[256];
	int[] count_s = new int[256];
	int[] det = new int[256];

	for(int i = 0; i < p.length(); i++){
		count_p[pc[i]]++;
		count_s[sc[i]]++;
		det[pc[i]]--;
		det[sc[i]]++;
	}
  
	int absSum = 0;
	for(int item : det)
		absSum += Math.abs(item);
	//same length. same word: abc-bca 
	if(absSum == 0)
		res.add(0);
	//2 pointers distance of p.length, s[0]-s[p.length()]
	for(int i = p.length() ; i < s.length(); i++){
		int left = sc[i - p.length()];  //char-int
		int right = sc[i];              //char-int
		count_s[left]--;
		count_s[right]++;

		absSum = absSum - Math.abs(det[right]) - Math.abs(det[left]);

		det[right]++;
		det[left]--;

		absSum = absSum + Math.abs(det[right]) + Math.abs(det[left]);

		if(absSum == 0)
			res.add(i - p.length() +1);
		}
	}
	return res;
}
public List<Integer> substringAnagram(String s, String p) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int[] det = new int[256];

        for (int i = 0; i < p.length(); i++) {
            det[pc[i]]--;
            det[sc[i]]++;
        }
        //first check 
        int absSum = 0;
		for(int item : det)
			absSum += Math.abs(item);
		//same length. same word: abc-bca 
		if(absSum == 0)
			res.add(0);
		//second check 
		//2 pointers distance of p.length, s[0]-s[p.length()]
        for (int i = p.length(); i < s.length(); i++) {
            int r = sc[i];                  //char-int
            int l = sc[i - p.length()];     //char-int
            //absSum always has p.length chars value 
            //purpose: get rid of effect of leftChar and rightChar
            //if rightChar never seen before, then -0;
            //if rightChar seen before, then -effect
            //ccaa-abc
            absSum = absSum - Math.abs(det[r]) - Math.abs(det[l]);

            det[r]++;  //new encountered char ++
            det[l]--;  //just checked/will no be considered char --
           	//adding updated effect of leftChar and rightChar
           	//if leftChar effect is deleted throughly, then add 0;
           	//if leftChar effect is not deleted throughly, then add left effect 
            absSum = absSum + Math.abs(det[r]) + Math.abs(det[l]);

            if (absSum == 0) {
                ans.add(i - p.length() + 1);  //return index of the left+1 
            }
        }
        return ans;
    }