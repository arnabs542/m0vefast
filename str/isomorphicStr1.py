#follow up: https://www.youtube.com/watch?v=MNDOsYgVRyY
# mapping is 'a' <-> 'x', 'b' <-> 'y', 'c' <-> 'z'.
def ismorphic(s, t):
    if s is None or len(s) <= 1:
        return True
    dict = {}
    s_arr = list(s)
    t_arr = list(t)
    for index in len(s_arr):
        if s_arr[index] in dict:
            if dict[s_arr[index]] != t_arr[index]:
                return False
        else:
            if t_arr[index] in dict.values():
                return False
            else:
                dict[s_arr[index]] = t_arr[index]
    return True
