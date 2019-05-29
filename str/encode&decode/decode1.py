# //“a1c0b2c4” → “abbcccc” 2
# //char number char number...
# //“acb2c4” → “acbbcccc” 1
# //char char char number....
def decode1(str):
  count = 0
  res = []

  for char in str:
    if letter.isdigit():
        count = count * 10 + int(char) # a12
    else:
        res.append(char * count)
        count = 0
        
    return ''.join(res)
