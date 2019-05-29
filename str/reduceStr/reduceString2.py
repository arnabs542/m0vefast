def reduceString2(str):
    if str is None or not str:
        return str

    slow = 0
    counter = 1
    arr = list(str)

    for fast in range(1, len(arr)):
        if arr[slow] == arr[fast]:
            if counter < 2:
                slow += 1
                arr[slow] = arr[fast]
                counter += 1
        else:
            slow += 1
            arr[slow] = arr[fast]
            counter = 1


    return ''.join(arr[:slow+1])
