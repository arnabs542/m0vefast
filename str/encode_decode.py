## aabcc.  a2b1c2
def encode(str):
	res = []
	counter = 1
	for i in range(1, len(str) + 1):
		# when to appenc 
		if i == len(str) or str[i] != str[i-1]:
			res.append(str[i-1] + str(counter))
			counter = 1
		else:
			counter += 1
	return "".join(str)


# “abbcccc” 2.  - >  “a1c0b2c4” 
def encode(str):
    res = []
    count = 1
    for i in range(1, len(str)):
        if str[i] != str[i-1]:
            res.append(str(count) + s[i-1])
            count = 1
        else:
            count += 1
    return ''.join(res.append(s[i-1] + str(count)))



# // “a1c0b2c4” → “abbcccc” 2
# //char number char number...
# //abcc -> abc2
# //char char char number....
# https://www.programcreek.com/2014/09/leetcode-decode-string-java/
def encode(str):
    res = []
    count = 1
    for i in range(1, len(str)):
        if str[i] != str[i-1]:
        	if counter > 1:
        		res.append(str(count) + s[i-1])
        	else:
        		res.append(s[i-1])
            count = 1
        else:
            count += 1
    return ''.join(res.append(s[i-1] + str(count)))

# follow up question:
# https://piazza.com/class/j0eqhhdregb3i?cid=29
# // Time Complexity: O(N)O(N), where NN is the length of chars.
# // Space Complexity: O(1)O(1), the space used by read, write, and anchor.


# 1a0c2b4c 
def decode(str):
	counter = 0
	res = []

	for char in str:
		if char.isdigit():
			counter = counter * 10 + (ord(char) - ord("0"))
		else: # char 
			res.append(char * counter)
			counter = 0

	return "".join(res)

# //“a1c0b2c4” → “abbcccc” 2
def decode(str):
	counter = 0
	res = []
	pre_text = str[0]

	for char in str:
		if char.isdigit():
			counter = counter * 10 + (ord(char) - ord("0"))
		else:
			res.append(pre_text * counter)
			counter = 0
			pre_text = char
	# asusmign str ending with numb
	return "".join(res)



def decodeWay(str):

# //similar to the problem of counting ways of climbing stairs.
# // The relation is dp[n]=dp[n-1]+dp[n-2].
#     public int numDecodings(String s) {
#         if(s==null || s.length()==0 || s.charAt(0)=='0')
#             return 0;
#         if(s.length()==1)
#             return 1;
#         int[] dp = new int[s.length()]
#         //base case dp[0] and dp[1]
#         dp[0]=1;
#         if(s.charAt(1)!='0'){  //12: 1,2  or 12
#             dp[1]=2;
#         }else{     //10....: 10
#             dp[1]=1;
#         }
#         //induction rule:
#         for(int i=2; i < s.length(); i++){
#             //since a single non zero number means at least one way to decode
#             if(s.charAt(i)!='0'){
#                 dp[i] = dp[i-1];
#             }
#             //since 12 can be 1,2 and 12
#             //since 10, the last 0 is 0, but + before make it 1 for 10
#             int val = Integer.parseInt(s.substring(i-1, i+1));
#             if(val <= 26 && val >= 10){
#                 dp[i] += dp[i-2];
#             }
#         }
#         return dp[s.length()-1];
#     }
# if no check val >= 10
# 10012 should be 0 but 3
# 11000
# 1012 should be 2 but 3
# 1112






