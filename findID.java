/*
题目： 给一个 bussinessInfo 的类，里面有id 和catagory, 是这样： class bussinessInfo{int id, String catagory}
. from:  
输入： 101 japanese, sushi, resturant
           102 japanese, seafood
           103 japanese, resturant, ramen

输出： 101, 103 即找出所有的id 即是 japanese 又是resturant.
*/
public List<Integer> findId(List<BusinessInfo> list){
	List<Integer< res = new ArrayList<>();
	for(BusinessInfo bus : list){
		String str = bus.category;
		List<String> categories = Arrays.asList(str.replaceAll("\\s+", "").split(","));
		if(categories.contains("japanese") && categories.contains("resturant")){
			res.add(bus.id);
		}
	}
	return res;
}