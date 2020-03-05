# solution: recursion on each string
# 2276696 -> XXXXXX
def phone_number(phone_number):
    mapping = ['0', '1', 'ABC', 'DEF', 'GHI', 'JKI', 'MNO', 'PQRS', 'TUV', 'WXYZ']
    def helper(index):
        if index == len(phone_number):
            res.append(''.join(partial))
        else:
            for char in mapping[int(phone_number[index])]:
                partial[index] = char
                helper(index + 1)
        # option: each char of a phone digit
        # depth: each phone numher digit
    res = []
    partial = [0] * len(phone_number)
    helper(0)
    return res
