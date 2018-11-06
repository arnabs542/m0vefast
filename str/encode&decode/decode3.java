//"3[a2[c]]", return "accaccacc".
//alwasy a [ after a number
//laioffer solution using sb
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
            if (cur < '0' || cur > '9') { // not a digit:a;
                sb.append(cur);
                index[0]++;
            } else { // it’s a digit; calculate the digits:2;
                int cnt = 0;
                while (index[0] < n && s.charAt(index[0]) >= '0' && s.charAt(index[0]) <= '9') {
                    cnt = 10 * cnt + (s.charAt(index[0]) - '0');
                    index[0]++;  //keep changing in the loop
                }
                index[0]++; // skip '[';
                // get the decoded string from its sub-problem;
                String decodedString = decode(s, index);
                index[0]++; // skip ']'
                // repeatedly copy k times;
                // while (cnt > 0) {
                //     sb.append(decodedString);
                //     cnt--;
                // }
                copyStr(sb, decodedString, count);
            }
        }
        return sb.toString();
    }

//laioffer solution: didnt pass for :
// 因为 Java 是传 value 的啊！
// 假设一开始 index = 0;
// index += 1; // index --> 1;
// String t = decode(s, index); // --> 我们本来期待这句能修改 index 的值，但是这儿index 并没有改变；
// index += 1; // --> index --> 2;
// 而要使用 int[] index 的话，因为 array 是放在 heap 上的，
// String t = decode(s, index);  // --> 这儿的 index 只是 copy 了一个 array 的 reference 而已，
// 主体内容还在 heap 上， 所以recursion call 可以通过 reference 对它进行修改。
// 因为array 是一个object, 所以 只要是object, 都会传一个参数，那么都会进行改变。
// 所以map, set, .....如果作为参数的话，也都会改变的。
public class Solution {
    public String decodeString(String s) {
        return decode(s, 0);
    }
    public String decode(String s, int index) {
        String res = "";
        int n = s.length();
        while (index < n && s.charAt(index) != ']') {
            char curr = s.charAt(index);
            if (!Character.isDigit(curr)) {
                res += curr;
                index += 1;
                //System.out.println(curr);
            } else {
                int count = 0;
                while (index < n && Character.isDigit(s.charAt(index))) {
                    count += count * 10 + (s.charAt(index) - '0');
                    index += 1;
                }
                index += 1; //meet '['
                String t = decode(s, index);
                index += 1; //jump ']'
                while (count > 0) {
                    res += t; //repreat
                    count -= 1;
                }
            }
        }
        return res;
    }
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
