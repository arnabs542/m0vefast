def smallest_nonconstructiable_value(A):
    max_construct_value = 0
    for each in sorted(A):
        if each > max_construct_value + 1:
            break
        max_construct_value += each

    return max_construct_value + 1

    #<12,2,1,15,2,4>.  1, 2, 2, 4, 12, 15
    # return 10
