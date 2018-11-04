//on the fly solution
static class Node{
  Node pre;
  Node next;
  Character c;
  public Node(Character c){
    this.c = c;
  }
}
//DDL: always return head
//hashmap: <char, reference to DDL>
1) X not in map: first time seen
- appeend tail of ddl
- add to map
2) X in map, value is null: deleted, appeared more than once
- do nothing
3) X in map, value is not null: appear once before
- set map(x).value = NUL
- remove from ddl
class ListNode{
  int value;
  ListNode prev;
  ListNode next;
  public ListNode(int value){
    this.value = value;
  }
}

class FindFirstNonrepeatedCharacterStream {
	public Character findFirstNonRepeating(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		Map<Character, Character> map = new HashMap<>();
    //https://stackoverflow.com/questions/31365998/is-there-any-doubly-linked-list-implementation-in-java
		List<ListNode> dll = new LinkedList<>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// first occurrence
			if (!map.containsKey(arr[i])) {
				dll.add(arr[i]);
				map.put(arr[i], arr[i]);
			} else {  // if not first occurrence
        // must cast Object to Character or remove() will throw exception
				dll.remove((Character)arr[i]);
				map.put(arr[i], null);
			}
		}
		return dll.get(0);
	}
