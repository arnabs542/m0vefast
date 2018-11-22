import java.util.*;
import java.lang.StringBuilder;


public class Main {
	public static void main(String[] args){
		// LinkedList;
		// System.out.println(compress(str));
		// String a = "String";
		// String b = "Stirng";
		// String c = "String";
		int d = 2;
		//int[] arr = new int[]{-1, 0, 1, 2, 3};
		int[] arr = new int[]{1,2,3,4, -1};
		int[] houses = new int[]{5, 10, 17};
		int[] stores = new int[]{1, 5, 20, 11, 16};
		//System.out.println(Arrays.toString(ancestoNode(d, arr)));
		System.out.println(Arrays.toString(houseStore(houses, stores)));
		System.out.println("should be 5 11 16");
		System.out.println(Arrays.toString(myQueue(houses, stores)));


	}
	//pai dui 
	private static int[] myQueue(int[] a, int[] b){

	}
	//ancestor node
	private static int[] ancestoNode(int d, int[] arr){
		  int n = arr.length;
		  int[] res = new int[n];
		  if(arr == null || n == 0){
		    return res;
		  }
		  if(d == 0){
		    return arr;
		  }
		  for(int i = 0; i < n; i++){
		    int parent = i;
				for(int j = d; j > 0; j--){
					if(parent == -1){
		         res[i] = -1;
				     break;
		      }else{
		         parent = arr[parent];
		      }
				}
		    res[i] = parent;
		  }
		  return res;
		}

		//house and store
		private static int[] houseStore(int[] houses, int[] stores){
			int[] res = new int[houses.length];
			if(houses == null || stores == null){
				return res;
			}
			Arrays.sort(stores);
			System.out.println("after sorting stores:" + Arrays.toString(stores));
			System.out.println("houses are:" + Arrays.toString(houses));
			//for each house, binary search find  closest stores
			for(int i = 0; i < houses.length; i++){
				int target_house = houses[i];
				res[i] = closeToTargetHouse(target_house, stores);
			}
			return res;
		}
		private static int closeToTargetHouse(int target_house, int[] stores){
			//int target_house = houses[i];
			int left = 0;
			int right = stores.length-1;
			while(left + 1 < right){
					int mid = left + (right - left)/2;
					if(stores[mid] == target_house){
						return stores[mid];
					}else if(stores[mid] < target_house){
						left = mid;
					}else{
						right = mid;
					}
			}
			if(Math.abs(stores[left] - target_house) <= Math.abs(stores[right] - target_house)){
				return stores[left];
			}else{
				return stores[right];
			}
		}

}
