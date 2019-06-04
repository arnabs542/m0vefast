'''
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
# similar to substring anagram
- hashmap {target_char : counter}
return the res instead of left window index

'''

def minWindowSubstr(source, target):
