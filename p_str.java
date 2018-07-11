//duplication
public String duplicate1(String str){
    if(str == null)
        return null;
    char[] arr = str.toCharArray();
    int slow = 0;
    int fast = 1;
    for(fast = 1; fast < arr.length; fast++){
        if(arr[slow] != arr[fast])
            arr[++slow] = arr[fast];
    }
    return new String(arr, 0, slow);
}
public String duplicate2(String str){
    if(str == null)
        return null;
    char[] arr = str.toCharArray();
    int slow = 0;
    int fast = 1;
    int couner = 1;
    for(fast = 1; fast < arr.length; fast++){
        if(arr[slow] != arr[fast])
            arr[++slow] = arr[fast];
        else{
            if(counter < 2)
                arr[++slow] = arr[fast];
                counter++;
        }
    }
    return new String(arr, 0, slow+1);
}
public String duplicate3(String str){
    if(str == null)
        return null;
    char[] arr = str.toCharArray();
    int slow = 0;
    int fast = 1;
    boolean flag;
    for(fast = 1; fast < arr.length; fast++){
        if(arr[slow] == arr[fast])
            flag = true;
        if(flag){
            arr[slow] = arr[fast];
            flag = false;
        }else{
            arr[++slow] = arr[fast];
        }
    }
    flag ? return new String(arr, 0, slow) : new String(arr, 0, slow+1);
}
public String duplicate4(String str){
    if(str == null)
        return null;
    char[] arr = str.toCharArray();
    int slow = 0;
    int fast = 1;
    for(fast = 1; fast < arr.length; fast}++){
        if(arr[slow] != arr[fast])
            arr[++slow] = arr[fast];
        else{
            while(fast + 1 < arr.length && arr[fast] == arr[fast+1])
                fast++;
            slow--;
        }
    }
    return new String(arr, 0, slow+1);
}
//remove
//remove space: i love    yahoo - > i love yahoo
public Stirng removeSpace(String str){
    if(str == null)
        return str;
    int slow = 0;   //not including the last pointer
    int fast = 0;
    char[] arr = str.toCharArray();
    for(fast = 0; fast < arr.length; fast++){
        //not space || space but last space
        if(arr[i] != ' ' || (i != 0 && arr[i-1] != arr[i]))
            arr[slow++] = arr[fast];
    }
    //for the last one might be space
    if(slow > 0  && arr[slow-1] == ' ')
        return new String(arr, 0, slow-1)
    return new String(arr, 0, slow);
}
//remove certain char:
public String removeCertainChars(Stirng str, String target){
    char[] arr = target.toCharArray();
    Set<Character> set = new HashSet<>();
    for(char each : arr){
        set.add(each);
    }
    char[] array = str.toCharArray();
    int slow = 0;
    int fast = 0;
    for(fast = 0; fast < arr.length; fast++){
        if(!set.contains(arr[slow]))
            arr[slow++] = arr[fast];
    }
    return new String(arr, 0, slow);
}

//replace shorter longer
public String replacement(Stirng input, Stirng str, String pattern){
    if(str.length() < pattern.length())
        return replaceLonger(input, str, pattern);
    return replaceShorter(intpu, str, pattern);
}
private String replaceShorter(String input, String str, String pattern){
    char[] arr = input.toCharArray();
    int slow = 0;
    int fast = 0;
    while(fast < arr.length){
    //for(fast = 0; fast < input.length() - str.length()+1; fast++){
        while(fast <= arr.length() - str.length() && equalStr(input, fast, str)){
        //if(equalStr(input, fast, str)){
            copyStr(input, slow, pattern);
            fast += str.length();
            slow += pattern.length();
        }else{
            arr[slow++] = arr[fast++];
        }
    }
    return new String(arr, 0, slow);
}
private String replaceLonger(String input, Stirng str, String pattern){
    char[] arr = input.toCharArray();
    List<Integer> list = getEndIndex(input, str, pattern);
    int final_len = input.length() + list.size() * (pattern.length() - str.length())
    int slow = res.legnth()-1;
    int fast = arr.length()-1;
    int index = list.size()-1;
    char[] res = new char[final_len];
    while(fast > 0){
        //if(fast == index){
        while(index >= 0 && fast == list.get(index)){
            copyStr(res, slow - pattern.length()+1, pattern)
            slow -= pattern.length();
            fast -= str.length();
            index--;
         }else{
            res[slow--] = arr[fast--];
      }
    }
    return new Stirng(res);
}
private boolean equalStr(Stirng input, int start, int pattern){
    for(int i = 0; i < pattern.lenngth(); i++){
        if(input.charAt(i+start) != pattern.charAt(i))
            return false;
    }
    return true;
}
private List<Intger> getEndIndex(String str, String target){
    List<Integer> res = new ArrayList<>();
    //for(int i = 0; i < str.length() - pattern.length() + 1; i++){
    int start = 0;
    while(start <= arr.legnth() - target.length()){
        if(equalStr(str, i, target)){
            res.add(i + target.length());
            start += target.length();
        }else{
            start++;
        }
    }
    return res;
}
private void copyStr(String str, int start, String pattern){
    for(int i = 0; i < pattern.length(); i++){
        str.charAt(i+start) = pattern.charAt(i);
    }
}

  private List<Integer> getAllMathces(char[] arr, String s){
    //all ending matching index of s in arr
    List<Integer> matches = new ArrayList<>();
    int cur_index = 0;
    //for all possible starting index
    while(start_index <= arr.length - s.length()){
        if(equalSubStr(arr, start_index, s)){
        matches.add(start_index + s.length() - 1);  //record the end index
        start_index += s.length(); //check next possible starting index
      }else{
        start_index++;
      }
    }
    return matches;
  }
