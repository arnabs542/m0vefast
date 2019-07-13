# https://leetcode.com/problems/cheapest-flights-within-k-stops/
def findCheapestPrice(n, flights: List[List[int]], src, dst, K):
    graph = collections.defaultdict(dict)
    for start, end, weight_from_src in flights:
        graph[start][end] = weight_from_src

    minheap = [(0, src, K+1)]  # allow K+1 edges/steps
    while minheap:
        weight_from_src, node, step = heapq.heappop(minheap)
        if node = dst:
            return weight_from_src
        if step > 0:
            for nei in graph[node]:
                heapq.heappush(minheap, (weight_from_src + graph[node][nei], nei, step-1))

    return -1
