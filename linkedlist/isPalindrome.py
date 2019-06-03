def isPalindrome(self, head):
        # write your code here
        if head is None or head.next is None:
            return True

        mid = self.findMid(head)
        ######
        second = mid.next
        mid.next = None
         ######
        secondhead = self.reverse(second)
        return self.check(head, secondhead)

def findMid(self,head):
    slow = head
    fast = head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    return slow

def reverse(self, head):
    prev = None
    while head:
        next = head.next
        head.next = prev
        prev = head
        head = next
    return prev

def check(self, left, right):
    while left and right:
        print(left.val, right.val)
        if left.val != right.val:
            print(left.val, right.val)
            return False
        left = left.next
        right = right.next

    return True
