//A1 = {2, 1, 2, 5, 7, 1, 9, 3}, A2 = {2, 1, 3},
//A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}
public class Solutiohn{
	//nested static class inside solution
	static class MyComparator implements Comparator<Integer>{
		private Map<Integer, Integer> map;
		public MyComparator(int[] arr){
			map = new HashMap<>();
			for(int i= 0; i < arr.length; i++){
				//(value, relative index order)
				map.put(arr[i], i);
			}
		}
		@Override
		public int compare(Integer i1, Integer i2){
			Integer index1 = map.get(i1);
			Integer index2 = map.get(i2);
			//elements in 1 exists in 2, compare relative order according to 2
			if(index1 != null && index2 != null)
				return index1.compareTo(index2);
			//elements in 1 doesnt exists in 2, compare strict element
			else if(index1 == null && index2 == null)
				return i1.compareTo(i2);
			//the existing number has priority,
			return index1 != null ? -1 : 1;
		}
	}
	public int[] sortSpecial(int[] arr1, int[] arr2){
		Integer[] refArr = toIntegerArray(arr1);
		//sort array by specific order
		Arrays.sort(refArr, new MyComparator(arr2));
		toIntArray(refArr, arr1);
		return arr1;
	}
	private Integer[] toIntegerArray(int[] arr){
		Integer[] res = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++){
			res[i] = arr[i];
		}
		return res;
	}
	private void toIntArray(Integer[] arr, int[] res){
		for(int i = 0; i < arr.length; i++){
			res[i] = arr[i];
		}
	}
}
