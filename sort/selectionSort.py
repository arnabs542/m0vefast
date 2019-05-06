def selectionSort(arr):
	for i in range(len(A)):  # A=[10,20,100,3, -3]  len = 5, range(5) = 0,1,2,3,4
		min_index = i  # 0 1 2 3 4
		for j in range(i + 1, len(A))
			if A[min_index] > A[j]:
				min_index = j

		# swap(A, i, min_index)
		A[i], A[min_idx] = A[min_idx], A[i]
