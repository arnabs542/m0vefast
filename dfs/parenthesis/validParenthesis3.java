"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]  //facebook.... O（n^2)
public List<String> removeInvalidParentheses(String s) {
       List<String> results = new LinkedList<>();
       if(s == null){
           return results;
       }
       int n = s.length();
       int l = 0;  //多余的左括号
       int r = 0;  //多余的右括号
         //求出需要移除的左右括号数目，即为不规范的( 和 )数目
         //1) 所以cnt1和cnt2要么都为0，2) 要么都大于0，比如")("。3) 要么一个为0，另一个大于0。
       for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == '('){
               l++;
           }
           //在任何时候如果')'的个数多于左括号，则说明从开始到现在位置必然可以删除一个')'．
           //而这段子串可能包含多个')'，删除哪一个呢？当然删除任何一个都可以
           if(s.charAt(i) == ')'){
               if(l > 0){
                   l--;
               }else{
                   r++;
               }
           }
       }
       dfs(new StringBuilder(s), 0, l, r, results);
       return results;
   }
   //all valid permutation of parenthesis of bracke=> validParenthesis1.java
   //index: 表示当前递归开始的位置
   private void dfs(StringBuilder sb, int index, int l, int r, List<String> results){
     //如果当cnt1和cnt2都为0时，说明此时左右括号个数相等了
       if(l == 0 && r == 0){
           if(isValid(sb)){
               results.add(sb.toString());
           }
           return;
       }
        //for loop操作每次删掉一个多余括号  排列看结果是否符合要求
       for(int i = index; i < sb.length(); i++){
         //比如"())"，这里有两个右括号，我们不管删第一个还是删第二个右括号都会得到"()
           //?? if(i > index && sb.charAt(i) == sb.charAt(i + 1)){
           if(i > index && sb.charAt(i) == sb.charAt(i - 1)){
               continue;
           }
           // "()())()" -> ["()()()", "(())()"]
           // "(a)())()" -> ["(a)()()", "(a())()"]
           // ")(" -> [""]  //facebook.... O（n^2)
          //此时来看如果cnt1大于0，说明此时左括号多，而如果当前字符正好是左括号的时候，
          //我们可以删掉当前左括号，继续调用递归，此时cnt1的值就应该减1，因为已经删掉了一个左括号
          //然后把剩下的String放入DFS递归
           if(sb.charAt(i) == '(' && l > 0){
               sb.deleteCharAt(i);
               dfs(sb, i, l - 1, r, results);
               sb.insert(i, '(');
               //dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, results);
           }

           if(sb.charAt(i) == ')' && r > 0){
               sb.deleteCharAt(i);
               dfs(sb, i, l, r - 1, results);
               sb.insert(i, ')');
               //dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, results);
           }
       }
   }

   private boolean isValid(StringBuilder sb){
       int delta = 0;
       for(int i = 0; i < sb.length(); i++){
           if(sb.charAt(i) == '('){
               delta++;
           }
           if(sb.charAt(i) == ')'){
               delta--;
           }
           //if more ) then left, pre determination
           if(delta < 0){
               return false;
           }
       }
       //shoudl  be eacual left and right brackewt
       return delta == 0;
   }
