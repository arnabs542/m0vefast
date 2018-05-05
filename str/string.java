//========1) char removal
//Q0: remove duplicate white space
//" I   love TV" -> "I love TV"
public String removeSpaces(String input) {
	if(input == null || input.length() == 0)
		return input
	char[] arr = input.toCharArray();
	int slow = 0;
	for(int fast = 0; fast < arr.length; fast++){
		//igore consecutive ' '
		//ignore first ' '
		if(arr[fast] == ' ' && (fast == 0 || arr[fast-1] == ' '))
			continue;
		else
			arr[slow++] = arr[fast];
	}
	//ignore last ' ', not catched in the for loop
	if(slow > 0 && arr[slow-1] == ' ')
		return new String(arr, 0, slow-1);
	return new String(arr, 0, slow);
}
//Q1: remove certain char
//Input: "abcdefg","af" -> "bcdeg"
//more space for set
public String remove(String input, String t){
	char[] arr = input.toCharArrary();

	Set<character> set = new HashSet<>();
	for(int i = 0; i < t.length(); i++)
		set.add(t.charAt(i));

	int slow = 0;
	for(int fast = 0; fast < arr.length; fast++){
		if(!set.contains(arr[fast]))
			arr[slow++] = arr[fast];
	}
	return new String(arr, 0, slow);
}
//another version: more space for sb, and time: for-in-for
public String remove(String input, String t){
	StringBuilder sb = new StringBuilder();

	for(int i = 0; i < input.length(); i++){
		if(!t.contains(String.valueOf(input.charAt(i))))
			sb.append(input.charAt(i));
	}
	return sb.toString();
}
//not good time: for-in-for
public String remove(String input, String t) {
    // Write your solution here.
    char[] arr = input.toCharArray();
    int cur = 0;
    for(int i = 0; i < input.length(); i++){
      if(!t.contains(String.valueOf(input.charAt(i))))
        arr[cur++] = input.charAt(i);
    }
    return new String(arr, 0, cur);
}


//======================2) char de-duplication
//Q2: remove adjacent duplicated without count
public String reduceString(String s){
	if(s == null || s.length() == 0)
		return null;
	StringBuilder sb = new StringBuilder();
	char cur = s.charAt(0);
	sb.append(cur);
	int i = 0;
	for(int i = 0; i < s.length(); i++){
		if(s.charAt(i) == cur){}//no nothing
		else{
			sb.append(String.valueOf(cur));
			cur = s.charAt(i);
		}
	}
	sb.append(String.valueOf(cur));
	return sb.toString();
}
//better solution: inplace
public String reduceString(String s){
	if(s == null || s.length() == 0)
		return null;
	char[] arr = s.toCharArray();
	int slow = 0;
	int fast = 0;
	for(fast = 0; fast < arr.length; fast++){
		if(fast == 0 || arr[fast] != arr[slow-1]){
			arr[slow++] = arr[fast];
		}
	}
	return new String(arr, 0, slow);
}

//Q3: zuma
public String deDup(String input) {
	if(input == null || input.length() <=1)
		return input;
	char[] arr = input.toCharArray();
	int slow = 0;  //inclusive to the final answer
	int fast = 1;
	for(fast = 1; fast < arr.length; fast++){
		//slow = -1, stack is empty
		//or when no duplicate, we push on to the stack
		//only looks at next one
		if(slow == -1 || arr[fast] != arr[slow])
			arr[++slow] = arr[fast];
		else{
			//otherwise, pop the element at index cur
			slow--;  //this might cause cur = -1, cur stays at latest char index
			while(fast+1 < arr.length && arr[fast] == arr[fast+1])
				fast++;
		}
	}
	return new String(arr, 0, slow+1);  //slow is inclusive
}


//========5) advance topic
//Q3: string encoding
public String reduceString(String s){
	if(s == null || s.length() == 0)
		return null;
	StringBuilder sb = new StringBuilder();
	char cur = s.charAt(0);
	int count = 0;
	for(int i = 0; i < s.length(); i++){
		if(s.charAt(i) == cur){
			count++;
		else{
			//if sb is string type, we can just use: sb+=(target to append)
			sb.append(Integer.toString(count));
			sb.append(String.valueOf(cur));
			count = 1;
			cur = s.charAt(i);
		}
	}
	sb.append(count);  //sb+=Integer.toString(count) if sb==string
	sb.append(cur);
	return sb.toString();
}
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



//Q3: reduct all e to one e
public String reduceDuplicateE(String s){
	if(s == null || s.length() == 0)
		return null;
	if(s.contains("ee"))
		return reduceDuplicateE(s.replace("ee", "e"));
	else
		return s;
}
//antoehr version  not using recursion
public String reduceDuplicateE(String s){
	if(s == null)
		return null;
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < s.length()){
		if(s.charAt(i) == 'e'){
			sb.append(s.charAt(i));
			while(i < s.length() && s.charAt(i) == 'e')
				i++;
		}else{
			sb.append(s.charAt(i));
			i++;
		}
	}
	return sb.toString();
}
