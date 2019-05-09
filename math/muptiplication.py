def multiplication(num1, num2):
    sign = -1 if (num1[0] < 0) ^ (num2[0] < 0) else 1   #  ^ XOR
    # if num1[0] < 0 ^ num2[0] < 0:
    #    sign = -1
    #else:
    #    sign = 1
    num1[0], num2[0] = abs(num1[0]), abs(num2[0])   #num1[0]: -1

    res = [0] * (len(num1) + len(num2))    # initialize [0,0,0,0...0]
                                           # mupliply result max lenght will be m + n
    for i in reversed(range(len(num1))):
        for j in reversed(range(len(num2))):
            res[i+j+1] += num1[i] * num2[j]
            res[i+j] += res[i+j+1] // 10
            res[i+j+1] %= 10

    # remove leading Zero
    # next() return the next item in an iterator
    # next(some_condition)
    # next(iterable_item_condition, default_if_reach an end)
    res = res[next((i for i, x in enumerate(res) if x !=0), len(res)):] or [0]
    '''
    In [235]: res
    Out[235]: [0, 0, 0, 0, 0]

    In [236]: res = res[next((i for i, x in enumerate(res) if x != 0), len(res)):]

    In [237]: res
    Out[237]: []
    '''
    return [sign * res[0]] + res[1:]
    # the same res use + :    [first element] + [rest element]