//encode1 abcc -> abc2
public String encode1(String str){
    char prev = str.charAt(0);
    char cur = '';
    int counter = 1;
    String res = "";
    for(int i = 1; i < str.length(); i++){
        cur = str.charAt(i);
        if(cur != prev){
            if(counter > 1){
                res += prev + counter;
            }
            counter = 1;
        }else{
            counter++;
        }
        prev = cur;
    }
    if(counter > 1)
        return res += prev + counter;
    return res+= prev;

}
//encode2 abcc -> a1b2c2
public String encode2(String str){
    char prev = str.charAt(0);
    char cur = str.charAt(0);
    int counter 1;
    String res = "";
    for(int i = 1; i < arr.length; i++){
        cur = str.charAt(i);
        if(prev == cur){
            counter++;
        }else{
            res += prev + counter;
            counter = 1;
        }
        prev = cur;
    }
    return res += prev + counter;
}
//decode2 abcc <- a1b2c2
public Stirng decode2(Stirng str){
    char[] arr = str.toCharArray();
    int extra_space = 0;
    for(int i = 1; i < arr.length; i++){
        if(arr[i] > '2' && arr[i] < '9'){
            extra_space += arr[i] - '2';
        }else{
            extra_space -= '2' - arr[i]
        }
    }
    char[] res = new char[str.length() + extra_space];
    int fast = 1;
    for(fast = 1; fast< arr.length; fast += 2){
        char cur = arr[fast-1];
        int counter = 0;
        for(int i = 0; i < arr[fast] - '0'; i++){
            res[slow++] = cur;
        }
    }
    return new String(res);
}


//reverse
//i love    google  -> google love i
public String reverseWords(Stirng str){
    if(str == null)
        return null;
    char[] arr = str.toCharArray();
    int slow = 0;
    int fast = 0;
    for(fast = 0; fast <  arr.length; fast++){
        //determine start of the word
        if(arr[fast] != ' ' && (fast == 0 || arr[fast] != arr[fast-1]))
            slow = fast;
        //determine end of the word
        if(arr[fast] != ' ' && (fast == arr.length-1 || arr[fast+1] == ' '))
            reverse(arr, slow, fast);
    }
    reverse(arr, 0, arr.length);
    return new Stirng(arr, 0, arr.length);
}
private void reverse(String str, int left, int right){
    if(left > right)
        return;
    swap(str, left, right);
    reverse(str, left+1, right-1);
}
//reverse vowls
public String reverseVowls(String str){
    char[] arr = str.toCharArray();
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    int right = arr.length-1;
    int left = 0;
    while(left < right){
        if(!set.contains(arr[left]))
            left++;
        if(!set.contains(arr[right]))
            right--;
        else{
            swap(arr, left++, right--);
        }
    }
    return new String(arr, 0, arr.length);
}

//isomorphic
public boolean isomorphic(String one, String two){
    if(one.length() != two.length())
        return false;
    for(int i = ; i < one.length(); i++){
        if(map.containsKey(one.charAt(i)))
            if(map.get(one.charAt(i)) != two.charAt(i))
                return false;
            else
                continue;
        else{//map dones not contains a, that means b shouldnt be here
            if(map.containsKey(two.charAt(i)))
                return false;
            else
                map.put(one.charAt(i), two.charAt(i))

        }
    }
    return ture;

}
//substring
public boolean subStr(String long, String short){
    if(short.length() > long.length())
        return -1;
    for(int i = 0; i < long.length() - short.length() -1; i++){
        int j = 0;
        for(j = 0; j < short.length(); j++){
            if(short.charAt(j) != long.charAt(i+j))
                break;
        }
        j == short.length()
            return i;
    return -1;
}

//interleave: dp
//stirng shuffle
public int[] reorder(int[] array) {
    if(arr.length % 2 == 0)
        return helper(arr, 0, arr.length-1);
    return helper(arr, 0, arr.length-2);
}
private void helper(int[] arr, int left, int right){
    int size = right - left + 1;
    if(size <= 2)
        return;
    int mid = left + (right - left)/2;
    int lifemid = left + size/4;
    int rightmid = mid + size/4;
    reverse(arr, leftmide, mid-1);
    reverse(arr, mid, rightmid-1);
    reverse(arr, leftmide, rightmid-1);
    helper(arr, left, left+size/2-1);
    helper(arr, left+size/2, right
}
//abbrmatching
public boolean abbrmatching(String str, String target){
    return helper(str, 0, target, 0);
}
private boolean helper(Stirng a, int aleft, Stirng b, int bleft){
    if(aleft == a.length() && bleft == b.length())
        return true;
    if(aleft != a.legnth() || blength == b.length())
        return false;
    int counter = 0;
    if(Character.isDigit(a.charAt(aleft))){
        while(aleft < a.length()){
            counter = counter * 10 + a.charAt(i) - '0';
            aleft++;
        }
        return helper(a, aleft+counter, b, bleft);
    }else{ //not a digit
        if(a.charAt(aleft) == b.charAt(bleft))
            return helper(a, aleft+1, b, bleft+1);
        else
            return false;

    }
    return true;
}
