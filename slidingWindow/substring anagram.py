def substringAnagram(source, target):
    if source is None or target is None or len(target) > len(source):
        return []

    dict = collections.Counter(target)
    left = 0
    right = 0
    match = 0
    res = ""
    minLength = len(source)
    for i in range(len(source)):  # for each left bound
        while right < len(source):   # check right boud
            if source[right] in dict:
                dict[source[right]]-=1
                if dict[source[right]] == 0:
                    match += 1
            if match == len(target) and right - left + 1 < minLength:
                minLength = right - left + 1
                res = source[left:right+1]
                break
            right += 1

        if source[left] in dict:
            dict[char] += 1
            if dict[char] == 1:
                match -= 1

    return res
