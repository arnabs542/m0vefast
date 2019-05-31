# Given a string, determine if a permutation of the string could form a palindrome.
# 记录下字符串中每种字符出现的次数，当有2种及以上的字符出现了奇数次时，答案为false,否则答案为true
def canPermutePalindrome(self, str):
    count = collections.Counter(s)
    odd_counter = 0
    for value in count.values():
        if value % 2 != 0:
            odd_counter += 1
    return True if odd_counter <= 1 else False

    # return sum(value % 2 for value in collections.Counter(s).values()) < 2


def canPermutePalindrome(self, str):
    dict = {}
    for each in str:
        if each in dict:
            dict[each] += 1
        else:
            dict = 1
    for char, freq in dict.items():
        # do sth
