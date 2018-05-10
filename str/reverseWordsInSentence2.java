//with heading or ending white spaces
//no duplicate white space
//“ I  love  Google  ” → “Google love I”

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


public String reverseWords(String input) {
    // Write your solution here
    if(input.length() <= 1)
      return input;
    String res = removeSpaces(input);
    return reverse(res);
    //return new String(arr);
  }
  private String reverse(String str){
  	char[] arr = str.toCharArray();
    int start = 0;
    for(int i = 0; i < arr.length; i++){
    	if(arr[i] != ' ' && (i == 0 || arr[i-1] == ' '))
         start = i;
      if(arr[i] != ' ' && (i == arr.length-1 || arr[i+1] == ' '))
         reverse(arr, start, i);
    }
    reverse(arr,0, arr.length-1);
    return new String(arr);

  }


  private void reverse(char[] arr, int left, int right){
    if(left > right){
    	return;
    }
    swap(arr, left, right);
    reverse(arr, left+1, right-1);
  }
  private void swap(char[] arr, int left, int right){
  	char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  private String removeSpaces(String input) {
    // Write your solution here.
    int cur = 0;
    //int slow = 0;
    char[] arr = input.toCharArray();
		for(int i = 0; i < arr.length; i++){
      //case2: if cur != ' ', ignore
      //case1: if cur = ' '
      	//case1.1 index = 0
      	//case1.2 cur = prev = ' '
    	if(arr[i] == ' ' && (i == 0 || arr[i-1] == ' ')){
      	continue;
      }
      arr[cur++] = arr[i];
      	//case1.3 prev != ' ', ignore
    }
    //miss case due to case 1.2, might have one ' ' in the end
    if(cur > 0 && arr[cur-1] == ' ')
      return new String(arr, 0, cur-1);
    return new String(arr, 0, cur);

  }
