public String[] topKFrequent(String[] combo, int k) {
	if(combo.length == 0)
	//notice there is a 0 inside for new String!!!
		return new String[0];
	//{string, count}
	HashMap<String, Integer> countMap = buildMap(combo);
	//compare how to wirte comparator for maxHeap
	// PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
 //    	@Override
 //    	public int compare(Integer o1, Integer o2){
 //    		if(o1.equals(o2))
 //    			return 0;
 //    		return o1 > o2? -1 : 1;
 //    	}
    //});
	ProrityQueue<Map.Entry<String, Integer>> minHeap = new ProrityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
		@Override
		public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
			//to use compareTo inside for object
			return a.getValue().compareTo(b.getValue());
		}
	});
	//notice countMap.entrySet()
	for(Map.Entry<String, Integer> entry : countMap.entrySet()){
		if(minHeap.size() < k)
			minHeap.offer(entry);
		else if(entry.getValue() > minHeap.peek().getValue()){
			minHeap.poll();
			minHeap.offer(entry);
		}
	}
	return countArr(minHeap);
}
private Map<String, Integer> buildMap(String[] combo){
	Map<String, Integer> countMap = new HashMap<>();
	for(String s : combo){
		Integer count = countMap.get(s);
		if(count == null)
		//if(!countMap.containsKey(s))
			countMap.put(s, 1);
		else
			countMap.put(s, count+1);
	}
	return countMap;
}
private String[] countArr(ProrityQueue<Map.Entry<String, Integer>> minHeap){
	String[] res = new String[minHeap.size()];
	for(int i = minHeap.size()-1; i>=0; i--)
		res[i] = minHeap.poll().getKey();
	return res;
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
