'''
concurrency, algorithms, and networking, and a coding challenge.
Interview Questions:
Explain the Actor model of concurrency.
Explain what happens from the event a user enters a URL in a browser to the rendering of the screen.
Given a list of objects in the form of "source : destination", each representing a leg of a trip, give the output of the trip itinerary.
# Reconstruct Itinerary https://leetcode.com/problems/reconstruct-itinerary/
[
{"YVR:SFO"},
{"YYZ:NYC"},
{"SFO:YYZ"}
]

Output: [YVR, SFO, YYZ, NYC]
 resumé, and then spent about 20 minutes working on the technical question they gave me.
 String manipulation questions
Write code in Java or Scala to figure out whether oor not a given string is a palindrome
parse a string containing particular type of expression presented then.
Given a sentence as a string, reverse each word's characters and return the whole sentence as a character array.
Q: Does your current job use an Agile methodology for software development?
Random number generators to create a distribution graph
Explain MVC.
'''
# string palindrome:
def isPalindrome(self, s):
        start, end = 0, len(s) - 1
        while start < end:
            while start < end and not s[start].isalpha() and not s[start].isdigit():
                start += 1
            while start < end and not s[end].isalpha() and not s[end].isdigit():
                end -= 1
            if start < end and s[start].lower() != s[end].lower():
                return False
            start += 1
            end -= 1
        return True

def isPalindrome(str):
    str = re.sub('[^0-9a-zA-Z]', '', str).lower()
    left, right = 0, len(str) - 1
    while left < right:
        if str[left] != str[right]:
            retur false
        left += 1
        right -= 1
    retur True

def is_palindrome2(str):
    return str


parse a string with particular type of excpression

# i love yahoo
# handong leading and ending white space
def reverseStringInSentence(str):
    if str is None or not str:
        return str
    removeSpace(str)
    str.reverse()

    left = 0
    right = str.find(' ')
    while right != -1:

        reverseRange(str, left, right-1)
        left = right+1
        right = str.find(' ', left)

def reverseRange(str, left, right):
    while left < right:
        str[left], str[right] = str[right], str[left]

def removeSpace(str):
    slow = 0
    fast = 0
    for fast in range(len(str)):
        if str[fast] == ' ' and (fast = 0 or arr[fast-1] == arr[fast]):
            fast += 1
        else:
            arr[slow] = arr[fast]
            fast += 1
            slow += 1

    if slow  > 0 and arr[slow-1] == ' ':
        return ''.join(arr[:slow-1])
    return ''.join(arr[:slow])





random number generation
