Input: num = "1432219", k = 3
Output: "1219"
//2 pointer 

public String removeKdigits(String num, int k) {
        char[] num_arr = num.toCharArray();
        int index = 0;
        int current = 0;
        while(current < num_arr.length) {
            while(k > 0 && index != 0 && num_arr[index - 1] > num_arr[current]) {
                index--;
                k--;
            }
            num_arr[index++] = num_arr[current++];
        }
        while(k > 0) {
            index--;
            k--;
        }
        StringBuilder builder = new StringBuilder();
        current = 0;
        while(current < index && num_arr[current] == '0') current++;
        while(current < index) {
            builder.append(num_arr[current]);
            ++current;
        }
        String ans = builder.toString();
        return ans.length() != 0 ? ans : "0";
    }
