# 1. Reverse the entire string.
# 2. Reverse each word.
# 3. Deduplicate spaces.

# can not handle leading and tail white space
def ilovegoogle(str):
    # step1: reverse string
    str.reverse()

    # reverse each substring
    start = 0
    while True:
        end = s.find(' ', start)  # find the first index starting frog the "start" index
        if end < 0:
            break
        reverse(str, start, end-1)
        start = end + 1
    # step2: reverse last words
    reverse(str, start, len(str)-1)

def reverse_range(s, start, end):
    while start < end:
        s[start], s[end] = s[end], s[start]
        start += 1
        end -= 1
