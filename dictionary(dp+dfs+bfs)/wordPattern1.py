'''
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
'''
def wordPattern1(pattern, str):
    if len(pattern) != len(str.split(" ")):
        return False
    str = str.split(" ")
    mapping = {}
    for i in range(len(pattern)):
        p = pattern[i]
        s = str[i]
        if p not in mapping:
            if s in mapping.values():
                return False
            else:
                mapping[p] = s
        else:
            if mapping[p] != s:
                return False
    return True
