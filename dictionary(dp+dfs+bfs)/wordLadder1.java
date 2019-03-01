https://www.programcreek.com/2012/12/leetcode-word-ladder/
//find the shortest transformation (int)
//str1 -> str2 using words in dict, one transformation can change only one letter,
//bfs1:
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 0;
        }
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        // check endWord should be in wordList
        Set<String> words = new HashSet<String>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        // enqueue only when it can be closer to optimal solution
        Map<String, Integer> visited = new HashMap<String, Integer>();
        Queue<String> queue = new LinkedList<String>();
        
        queue.offer(beginWord);
        visited.put(beginWord, 1);   //chained words list

        while (!queue.isEmpty()) {
            String head = queue.poll();
            int step = visited.get(head);

            char[] cs = head.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a' + j);
                    if (c != head.charAt(i)) {
                        cs[i] = c;

                        String next = new String(cs);
                        //early stop
                        if (next.equals(endWord)) {
                            return step + 1;
                        }
                        //rule
                        if (words.contains(next) && (!visited.containsKey(next) || visited.get(next) > step + 1)) {
                            visited.put(next, step + 1);
                            queue.offer(next);

                        cs[i] = head.charAt(i);
                    }
                }
            }
        }
        return 0;
    }

//bfs2: time limit exceed
class Node{
    String word;
    int step;
    public Node(String word, int step){
        this.word = word;
        this.step = step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //data structure: queue
        //maintain wordList
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, 1));
        //  wordList.add(endWord);

        while(!queue.isEmpty()){
            Node top = queue.remove();
            String str = top.word;
            //termination
            if(str.equals(endWord)){
                return top.step;
            }
            //otherwise, continue replacing each char with each a-z O(26 * starword.length)
            char[] arr = str.toCharArray();
            for(int i = 0; i < arr.length; i++){
                for(char j = 'a'; j <= 'z'; j++){
                    char original = arr[i];
                    if(arr[i] != j){
                        arr[i] = j;
                    }
                    String afterReplacement = new String(arr);
                    if(wordList.contains(afterReplacement)){
                        //add to pipieline and maintain dictionary
                        queue.add(new Node(afterReplacement, top.step + 1));
                        wordList.remove(afterReplacement);
                    }
                    arr[i] = original;
                }
            }
        }
        return 0;
    }
}
