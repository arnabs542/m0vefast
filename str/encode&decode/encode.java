//“a1c0b2c4” <- “abbcccc” 2
//Q3: string encoding
public int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        while(fast < chars.length){
            char currentChar = chars[fast];
            int count = 0;
            while(fast < chars.length && chars[fast] == currentChar){
                fast++;
                count++;
            }
            chars[slow++] = currentChar;
            if(count != 1)  //?
                for(char c : Integer.toString(count).toCharArray())
                    chars[slow++] = c;
        }
        return slow;
    }