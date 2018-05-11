import java.util.*;
import java.lang.StringBuilder;


public class Main{
	public static void main(String[] args){
		String str = "abbcccdeee";
		System.out.println(compress(str));
	}
	public static String compress(String str) {
		//char[] arr = str.toCharArray();
		String res = "";
		char prev = 0;
		char cur = 0;
		int count = 0;
		for(int i = 0 i < str.length(); i++){
			if(i == 0){
				prev = cur = str.CharAt(i);
			}
			cur = str.CharAt();
			if(prev != cur){

				res += prev + count;
				count = 1;
			}else{
				count++;
			}
			prev = cur;
		}
		res += prev + count
		return str;

  }




}
