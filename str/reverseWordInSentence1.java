//no heading or ending white spaces
//no duplicate white space
//eg: “I love Google” → “Google love I”
public String reverseWords(String s) {
        // write your code here
  if(s == null || s.length() == 0)
		return "";
	String[] arr = s.split(" ");
	StringBuilder sb = new StringBuilder();
	for(int i = arr.length -1; i >=0; i--){
		if(!arr[i].equals(" "))
			sb.append(arr[i]).append(" ");
	}
	//if input is " "
	if(sb.length() == 0)
		return "";
	else //remove the last " " from line 11
		return sb.substring(0, sb.length()-1);
		//cant use sb.toString()
    }

//soluwion2: O(n), O(1)
//can handle heading and ending whitespace, but not duplciate space
public void reverseWords(String input) {
if(input == null || input.length <= 1)
      return input;
    char[] arr = input.toCharArray();
    int start = 0;
    //reverse each word=> i evol     oohay
    //reverse(arr, 0, arr.length -1);
   	for(int i = 0; i < arr.length; i++){
    //start index of a word
      if(arr[i] != ' ' && (i == 0 || arr[i-1]== ' '))
         start = i;
      //end index of a word
      if(arr[i] != ' ' && (i == arr.length -1 || arr[i+1] == ' '))
        reverse(arr, start, i);
    }
    //reverse the senctence => i yahoo     love i
    reverse(arr, 0, arr.length -1);
    return new String(arr);
  }
  // i love     yahoo
  // i love     yahoo
  // i love     yahoo
  // i love     yahoo
  // i love     yahoo
  // i evol     yahoo
  // i  love    yahoo
  // i  evol    yahoo
  // i   love   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   yahoo
  // i   evol   oohay
  // yahoo   love   i%

  private static void reverse(char[] arr, int left, int right){
    while(left < right){
      swap(arr, left, right);
      reverse(arr, left + 1, right-1);
    }
  }
  private void swap(char[] arr, int left, int right){
  	char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  //no heading or ending white spaces
  //with duplicate white space
//"    i love   yahoo" -> "yahoo love i"
大家把基本的扫描三遍的方法掌握好就行，即：

1. Reverse the entire string.

2. Reverse each word.

3. Deduplicate spaces.



学有余力的同学再去考虑如何合并第二步和第三步。歌词大意是这样的：

Data structure

slow: slow左边不包括slow是已处理好的
fast: 当前位置
word_end: fast指向的单词的末尾
Algorithm

右移fast直到fast指向一个非空格，此时fast指向一个单词的开始
右移word_end直到word_end指向单词的末尾
如果slow不是句子的开始(i.e. slow == 0)，则a[slow++] = 空格
将[fast, word_end]反向拷贝到[slow, slow+word_end-fast]，这时分情况讨论
如果[slow, slow+word_end-fast]和[fast, word_end]完全不重叠，非常简单
如果[slow, slow+word_end-fast]和[fast, word_end]有重叠，将重叠的部分反转，将非重叠的部分反向拷贝
例如：
s f  word_end
XXlove

先反转lo，得到
XXolve

然后反向拷贝ve到slow处，得到
evolve
