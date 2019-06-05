from Queue import PriorityQueue
class Solution(object):
  def merge(self, arrayOfArrays):
    """
    input: int[][] arrayOfArrays
    return: int[]
    """

    res = []
    minheap = PriorityQueue()

    for index, arr in enumerate(arrayOfArrays):
      if len(arr):
        minheap.put((arr[0], index, 0))

    while not minheap.empty():
      value, row, col = minheap.get()
      res.append(value)
      if col+1 < len(arrayOfArrays[row]):
        minheap.put((arrayOfArrays[row][col+1], row, col+1))

    return res


In [190]: matrix = [[1,2,3],[4,5,6],[7,8,9]]

In [191]: matrix[0]
Out[191]: [1, 2, 3]

In [192]: matrix[1]
Out[192]: [4, 5, 6]

In [193]: matrix[2]
Out[193]: [7, 8, 9]
