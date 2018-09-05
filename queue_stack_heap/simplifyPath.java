Input: path = “/home/”
Output: “/home”
Input: path = “/a/./b/../../c/”
Output: “/c”
Input: path = “/..”
Output: “/”

https://unix.stackexchange.com/questions/249039/what-means-the-dots-on-a-path
object判断内容相等请用equals，并祈祷该object没有使用默认的equals。。。==会对object地址进行比较而不是内容。
public String simplify(String path) {
 if(path == null || path.length()== 0)
  return path;
 String res = "";
 Deque<String> cur_valid_dir = new LinkedList<>();
 Set<String> ignore = new HashSet(Arrays.asList("",".",".."));
 // Set<String> ignore = new HashSet();
 // ignore.add("..");   //case 3
 // ignore.add(".");
 // ignore.add("");
 for(String dir : path.split("/")){
   if(dir.equals("..") && !cur_valid_dir.isEmpty()){
     cur_valid_dir.pop();
   else if(!ignore.contains(dir))
     cur_valid_dir.offer(dir);
  }
  for(String dir : cur_valid_dir)
    res.add("/" + dir + res);
 }
  return res.isEmpty() ? "/" : res;

}
