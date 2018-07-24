"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]  //facebook....
public List<String> removeInvalidParentheses(String s) {
       List<String> results = new LinkedList<>();
       if(s == null){
           return results;
       }
       int n = s.length();
       int l = 0;  //overdue left, how many left
       int r = 0;  //overdue right, how many right
         //求出需要移除的左右括号数目，即为不规范的( 和 )数目
       for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == '('){
               l++;
           }
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
   private void dfs(StringBuilder sb, int index, int l, int r, List<String> results){
       if(l == 0 && r == 0){
           if(isValid(sb)){
               results.add(sb.toString());
           }
           return;
       }
        //for loop操作每次删掉一个多余括号
       for(int i = index; i < sb.length(); i++){
         //连续多个重复括号删除第一个效果和删掉其他的相同，所有就删第一个。
           if(i > index && sb.charAt(i) == sb.charAt(i - 1)){
               continue;
           }
           // "()())()" -> ["()()()", "(())()"]
           // "()())()" -> ["()()()", "(())()"]
            //遇到 (，如果 l >0 去掉， 遇到)同理
           if(sb.charAt(i) == '(' && l > 0){
               sb.deleteCharAt(i);
               dfs(sb, i, l - 1, r, results);
               sb.insert(i, '(');
           }

           if(sb.charAt(i) == ')' && r > 0){
               sb.deleteCharAt(i);
               dfs(sb, i, l, r - 1, results);
               sb.insert(i, ')');
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
