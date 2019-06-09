def canFinish(numCourses, prerequisites):
    # build map to calcuate indegree
    m = {x: 0 for x in range(numCourses)}
    for each in prerequisites:
        if each[0] in m:
            m[each[0]] += 1
        else:
            m[each[0]] = 1
    # print(m)
    res = []
    # maintain queue
    # initlaizationm
    from collections import deque
    queue = deque([k for k, v in m.items() if v == 0])

    while queue:
        # expnd
        base = queue.popleft()
        res.append(base)

        # generate
        for each in prerequisites:
            if each[1] == base:

                m[each[0]] -= 1
                # print("cur dict is  {}".format(m))
                if m[each[0]] == 0:
                    queue.append(each[0])
    return res if len(res) == numCourses else []
