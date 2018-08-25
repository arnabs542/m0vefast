//solution2
// 主函数里每次都从剩余的node里挑一个最小的接在dummy后，
// 然后用个helper function帮忙找最小的node. helper function 首先先找到这个最小的node，
// 然后再遍历一遍把这个node接到头上返回。
public ListNode selectionSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (head != null) {
      head = helper(head);
      cur.next = head;
      head = head.next;
      cur = cur.next;
    }
    return dummy.next;
  }
  //starting from the new node, 找最小的node, 遍历一遍把这个node接到头上返回。
  private ListNode helper(ListNode head) {
    ListNode cur = head;
    ListNode res = null;
    while (cur != null) {
      if (res == null || cur.value < res.value) {
        res = cur;
      }
      cur = cur.next;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    cur = dummy;
    while (cur.next != res) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
    res.next = dummy.next;
    dummy.next = res;
    return dummy.next;
  }
  // Time complexity: O(n^2), space complexity: O(1)
