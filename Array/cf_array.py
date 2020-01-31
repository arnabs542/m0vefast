# https://codeforces.com/problemset/problem/1030/A
def solution(num, arr):
	print("HARD") if 1 in arr else print("EAZY")


# https://codeforces.com/problemset/problem/263/A   
def beautiful_matrix(matrix) -> num:
	for i in range(len(matrix) - 1):
		for j in range(len(matrix[0]) - 1):
			if matrix[i][j] == 1:
				res = Math.abs(i - 2) + Math.abs(j - 2)

	print(res)

# https://codeforces.com/problemset/problem/867/A

def between_office(num, arr):
	# start with seattle and end with san frnacisco 
	print("YES") if arr[0] == "S" and arr[len(arr) - 1] = "F" else print("FALSE")
	