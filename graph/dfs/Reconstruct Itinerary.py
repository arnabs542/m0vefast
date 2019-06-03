'''

Given a list of objects in the form of "source : destination", each representing a leg of a trip, give the output of the trip itinerary.
# Reconstruct Itinerary https://leetcode.com/problems/reconstruct-itinerary/
[
{"YVR:SFO"},
{"YYZ:NYC"},
{"SFO:YYZ"}
]

Output: [YVR, SFO, YYZ, NYC]
'''
def findItinerary(self, tickets: List[List[str]]) -> List[str]:
    # edge representation like graph valid tree 1) build graph 2) find a path
    destination = collecitons.defaultdict(list)
    for f, t in tickets:
        destination[f] += t

    res = []
    self.dfs(destination, 'jfk')
    return res[::-1]

def dfs(self, from):
    for each_to in destination[from]:









    def findItinerary(self, tickets):
        targets = collections.defaultdict(list)
        for a, b in sorted(tickets)[::-1]:
            targets[a] += b,
        route = []

        def dfs(airport):
            while targets[airport]:
                dfs(targets[airport].pop())
            route.append(airport)

        dfs('JFK')
        return route[::-1]
