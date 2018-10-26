//quick select: O(n) O(1)  usde for kth smallest elemtn
// https://stackoverflow.com/questions/8783408/why-is-the-runtime-of-the-selection-algorithm-on
//https://www.geeksforgeeks.org/quickselect-algorithm/
public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - k;
        while (start < end) {
            int pivot_index = partition(nums, start, end);
            if (pivot_index < index)
                start = pivot_index + 1;
            else if (pivot_index > index)
                end = pivot_index - 1;
            else
                return nums[pivot_index];
        }
        return nums[start];
    }
    //using recursiion
    //https://www.geeksforgeeks.org/quickselect-algorithm/
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length-1, k);
    }
    private int findKthLargest(int arr[], int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int index = partition(arr, l, r);
            if (index - l == k - 1)
                return arr[index];
            else if (index - l > k - 1)
                return kthSmallest(arr, l, index - 1, k);
            else
              return kthSmallest(arr, index + 1, r, k - index + l - 1);
        }
        return INT_MAX;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot_index = right;
        int pivot_value = arr[pivot_index];
        int i = left;
        int j = right-1;
        while(i <= j){
            if(arr[i] < pivot_value)
                i++;
            else if(arr[j] > pivot_value)
                j--;
            else
                swap(arr, i, j--);
        }
        swap(arr, i, pivot_index);
        return i;

    }
    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
//solution using heap: O(nlogk) running time + O(k) memory
将数组遍历一遍，加入到一个容量为k的PriorityQueue，
最后poll() k-1次，那么最后剩下在堆顶的就是kth largest的数字了。
public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k == 0) {
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, Collecitons.reverseOrder());
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        for (int j = 0; j < k - 1; j++) {
            heap.poll();
        }
        return heap.peek();
    }
建立一个min-heap。过一遍数组把每个数字往里面扔。如果超过k个，就扔出来一个。
最后里面剩下k个最大的。头上这个就是第k大。
public int kthLargestElement2(int[] nums, int k) {
       // Write your code here
       PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
       for(int i = 0; i < k; i++){
         minHeap.offer(arr[i]);
       }
       for(int i = k; i < arr.length; i++){
         if(arr[i] > minHeap.peek()){
           minHeap.poll();
           minHeap.offer(arr[i]);
         }
       }
       return minHeap.peek();
   }
