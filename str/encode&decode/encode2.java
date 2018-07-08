//abcc -> a1b1c2
//Q3: string encoding
 public String compress(String str) {
        // write your solution here
        //str is not null
        String res = "";
        if (str.length() == 0)
            return res;
        int count = 1;   //or initilaize as 1, then forloop start from index 0
        char currChar = str.charAt(0);
        char prevChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            currChar = str.charAt(i);
            if (currChar != prevChar) {
                res = res + prevChar + count;
                count = 1;
            } else {
                count++;
            }
            prevChar = currChar;
        }
        res = res + prevChar + count;
        return res;
    }