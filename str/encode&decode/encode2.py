# aabcc   a2b1c2
def encode(str):
    res = []
    count = 1
    for i in range(1, len(s) + 1):
        if i == len(s) or s[i] != s[i-1]:
            res.append(str(count) + s[i-1])
            count = 1
        else:
            count += 1
    return ''.join(res)

def encode(str):
    res = []
    count = 1
    for i in range(1, len(str)):
        if str[i] == str[i-1]:
            res.append(str(count) + s[i-1])
            count = 1
        else:
            count += 1
    return ''.join(res.append(str(count) + s[i-1]))
