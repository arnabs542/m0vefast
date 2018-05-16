// //n starts from 1, the first number is "1", the second number is "11
// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
public String countAndSay(int n) {
   String str = "1";
   while(--n > 0){
     StringBuilder sb = new StringBuilder();
     char[] arr = str.toCharArray();
     for(int i = 0; i < arr.length; i++){
      int count = 1;
       while((i+1) < arr.length && arr[i] == arr[i+1]){
         count++;
         i++;
       }
       sb.append(String.valueOf(count) + String.valueOf(arr[i]));
     }
     str = sb.toString();
   }
   return str;
 }
