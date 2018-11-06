public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Write your solution here
    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode p3 = dummy;
    // for each bit/osition
    while(p1 != null || p2 != null){
      if(p1 != null){
        carry += p1.value;
        p1 = p1.next;
      }
      if(p2 != null){
        carry += p2.value;
        p2 = p2.next;
      }
      p3.next = new ListNode(carry % 10);
      p3 = p3.next;
      carry = carry / 10;
    }
    if(carry == 1)
      p3.next = new ListNode(1);
    return dummy.next;
  }
//follup up
https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack
1->2->3->4 1234 + 234 = 1368
   2->3->4
1->4->6->8
do not user reverse
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
