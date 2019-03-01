import java.util.*;
//TODO: https://wdxtub.com/interview/14520850399861.html
//第一题是合并两个排好序的链表，合并完也必须是从小到大排序的。小土刀面经原题。
//第二题说有一排数据中心，每个数据中心链接有cost，求最小cost的链接方式把所有数据中心连起来。
// 2018-12-15

//TODO: distinct k char substirng
//leetcode 340
// 1234
// 0123
// k = 2,
// sliding window i = 0; i < 2(length-k)
public List<String> subStringLessKDist(String inputString, int num){
  if(inputString == null || inputString.length() == 0){
    return new ArrayList<>();
  }
  List<String> res = new ArrayList<>();
  int k = 0;
  int[] counter = new int[26];
  //for all substring startign from i
  for(int i = 0; i < inputString.length(); i++){
    Arrays.fill(counter, 0);
    int k = 0;
    //for all substring of i -> j
    for(int j = i; j < inputString.length(); j++){
      if(counter[charAt(j) - 'a'] == 0){
        k++;
      }
      counter[charAt(j) - 'a']++;
      if(num == k){
        res.add(inputString.substring(j, i+1));
      }
    }
  }
  return res;
}
//maximum average subtree return subtree root
//记录节点和节点个数 divide and couquer
//solution1:
public class Solution{
  class ResultType{
    int sum;
    int size;
    public ResultType(int sum, int size){
      this.sum = sum;
      this.size = size;
    }
  }
  private TreeNode subTree = null;
  private ResultType subtreeRes = null;

  public TreeNode maxAverageNode(TreeNode root){
    helper(root);
    return subtree;
  }
  private ResultType helper(TreeNode root){
    if(root == null){
      return new ResultType(0, 0);
    }
    //1) ask for left and right child with divide conquer
    ResultType left = helper(root.left);
    ResultType right = helper(root.right);
    //2) 当前层subtree结果是左右孩子和自己的值
    ResultType res = new ResultType(
      left.sum + right.sum + root.val;
      left.size + right.size + 1;
    );
    //3)一直比较
    if(subtree == null
    || subtreeRes.sum * result.size > result.sum * subtreeRes.size){
      //(subtreeRes.sum /subtreeRes.size) > (result.sum / result.size)
      subtree = root;
      subTreeRes = result;
    }
    return res;
  }
}
//solution2: k-nary tree
//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=478916
public class Solution{
  public ResultType{
    int size;
    int sum;
    Node node;
    public ResultType(int size, int sum, Node node){
      this.size = size;
      this.sum = sum;
      this.node = node;
    }
  }
  private Result res = null;
  public Node maxAverageNode(Node root){
    helper(root);
    return res.node;
  }
  private ResultType helper(Node node){
    if(node == null){
      return new ResultType(0, 0, null);
    }
    //1) what to ask for children: divide and conquer
    List<ResultType> results = new ArrayList<>();
    for(Node each : node.children){
      results.add(helper(each));
    }
    //2) current level, construct cur Result type
    int childSum = 0;
    int childSize = 0;
    for(ResultType rt : results){
      childSum += rt.sum;
      childSize += rt.size;
    }
    ResultType curResultType = new ResultType(childSum + root.value, childSize + 1, node);
    //3) update result Type to to go to parent
    if(res == null || curResultType.sum * res.size > res.sum * curResultType.size){
      //TODO: why
      if(curResultType.size > 1){
        res = curResultType;
      }
    }
    return curResultType;
  }
}

//high five: minHeap for each hasmap id
//https://yeqiuquan.blogspot.com/2017/03/lintcode-613-high-five.html
public class HighFive{
  class ProductReviewScore{
    public int productId;
    public double reviewScore;
    public ProductReviewScore(int id, double value){
      this.productId = id;
      this.reviewScore = value;
    }

  public Map<Integer, Double> calculateHighestFive(int scoreCount, ArrayList<ProductReviewScore> reviewScoresOfProduct){
    Map<Integer, Double> res = new HashMap<>();
    Map<Integer, PriorityQueue<Double>> map = new HashMap<Integer, PriorityQueue<ProductReviewScore>>();
    for(ProductReviewScore each : reviewScoresOfProduct){
      if(!map.containsKey(each.productId)){
        PriorityQueue<ProductReviewScore> minHeap = new PriorityQueue<>(5, new Comparator<ProductReviewScore>(){
          @Override
          public int compare(ProductReviewScore one, ProductReviewScore two){
            return one.value < two.value;
          }
        });
        map.put(each.productId, pq);
      }
      map.get(each.productId).offer(each);
      //top five score
      if(map.get(each).size() > 5){
        map.get(each.productId).poll();
      }
    }
    for(Map.Entry<Integer, PriorityQueue<ProductReviewScore> entry : map.entrySet()){
      //int id = entry.getKey();
      PriorityQueue<ProductReviewScore> pq = entry.getValue();
      double average = 0;
      int num = pq.size();  //in case only three exists in one studnet
      while(!pq.isEmpty()){
        average += pq.poll().reviewScore;
      }
      average /= 5;
      res.put(entry.getKey(), average);
    }
    return res;
  }
}
//closest 2 sum <=
//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=478916
public int[] 2Sum(int[] numbers, int target){
  Arrays.sort(numbers);
  int left = 0;
  int right = numbers.length-1;
  int minDiff = Integer.MAX_VALUE;
  int[] res = new int[2];
  while(l < h){
    int cur = numbers[left] + numbers[right];
    int diff = targt - cur;
    if(diff < minDiff && diff >= 0){
      minDiff = diff;
      res[0] = numbers[left];
      res[1] = numbers[right];
    }
    if(cur < target){
      left++;
    }else{
      right--;
    }
  }
  return res;
}
//maze: https://blog.csdn.net/lycorislqy/article/details/49202651
