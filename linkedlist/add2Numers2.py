'''
//follup up  左边大 from right to left 计算
https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack
1->2->3->4 1234 + 234 = 1368
   2->3->4
1->4->6->8
'''
# do not user reverse
def add2Numbers2(node1, node2):

    cur = ListNode(0)
    stack1 = []
    stack2 = []
    while node1:
        stack1.append(node1.val)
        node1 = node1.next
    while node2:
        stack2.append(node2.val)
        node2 = node2.next

    carry = 0
    while stack1 or stack2:
        if stack1:
            carry += stack1.pop()
        if stack2:
            carry += stack2.pop()

        cur.val = carry % 10
        carry = carry // 10
        head = ListNode(carry)
        head.next = cur
        cur = head
        
    return cur if cur.val != 0 else cur.next


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
# no extra space needed
def addLists2(self, l1, l2):
        # write your code here
        l1 = self.reverse(l1);
        l2 = self.reverse(l2);
        sum = ListNode(0)
        cur = sum
        pre = sum
        while l1!=None and l2!=None:
            cur.val += l1.val+l2.val
            cur.next = ListNode(cur.val/10)
            cur.val = cur.val%10
            l1 = l1.next
            l2 = l2.next
            pre = cur
            cur = cur.next
        while l1!=None:
            cur.val += l1.val
            cur.next = ListNode(cur.val/10)
            cur.val = cur.val%10
            l1 = l1.next
            pre = cur
            cur = cur.next
        while l2!=None:
            cur.val += l2.val
            cur.next = ListNode(cur.val/10)
            cur.val = cur.val%10
            l2 = l2.next
            pre = cur
            cur = cur.next
        if cur.val==0:
            pre.next = None
        return self.reverse(sum)

    def reverse(self, head):
        # write your code here
        curr = None
        next = head
        while next:
            prev = curr
            curr = next
            next = next.next
            curr.next = prev
        return curr
