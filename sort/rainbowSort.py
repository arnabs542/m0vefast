def rainbowsort(self, nums:List[int]) -> None:
    """
    input: int[] array
    return: int[]
    """
    # write your solution here
    if not array:
      return array

    left = 0
    i = 0
    right = len(array)-1

    while i <= right:
      if array[i] == -1:
        array[i], array[left] = array[left], array[i]
		# self.swap(array, i, left)
        i+=1
        left+=1
      elif array[i] == 0:
        i+=1
      else:
        array[i], array[right] = array[right], array[i]
        right-=1
    return array

def swao(self, arr, i, left):
	array[i], array[left] = array[left], array[i]
