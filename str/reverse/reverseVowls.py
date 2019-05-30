def reverseVowls(input):
    if input is not None or not input:
        return input
    visited = set('a', 'e', 'i', 'o', 'u')
    left = 0
    right = len(input) - 1
    arr = list(input)

    while left < right:
        if arr[left] not in visited:
            left += 1
            continue
        if arr[right] not in visited:
            right -= 1
            continue
        arr[left], arr[right] = arr[right], arr[left]
        left += 1
        right -= 1

    return ''.join(arr)
