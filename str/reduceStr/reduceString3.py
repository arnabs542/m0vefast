def reduceString3(str):
    if str is None and not str:
        return []

    slow = 0
    # fast = 1
    seen = False
    arr = list(str)

    for fast in range(1, len(arr)):
        # same
        if arr[slow] = arr[fast]:
            seen = True
        # not same, seen (overwirte)
        elif seen:
            arr[slow] = arr[fast]
            seen = False
        # not same, not seen
        else:
            arr[slow] = arr[fast]
            slow += 1

    return ''.join(arr[:slow+1 if not seen else slow])
