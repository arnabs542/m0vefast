public String decodeString(String s) {
        // sanity check
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] index = new int[] { 0 };
        return decode(s, index);
    }

    private String decode(String s, int[] index) {
        StringBuilder sb = new StringBuilder();
        // scan the whole input string to decode it;
        int n = s.length();
        while (index[0] < n && s.charAt(index[0]) != ']') {
            char cur = s.charAt(index[0]);
            if (cur < '0' || cur > '9') { // not a digit;
                sb.append(cur);
                index[0]++;
            } else { // it’s a digit; calculate the digits;
                int cnt = 0;
                while (index[0] < n && s.charAt(index[0]) >= '0'
                        && s.charAt(index[0]) <= '9') {
                    cnt = 10 * cnt + (s.charAt(index[0]) - '0');
                    index[0]++;
                }
                index[0]++; // skip '[';
                // get the decoded string from its sub-problem;
                String decodedString = decode(s, index);
                index[0]++; // skip ']'
                // repeatedly copy k times;
                while (cnt > 0) {
                    sb.append(decodedString);
                    cnt--;
                }
            }
        }
        return sb.toString();
    }

    https://piazza.com/class/j0eqhhdregb3i?cid=491

    //Q4: string decoding inplace version
    public String decode(String input){
    	if(input.isEmpty())
    		return input;
    	char[] arr = input.toCharArray();
    	return decodeLong(arr, decodeShort(arr));
    }
    //for the decoded string is shorter: a1, a0, a2
    private int decodeShort(char[] arr){
    	int end = 0;
    	//res is shorter, do from left to right
    	for(int i = 0; i < arr.length; i += 2){
    		int digit = getDigit(arr[i+1]);
    		if(digit >= 0 && digit <=2 ){
    			for(int j = 0; j < digit; j++){
    				arr[end++] = arr[i];
    			}
    		}else{
    			//dont handle longer decoded string here
    			arr[end++] = arr[i];
    			arr[end++] = arr[i+1];
    		}
    	}
    	return end;
    }
    //for the decoded string is longer: a3, a4, a5
    private int decodeLong(char[] arr, int length){
    	int newLength = length;
    	for(int i = 0; i < length; i++){
    		int digit = getDigit(arr[i]);
    		if(digit > 2 && digit <= 9){
    			newLength += digit - 2;
    		}
    	}
    	char[] res = new char[newLength];
    	int end = newLength -1;
    	//res is longer, do from right to left
    	for(int i = length-1; i >= 0; i--){
    		int digit = getDigit(arr[i]);
    		if(digit > 2 && digit <= 9){
    			i--;
    			for(int j = 0; j < digit; j++){
    				res[end--] = arr[i];
    			}
    		}else{
    			res[end--] = arr[i];
    		}
    	}
    	return new String(res);
    }
    private int getDigit(char digit){
    	return digit - '0';
    }

    //Q4: string decoding not inplace version using sb
    public String decode(String input){
    	char[] arr = input.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < arr.length; i++){
    		char ch = arr[i++];
    		int count = arr[i] - '0';
    		for(int c = 0; c < count; c++){
    			sb.append(ch);
    		}
    	}
    	return sb.toString();
    }
