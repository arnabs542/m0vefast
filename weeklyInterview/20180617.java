Q: why to use hashmap:
Minimize input domain: from 1-1000 to 1-10, module 100, there might be collision, Collision 2 ways:
Reduce collision as much as possible to make it evenly distributed, hashing value is not unique in this case

Hashing function: depends on input domain(ask interviewer),
Eg: if ending all with 1, 11, 11111, 111111, most will collision in 1 if modular 10
Eg: 1 million - 1 billion, choose modular 1 million
When doing time analysis, say assuming input domain is evenly distributed, then reading map is constant * factor(chaining) under average case, worse condition is when all collision, then n


Consider an array of n integers, numbers. We define a non-unique value of numbers to be an integer that appears at least twice in the array. For example, if numbers = [1, 1, 2, 2, 2, 3, 4, 3, 9], then there are a total of 3 non-unique values in the array (i.e., 1, 2, and 3).

Complete the countDuplicates function in the editor below. It has 1 parameter: an array of integers, numbers. It must return an integer denoting the number of non-unique values in the numbers array
Constraints
• 1 ≤ n ≤ 1000
1 ≤ numbersi ≤ 1000


public List<Integer> countDuplicates(int[] arr){
    if(arr == null || arr.length == 0){
        return 0;
    }
    Map<Integer, Integer> map = countMap(arr);
    List<Integer> res = new ArrayLsit<>();
    for(<Map.Entry<Integer, Integer> entry : map.entrySet()){
        if(entry.getValue() > 1){
            res.add(entry.getKey());
        }
    }
    return res;
}
//TODO
private Map<Integer, Integer> countMap(int[] arr){
    Map<Integer, Integer> map = new MyMap<>();
    for(Integer each : arr){
        if(!map.containKey(each)){
            map.put(each, 1);
        }else{
            map.put(each, map.get(each)+1);
        }
    }
    return map;
}
class MyMap extends HashMap<Integer, Integer>{
    @Override
    public int hashing(Integer i){
        return I;   //the perfect hashing
    }
}


Such hashing function is only good for input domain is not sparse(分散)
Other hashing function can be number 1000, good for input domain from 1000-1001
