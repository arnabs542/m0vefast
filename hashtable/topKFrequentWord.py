def topKFrequentWords1(words, k):
	if words is None or not words:
		return []
	# HashMap
	import collections
	dict = {}
	for each in words:
		if each not in dict:
			dict[each] = 1
		else:
			dict[each] += 1
	# priortyqueue
	minheap = []
	for key, value in dict.items():
		heapq.heappush(minheap, (-value, key))

	while k > 0:
		value, key = heapq.heappop(minheap)
		res.append(key)
	return res


	####### shorter version pythonic 
	counter = collections.Counter(words)
	pq = [(-freq, text) for text, freq in counter.items()]
	heqpq.heapify(pq)
	return [heapq.heappop(pq)[1] for _ in range(k)]



# sort business by rating
def sortBusinessesByRating(businesses):
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
