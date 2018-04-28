/*
编程题是 check valid anagram 检测一个string 是不是可以改成anagram
思路很简单  用一个hashmap纪录string中出现的字母的次数。
如果出现次数为奇数次的字母超过1个，返回false，反之返回true。
*/
//isAnagram
public boolean anagram(String s){
	if(s == null || s.length() <=1)
		return true;
	int[] count = new int[256];
	for(int i = 0; i < s.length(); i++){
		count[(int)s.charAt(i)]++;
	}
	int flag = 0;
	for(int i = 0; i < s.length(); i++){
		if(count[i] % 2 == 1){
			flag++;
			if(flag > 1)
				return false;
		}
	}
	return true;
}
	