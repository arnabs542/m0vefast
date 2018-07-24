//quick select: O(n) O(1)  usde for kth smallest elemtn
// https://stackoverflow.com/questions/8783408/why-is-the-runtime-of-the-selection-algorithm-on
//https://www.geeksforgeeks.org/quickselect-algorithm/
public int kthLargestElement(int k, int[] nums) {
        // write your code here
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int pivot = nums[high];
            int index = low-1;
            for(int i = low; i < high; i++){
                //larger element on left
                if(nums[i] > nums[high]){
                    swap(nums, i, ++index);
                }
            }
            //larger_vlaue, pivot, small_value
            swap(nums, ++index, high);
            if(index == k - 1){
                return nums[index];
            }
            if(index < k -1){
                low = index + 1;
            }else{
                high = index - 1;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
//solution using heap: O(nlogk) running time + O(k) memory
在数字集合中寻找第k大，可以考虑用Max Heap，将数组遍历一遍，加入到一个容量为k的PriorityQueue，
最后poll() k-1次，那么最后剩下在堆顶的就是kth largest的数字了。
public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k == 0) {
            return -1;
        }
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
       PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
       for (int num : nums) {
           q.offer(num);
           if (q.size() > k) {
               q.poll();
           }
       }
       return q.peek();
   }
