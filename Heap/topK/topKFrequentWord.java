public String[] topKFrequent(String[] combo, int k) {
	if(combo.length == 0)
	//notice there is a 0 inside for new String!!!
		return new String[0];
	//build map: {string, count}
	Map<String, Integer> map = new HashMap<>();
	for(String str : combo){
		map.put(str, map.getOrDefault(each, 0) + 1);
	}
	//build minheap
	ProrityQueue<Map.Entry<String, Integer>> minHeap = new ProrityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
		@Override
		public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
			//to use compareTo inside for object
			if(a.getValue() == b.getValue()){
				return b.getKey().compareTo(a.getKey());
			}
			return a.getValue().compareTo(b.getValue());
			//https://www.javacodegeeks.com/2013/03/difference-between-comparator-and-comparable-in-java.html
		}
	});
	//notice countMap.entrySet()
	for(Map.Entry<String, Integer> entry : map.entrySet()){
		minHeap.offer(entry.getKey());
		if(minHeap.size() >  k){
			minheap.poll();
		}
	}
	//get result
	while(!minHeap.isEmpty()){
		res.add(0, minHeap.poll().getKey());
	}
	return res;
}
static class MyComparator implements Comparator<Map.Entry<String, Integer>>{
        @Override
        public int compare(Map.Entry<String, Integer> one, Map.Entry<String, Integer> two){
            if(one.getValue() == two.getValue()){
                return two.getKey().compareTo(one.getKey());
            }
            return one.getValue() - two.getValue();
        }
    }
//sort business by rating
public static List<BusinessInfo> sortBusinessesByRating(List<BusinessInfo> businesses){
        List<BusinessInfo> sortedBusinesses = new ArrayList<BusinessInfo>();
        HashMap<Integer,List<Integer>> ratingToIds = new HashMap<Integer,List<Integer>>();

        for (BusinessInfo business: businesses) {
            if (ratingToIds.containsKey(business.rating))
                ratingToIds.get(business.rating).add(business.id);
            else {
                ratingToIds.put(business.rating, new ArrayList<Integer>());
                ratingToIds.get(business.rating).add(business.id);
            }
        }

        SortedSet<Integer> ratings = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        ratings.addAll(ratingToIds.keySet());
        for (Integer rating: ratings) {
            for (Integer _id: ratingToIds.get(rating))
                sortedBusinesses.add(new BusinessInfo(_id, rating));
        }

        return sortedBusinesses;
    }
