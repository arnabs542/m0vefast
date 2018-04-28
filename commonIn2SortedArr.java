//solution1: 2 pointers
public List<Integer> common(List<Integer> A, List<Integer> B) {
   List<Integer> res = new ArrayList<>();
   int i = 0;
   int j = 0;
   while(i < A.size() && j < B.size()){
   	if(A.get(i) == B.get(j)){
   		res.add(A.get(i));
   		i++;
   		j++;
   	}else if(A.get(i) < B.get(i)){
   		i++;
   	}else{
   		j++;
   	}
   }
   return res;
}
//solution2: hashmap
public List<Integer> common(List<Integer> A, List<Integer> B) {
   List<Integer> res = new ArrayList<>();
   //{number, count}
   HashMap<Integer, Integer> mapA = new HashMap<>();
   for(int number : A){
   		Integer count = mapB.get(number);
   		if(count != null)
   			mapA.put(number, count+1);      
   	 	else
   			mapA.put(number, 1);
   }
   HashMap<Integer, Integer> mapB = new HashMap<>();
   for(int number : B){
   		Integer count = mapB.get(number);
   		if(count != null)
   			mapB.put(number, count+1);      
   	 	else
   			mapB.put(number, 1);
   }
   for(Map.Entry<Integer, Integer> entry : mapA.entrySet()){
   		Integer countInB = mapB.get(entry.getKey());
   		if(countInB != null){
   			int appear = Math.min(entry.getValue(), countInB);
   			for(int i = 0; i < appear; i++){
   				res.add(entry.getKey());
   			}
   		}
   }
   return res;
}
