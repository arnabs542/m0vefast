public int minLength(String s, Set<String> dict) {
	Queue<String> queue = new LinkedList<>();
	Set<String> visited = HashSet<>();
	//reduced s may appear before, no need to update min (dict might contain duplicate)
	//aabcdd, (ab,cd,abcd)=>ab

	int min = s.length();
	queue.offer(s);
	visited.add(s);

	while(!queue.isEmpty()){
		s = queue.poll();
		for(String each : dict){
			int found = s.indexOf(each);
			while(found != -1){
				String new_s = s.substring(0, found) + s.substring(found + each.length(), s.length());
				if(!visited.contains(new_s)){
					if(new_s.length() < min)
						min = new_s.length();
					queue.offer(new_s);
					visited.add(new_s);
				}
				//continue to check the rest for this dict.each
				found = s.indexOf(each, found+1);
				//Returns the index within this string of the first occurrence of
				//the specified substring, starting at the specified index.
			}
		}
	}
	return min;
}
