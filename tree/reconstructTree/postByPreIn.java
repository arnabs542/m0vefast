public int[] postOrder(int[] pre, int[] in) {
  int[] post = new int[in.length];
  return helper(pre, 0, in, 0, in.length-1, post, 0);
}
private int[] helper(int[] pre, int preIndex,
              int[] in, int inleft, int inright,
              int[] post, int postIndex){
  if(inleft > inright){
    return post;
  }
  int root = pre[preIndex];
  int i = inleft;
  for(; i <= inright; i++){
    if(in[i] == pre[preIndex])  //i = root index in in[]
      break;
  }
  post[postIndex++] = root;
  helper(pre, preIndex, in, inleft, i-1, post, postIndex);
  helper(pre, preIndex, in, i+1, inright, post, postIndex);
}
