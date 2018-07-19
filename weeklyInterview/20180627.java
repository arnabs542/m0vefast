想的时候的思路思考过程表达出来
If not sure: Exploring with example
Run through the code line by line

Circular loop


We consider a string consisting of two or more lowercase English alphabetic letters (i.e., [a-z])
to be amazing if no adjacent characters in the string are equal. For example,
the strings "abc", "abab", and "abca" are amazing; however,
the strings "aab", "abba", and "abcaa" are not amazing. If a string is not amazing,
then we can perform zero or more replace operations on the string.
We define a single replace operation to be the replacement of any character in the string with any
other lowercase English alphabetic letter.

public boolean isAmazing(String str){
   if(str == null || str.length() <= 1){
       return false;
   }
   char[] arr = str.toCharArray();
//normal case
   if(arr[0].isUpperCase()){
           return false;
   }
   for(int i = 1; i < arr.length; i++){
       if(arr[i].isUpperCase() || arr[i] == arr[i-1]){
           return false;
       }
   }
   return true;
}
abccddcaab
abcedecacb
Zz

public int replacement(String str){
   char[] arr = str.toCharArray();
   int counter = 0;
   for(int i = 1; i < arr.length; i++){
       if(arr[i] == arr[i-1]){
           counter++;
           char re = arr[i];
           26 - (re-’a’)   c d-z
for(int j = re - 'a'; j < 26 - (re-’a’); j++){
For (int re = (int) arr[i]+1; re != (int) arr[i]; re++)
{
If (re > (int)‘z’)
{
Re = (int)‘a’;
}
……
}
   if(char(j+’a’) == ‘z’)
J = 0;
               if(char(j+1 + ‘a’) != arr[i+1] && i+1 < arr.length){
re = char(j+1);  e
break;
    else if(i + 1 >= arr.length){
re = char(j+1);
break;

}
}
arr[i] = re;
       }
  return counter;
}


Int[] arr = new int[6];
for(int i = 0; i < 1000; i++){
if(i == arr.length)
I = 0;
System.out.print(i);

}
