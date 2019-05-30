# def a2_solution(n, domain):
#     '''
#     n = 8
#     domain = 4
#     conditions: ....
#     '''
#     def dfs(res, path, depth, failure_counter):
#         if depth == 8:
#             res.append(path)
#             return
#         # branching factor: 4 value in the domain
#         # depth: all variables A-H
#         for value in range(1, domain + 1):
#             if not is_valid(path):
#                 failure_counter += 1
#                 continue
#             dfs(res, path + value, depth + 1, failure_counter)
#
#     res = []
#     failure_counter = 0
#     dfs(res, [], 0, failure_counter)
#     print(res)
#     return res, failure_counter
#
# def is_valid(path):
#     a = path[0] if not path[0] else None
#     b = path[1] if not path[1] else None
#     c = path[2] if not path[2] else None
#     d = path[3] if not path[3] else None
#     e = path[4] if not path[4] else None
#     f = path[5] if not path[5] else None
#     g = path[6] if not path[6] else None
#     h = path[7] if not path[7] else None
#     return a >= g and a < h and g < h and abs(f - b) == 1 and g < h and abs(g - c) == 1 and g != f and abs(
#         h - c) % 2 == 0 and h != d and h != f and d >= g and d != c and d != f and e != c and e < d - 1 and e != h - 2 and abs(
#         e - f) % 2 == 1 and c != f

   #  res.append([a,b,c,d,e,f,g,h])

# def solution():
#     res = []
#     for a in range(1,5):
#         for b in range(1,5):
#             for c in range(1,5):
#                 for d in range(1,5):
#                     for e in range(1,5):
#                         for f in range(1,5):
#                             for g in range(1,5):
#                                 for h in range(1,5):
#                                     if a >= g and a < h and g < h and abs(f-b) == 1 and g < h and abs(g-c) == 1 and g != f and abs(h-c) % 2 == 0 and h != d and h != f and d >= g and d != c and d != f and e != c and e < d-1 and e != h-2 and abs(e-f) % 2 == 1 and c != f:
#                                         res.append([a,b,c,d,e,f,g,h])
#                                         # print(res)
#     return res, 8^4 - len(res)
#
#

def solution2():
    res = []
    counter = 0

    for f in range(1,5):
        for h in range(1,5):
            if h == f:
                counter += 1
                continue
            for c in range(1,5):
                if c == f or abs(h-c) % 2 != 0:
                    counter += 1
                    continue
                for d in range(1,5):
                    if d == f or d == c or h == d:
                        counter += 1
                        continue
                    for g in range(1,5):
                        if abs(g-c) != 1 or g == f or d < g or g >= h:
                            counter += 1
                            continue
                        for e in range(1,5):
                            if abs(e - f) % 2 == 0 or e == c or e >= d-1 or e == h-2:
                                counter += 1
                                continue
                            for a in range(1,5):
                                if a < g or a >= h:
                                    counter += 1
                                    continue
                                for b in range(1,5):
                                    if abs(f - b) != 1:
                                        counter += 1
                                        continue
                                    path = [a, b, c, d, e, f, g, h]
                                    print(path)
                                    res.append(path)

    print(counter)
    return res

def solution2_2():
    res = []
    counter = 0

    for a in range(1,5):
        for b in range(1,5):
            for c in range(1,5):
                for d in range(1,5):
                    if d == c:
                        counter += 1
                        continue
                    for e in range(1,5):
                        if e == c or e >= d-1:
                            counter += 1
                            continue
                        for f in range(1,5):
                            if abs(f - b) != 1 or d == f or abs(e-f) % 2 == 0 or c == f:
                                counter += 1
                                continue
                            for g in range(1,5):
                                if a < g or abs(g - c) != 1 or g == f or d < g:
                                    counter += 1
                                    continue
                                for h in range(1,5):
                                    if a >= h or g >= h or abs(h-c) % 2 != 0 or h == d or h == f or e == h-2:
                                        counter += 1
                                        continue
                                    path = [a,b,c,d,e,f,g,h]
                                    print(path)
                                    res.append(path)

    print(counter)
    return res

if __name__ == '__main__':
    solution2()
    #solution2_2()
