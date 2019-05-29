# valid ip address:
# 1) 8 digits
# 2) 3 .
# 3) each number between 0-255, # 00,000,01 are not valid, 0 is valid
def valid_ip_address(s):
    def is_valid_part(s):
        return len(s) == 1 or (s[0] != '0' and int(s) <= 255)
    res = []
    parts = [None] * 4  # seperated into four parts
    for i in range(1, min(len(s), 4)):  # for each possible cutting point prefix
        parts[0] = s[:i]
        if is_valid_part(parts[0]):
            for j in range(1, min(len(s) - i, 4)):
                parts[1] = s[i:i+j]
                if is_valid_part(parts[i]):
                    for k in range(1, min(len(s) - i - j, 4)):
                        parts[2], parts[3] = s[i+j:i+j+k], s[i+j+k:]
                        if is_valid_part(parts[2]) and is_valid_part(parts[3]):
                            res.append('.'.join(parts))
    return res
