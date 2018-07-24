//facebook
//http://fisherlei.blogspot.com/2017/07/leetcode-task-scheduler-solution.html
public int leastInterval(String[] tasks, int n) {
    // Write your solution here
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    for(String each : tasks){
      if(map.containsKey(each)){
        map.put(map.get(each) + 1);
        count = Math.max(count, map.get(each));
      }else{
        map.put(each, 1);
      }
    }
    int res = (count - 1) * (n+1);
    for(Map.Entry<String, Integer> entry : map.entrySet()){
      if(entry.getValue() == count)
        res++;
    }
    return Math.max(tasks.length, res);
    //return res; if occurance is all 1, then count = 0
    //wrong: new String[]{"A","B"}, 2 *(count=res=0)  expected:<2> but was:<-3>
  }
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
