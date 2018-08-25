// A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
// A Bitonic Point ( maximum element in the given bitonic array)is a point in bitonic sequence before which elements are strictly increasing and after which elements are strictly decreasing.
https://www.geeksforgeeks.org/find-element-bitonic-array/
public int search(int[] arr, int target) {
    // Write your solution here
    if (arr == null || arr.length <= 0)
        return -1;
    int index = findLargest(arr, 0, arr.length - 1);
    if (target > arr[index]) //greater than bitonic point
        return -1;
    else if (target == arr[index])
        return index;
    else {
        int temp = ascendingBinarySearch(arr, 0, index - 1, target);
        if (temp != -1) {
            return temp;
        } else {
            return descendingBinarySearch(arr, index + 1, arr.length - 1, target);
        }
    }
}

private int findLargest(int[] array, int left, int right) {
    //only one element
    if (left == right) {
        return left;
    }
    //only two element
    if (left + 1 == right) {
        return array[left] >= array[right] ? left : right;
    }
    int mid = left + (right - left) / 2;
    // if (mid == array.length - 1) {
    //     return -1;
    // }
    if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) { // the peak
        return mid;
    } else if (array[mid] > array[mid - 1]) {
        // peak on the mid right side
        return findLargest(array, mid, right);
    } else {
        return findLargest(array, left, mid - 1);
    }
}


// Function for binary search in ascending part
private int ascendingBinarySearch(int arr[], int low,
    int high, int key) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[mid] > key)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return -1;
}

// Function for binary search in descending part of array
int descendingBinarySearch(int arr[], int low,
    int high, int key) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[mid] < key)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return -1;
}
