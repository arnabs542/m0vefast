//Determine the minimum number of jumps you need to jump OUT OF the array.
// method 1 DP
public int minJump(int[] array) {
    if (array == null || array.length < 1 || array[0] == 0) {
        return -1;
    }

    if (array.length == 1) {
        return 1;
    }

    int[] M = new int[array.length];
    M[0] = 0;
    boolean flag = false;
    for (int i = 1; i < array.length; i++) {
        M[i] = Integer.MAX_VALUE;

        for (int j = 0; j < i; j++) {
            if (array[j] + j > i && M[j] != Integer.MAX_VALUE) {
                M[i] = Math.min(M[i], M[j] + 1);
                flag = false;
            }

            if (array[j] + j == i && M[j] != Integer.MAX_VALUE && array[i] != 0) {
                M[i] = Math.min(M[i], M[j] + 1);
                flag = false;
            }

            if (array[j] + j == array.length - 1 && M[j] != Integer.MAX_VALUE && array[array.length - 1] != 0) {
                M[i] = Math.min(M[i], M[j] + 1);
                flag = true;
            }

        }

    }

    if (M[array.length - 1] == Integer.MAX_VALUE) {
        return -1;
    } else if (flag) {
        return M[array.length - 1] + 1;
    } else {
        return M[array.length - 1];
    }

}
{1, 3, 2, 0, 2}, the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out)

{3, 2, 1, 1, 0}, you are not able to jump out of array, return -1 in this case.
