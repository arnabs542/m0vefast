// Given [1, 3, 3, 3, 5, 5, 7], and target value 3,
// return [1, 3]. , find the starting and ending position of a given target value.
public int[] searchRange(int[] A, int target) {
        if (A.length == 0) {
            return new int[]{-1, -1};
        }

        int start, end, mid;
        int[] bound = new int[2];

        // search for left bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] >=  target) {
                end = mid;
            } else{
                start = mid;
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {  //no exist
            bound[0] = bound[1] = -1;
            return bound;
        }

        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        // } else {
        //     bound[0] = bound[1] = -1;
        //     return bound;
        // }

        return bound;
    }
