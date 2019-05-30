# check againg remove all substring(provided set) from source can produce the shortest length of the remaining string
	# //reduced s may appear before, no need to update min (dict might contain duplicate)
	# //aabcdd, (ab,cd,abcd)=>ab
def removeSubstr(input, dict):
	# for each processed string(queue), check against all substrign in the dict
	#import collections
	queue = []
	queue.append(input)
	visited = set()
	visited.add(input)
	min_len = len(s)

	while queue:
		cur = queue.pop()
		for each in dict:
			found_index = cur.index(each)
			if found_index != -1:
				new_str = cur[0,found]+cur[found+1,len(input)]
				min_len = min(min_len, len(new_str))
				queue.append(new_str)
				found = s.index(each, found+1)
				
	return min_len
