//“a1c0b2c4” → “abbcccc” 2
//char number char number...
//abcc -> abc2
//char char char number....
https://www.programcreek.com/2014/09/leetcode-decode-string-java/
follow up question:
https://piazza.com/class/j0eqhhdregb3i?cid=29
//Q3: string encoding
 public String compress(String str) {
  // write your solution here
//str is not null
        char[] chars = str.toCharArray();
        int anchor = 0;
        int write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return new String(chars, 0, write);

    }
// Time Complexity: O(N)O(N), where NN is the length of chars.
// Space Complexity: O(1)O(1), the space used by read, write, and anchor.