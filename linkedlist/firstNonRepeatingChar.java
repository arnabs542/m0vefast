static class Node{
  Node pre;
  Node next;
  Character c;
  public Node(Character c){
    this.c = c;
  }
}
//maintain head and tail
//only char appearinc just once will be in the ddl
private Node head;
private Node tail;
private HashMap<Character, Node> singled;
private HashSet<Character> repeated;

public FirstNonRepeating(){
  //stand and keep watch: 单点环状结构 方便地处理一些corner case
  tail = new Node(null);
  tail.next = tail.prev = tail;
  head = tail;  //point to same node
  singled = new HashMap<Character, Node>();
  repeated = new HashSet<Character>();
}
public void read(char ch){
  if(repeated.contains(ch))
    return;
  Node node = singled.get(ch);
  if(node == null){  //if not appear before
    node = new Node(ch);
    append(node);
  }else{             //if repeated
    remove(node);
  }
}
//ACTUAL NODE <-> node -> h
// h,t              t'
private void append(Node node){
  singled.put(node.ch, node);
  tail.next = node;  //head.next =  FirstNonRepeating
  node.prev = tail;
  node.next = head;  //单点环状结构 or node,next = null;线性结构
  tail = tail.next;
}
private void remove(Node node){
  node.prev.next = node.next;  //ignore current node
  node.next.prev = node.prev;  //2 directions
  if(node == tail){
    tail = node.prev;
  }
  node.prev = node.next = null;  //cut connection
  repreated.add(node.ch);
  singled.remove(node.ch);
}

public Character FirstNonRepeating(){
  if(head == tail)
    return null;
  return head.next.ch;
}
