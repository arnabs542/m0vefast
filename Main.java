import java.util.*;
import java.lang.StringBuilder;


public class Main{
	public static void main(String[] args){
		permutations("123");
	}


	public static List<String> permutations(String set){
		List<String> res = new ArrayList<>();
		if(set == null)
			return res;
		char[] arr = set.toCharArray();
		//StringBuilder path = new StringBuilder();
		// boolean[] visited = new boolean[arr.length];
		dfs(arr, res, 0);
		System.out.print(res);
		return res;
	}
	private static void dfs(char[] arr, List<String> res, int index){
		//base case
		if(index == arr.length){
			res.add(new String(arr));
			return;
		}
		for(int i = index; i < arr.length; i++){
			swap(arr, index, i);
			dfs(arr, res,index +1);
			swap(arr, index, i);
		}
	}
	private static void swap(char[] arr, int left, int right){
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
