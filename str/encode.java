//“a1c0b2c4” <- “abbcccc” 2
//Q3: string encoding
public String encode(String str) {
    // Write your solution here
    String res = "";
    if (str.length() == 0) return res;

    int count = 0;
    char currChar = str.CharAt(0);
		char prevChar = str.CharAt(0);
    for (int i = 0; i < str.length(); i++) {
        if (i == 0) {
            currChar = prevChar = str.charAt(i);
        }
        currChar = str.charAt(i);
        if (currChar != prevChar) { //update result
            res = res + prevChar + count;
            count = 1; //for the occurance of the current char
        } else {
            count++;
        }
        prevChar = currChar;
    }
    res = res + prevChar + count;
    return res;
}
