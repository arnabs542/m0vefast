//k numbers
//soluiton1 //https://aaronice.gitbooks.io/lintcode/content/high_frequency/sort_colors_ii.html
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

//solution2
// 其实还可以每次sort 两个 color, 把 sort k colors 问题转化成 k/2个 sort two colors 的问题。
// 假设 k 个 color 分别用1, 2, ..., k 个数来表示，每一次可以 sort其中的一对：<1, k>, <2, k-1>, ...
// Time = O(nk/2) = O(nk)
// Space = O(1)
//https://piazza.com/class/j0eqhhdregb3i?cid=436

public int[] rainbow(int[] array, int k) {
        if (array == null || array.length < 2) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        for (int round = 1; round <= k / 2; round++) {
            // since leftColor + rightColor == k + 1
            int leftColor = round;
            int rightColor = k + 1 - round;
            for (int i = left; i <= right; i++) {
                if (array[i] == leftColor) {
                    swap(array, i, left++);
                } else if (array[i] == rightColor) {
                    //i-- here since this is a for-loop, will increment automatically
                    swap(array, i--, right--);
                    //i-- to avoid autoincrement to missing a target
                }
            }
        }
        return array;
    }
