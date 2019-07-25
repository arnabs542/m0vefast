'''
Write a function to generate the generalized abbreviations of a word.

Note: The order of the output does not matter.

Example:

Input: "word"
Output:
["word", "1ord", "w1rd", "wo1d", "wor1",
    "2rd", "w2d", "wo2",
    "1o1d", "1or1", "w1r1",
    "1o2", "2r1",
    "3d", "w3",
    "4"]
从字符串的第一个字符开始，依次搜索该字位符 进行和 不进行缩写操作后可能的情况，直到搜索至最后一位。
题目老
'''
def generateAbbreviation(s):
