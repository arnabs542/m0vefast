public String reverse(String input) {
    // Write your solution here
    if(input == null || input.length <= 1){
      return input;
    }
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');

    char[] arr = input.toCharArray();
    int left = 0;
    int right = arr.length-1;

    while(left < right){
      if(!set.contains(arr[left])){
        left++;
        continue;
      }
      if(!set.contains(arr[right])){
        right--;
        continue;
      }
      Character temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
    return new String(arr);
}
