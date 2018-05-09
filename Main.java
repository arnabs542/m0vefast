import java.util.*;
import java.lang.StringBuilder;


public class Main{
	public static void main(String[] args){
		String str = "i love     yahoo";
		//char[] arr = str.toCharArray();
    reverseWords(str);
		//System.out.print(str);
	}
	public static String reverseWords(String input) {
	if(input == null || input.length() <= 1)
	      return input;
	    char[] arr = input.toCharArray();
	    int start = 0;
			//reverse each word=> i evol     oohay
	    //reverse(arr, 0, arr.length -1);
	   	for(int i = 0; i < arr.length; i++){
	    //start index of a word
	      if(arr[i] != ' ' && (i == 0 || arr[i-1]== ' '))
	         start = i;
	      //end index of a word
	      if(arr[i] != ' ' && (i == arr.length -1 || arr[i+1] == ' '))
	        reverse(arr, start, i);
	    }
			//System.out.println(arr);
	    reverse(arr, 0, arr.length -1);
			//reverse the senctence => i yahoo     love i
			//System.out.println(arr);
	    return new String(arr);
	  }

  private static void reverse(char[] arr, int left, int right){
  	while(left < right){
			swap(arr, left, right);
	    reverse(arr, left + 1, right-1);
		}
  }
  private static void swap(char[] arr, int left, int right){
  	char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }





}
