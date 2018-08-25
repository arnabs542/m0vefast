Input: path = “/home/”
Output: “/home”
Input: path = “/a/./b/../../c/”
Output: “/c”
https://unix.stackexchange.com/questions/249039/what-means-the-dots-on-a-path
object判断内容相等请用equals，并祈祷该object没有使用默认的equals。。。==会对object地址进行比较而不是内容。
public String simplify(String path) {
    // Write your solution here
    if (path == null || path.length() <= 1){
      return "/";
    }
    int fast = 0;

    Deque<String> dq = new LinkedList<String>();  //final result
    //ORDER:  /, end, a, stack
    while(fast < path.length()){
      StringBuilder cur_path = new StringBuilder();
      while(fast < path.length() && path.charAt(fast) == '/'){
        fast++;
      }

      if(fast == path.length()){
				break;
      }
      //  /a/./c   cur_path = a  stack = a   .
			while(fast < path.length() && path.charAt(fast) != '/'){
        temp_path.append(path.charAt(fast));
        fast++;
      }

      if (temp_path.toString().equals(".")){
      //if (sb.toString() == "."){
        continue;
      } else if (temp_path.toString().equals("..")){
      //} else if (sb.toString() == ".."){
        if (!dq.isEmpty()) {
        	dq.pollLast();
        } else {
          continue;
        }
      } else { //cur_path not .  .. but a regular path like a
        dq.offerLast(temp_path.toString());
      }
    }

    StringBuilder res = new StringBuilder();
    if (dq.isEmpty()){
      return "/";
    }
    while(!dq.isEmpty()){
      res.append('/');
      res.append(dq.pollFirst());
    }
    return res.toString();
  }
