//absolute difference between nums[i] and nums[j] is at most t
//the absolute difference between i and j is at most k.
//http://wlcoding.blogspot.com/2015/05/contains-duplicate.html
// The floor(x) method returns the greatest value that is less than x.
// The ceiling(x) methods returns the least value that is greater than x. The following is an example.
// 1234: floor(3) = 5   ceiling(3) = 4
// BST + Slide Window: Time ~ O(NlogK), Space ~ O(K)
// Maintain a TreeSet (red-black tree implementation) with size K.
// For each num[i], check if there is a element in the TreeSet that is within [ num[i] - t, num[i] + t ] (using TreeSet.floor() and TreeSet.ceiling()).
// If yes, return true, since the difference between index i and all the indices within the TreeSet will not exceed t;
// If not, add num[i] to the TreeSet, and once the TreeSet exceeds its size K, we remove num[i - k],
//     which is the furthest element to num[i] (keep a sliding window containing K elements of nums).
// Note: The condition of TreeSet size exceeding K is i >= K instead of i > K.
public boolean containsDuplicate3(int[] nums, int k, int t) {
    if (k < 1 || t < 0) return false;

    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
        int c = nums[i];
        if (set.floor(c) != null && set.floor(c) >= c - t
         || set.ceiling(c) != null && set.ceiling(c) <= c + t) {
            return true;
        } else {
            set.add(c);
            if (i >= k)  set.remove(nums[i - k]);
        }
    }
    return false;
}
 //return true if and only if there are two distinct indices i and j in the array such that nums[i] = nums[j]
 // the difference between i and j is at most k.
 public boolean containsDuplicate2(int[] nums, int k) {
     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

     for(int i=0; i<nums.length; i++){
         if(map.containsKey(nums[i])){
             int pre = map.get(nums[i]);
             if(i-pre<=k)
                 return true;
         }

         map.put(nums[i], i);
     }

     return false;
 }
  public boolean containsDuplicate1(int[] nums) {
      if(nums==null || nums.length==0)
          return false;

      HashSet<Integer> set = new HashSet<Integer>();
      for(int i: nums){
          if(!set.add(i)){
              return true;
          }
      }

      return false;
  }
