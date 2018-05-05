//4 numbers: -2, i, -1, j, 0, i, 1, l

//solution1:
//https://aaronice.gitbooks.io/lintcode/content/high_frequency/sort_colors_ii.html
public void sortColors2(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int i = 0;   //moving
        int min = 1;
        int max = k;
        while (min < max) {
            while (i <= right) {
                if (array[i] == min) {
                    swap(array, left++, i++);
                } else if (array[i] == max) {
                    swap(array, right--, i);
                } else {
                    i++;
                }
            }
            i = left;
            min++;
            max--;
        }
    }


//4 numbers: 0, j, 1, j, 2, k, 3
// 四种颜色的情况下可以有多种分法，根据不同的分发他们的思路也略有不同。
// aaaa | bbbb | xxxx | cccc | dddd
//       i       j   k      l
// aaaa | bbbb | cccc | xxxx | dddd
//       i      j      k    l
public int[] rainbowSortII(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int i = 0;
    int j = 0;  //moving
    int k = array.length - 1;
    while (j <= k) {
      if (array[j] == 0) {
        swap(array, i++, j++);
      } else if (array[j] == 3) {
        swap(array, j, k--);
      } else {
        j++;
      }
    }
    //000001212123
    while (i <= k) {
      if (array[i] == 1) {
        i++;
      } else {
        swap(array, i, k--);
      }
    }
    //000011112222333
    return array；
  }

private void swap(int[] array, int a, int b) {
  int temp = array[a];
  array[a] = array[b];
  array[b] = temp;
}
// 四种颜色的情况下可以有多种分法，根据不同的分发他们的思路也略有不同。
// aaaa | bbbb | xxxx | cccc | dddd
//       i       j   k      l
// aaaa | bbbb | cccc | xxxx | dddd
//       i      j      k    l
//solution2:???????????? not passing
public int[] rainbowSort4(int[] array) {
    if (array == null || array.length == 0) return array;
    // 4个挡板
    int i = 0;
    int j = 0;
    int k = 0;
    int l = array.length - 1;
    while (k <= l) {
      if (array[k] == -2)  {	//swap两次，先jk，再ij
        swap(array, j, k);
        k++;
        swap(array, i, j);
        i++;
        j++;
      } else if (array[k] == -1) {
        swap(array, j, k);
        k++;
        j++;
      } else if (array[k] == 0) {
        k++;
      } else if (array[k] == 1){
        swap(array, k, l);
        l--;
      } else {	// 检查有没有不合法的数字
        System.out.println("Input array contains invalid number(s). Program ended.");
        return new int[] {404};
      }
    }
    return array;
  }
