# return new head, sorted list 
def insert_value(head, value):
  node = ListNode(value)

  if head is None or head.value > value:
    node.next = head
    return node

  cur = head
  while cur.next is not None and cur.next.value < value:
    cur = cur.next

  node.next = cur.next
  cur.next = node

  return head

# recursive way 
# public ListNode insert(ListNode head, int val){
#   //base case
#   if(head == null || val < head.val){
#     ListNode newHead = new ListNode(val);
#     //subproblem
#     newHead.next = head;
#     return newHead;
#   }
#   //recursion rule: 怎样用子问题解构造大问题解
#   head.next = insert(head.next, value);
#   return head;
# }

def insert_index(head, index, value):
  node = ListNode(value)

  if head is None or index == 0:
    node.next = head
    return node

  cur = head
  i = 0
  while cur is not None and i < index - 1:
    cur = cur.next

  if cur is None:
    return head
  elif cur.next is None:
    cur.next node
    return head
  else:
    node.next = cur.next
    cur.next = node
    return head

# retrun new head
def delete_value(head, value):
  if head is None:
    return head

  if head.value == value:
    return None

  dummy = ListNode(0)
  dummy.next = head
  cur = dummy
  while cur.next is not None and cur.next.value != value:
    cur = cur.next

  # if cur.next is none
  # if cur.next is None:
  #   return head
  # if cur.next.vaue is target value 
  cur.next = cur.next.next
  return dummy.next


def delete_index(head, index):
  if head is None:
    return None

  # delete head 
  if index == 0:
    head = head.next 
    return head

  dummy = ListNode(0)
  dummy.next = head
  cur = dummy

  i = 0
  while cur.next is not None and i < index-1:
    cur = cur.next

  if cur.next is None:
    return dummy.next
  else: #if i == index - 1:
    cur.next = cur.next.next
    return dummy.next


# delete list of nodes
# ListNode newHead = new ListNode(0);
#   public ListNode deleteNodes(ListNode head, int[] indices) {
#     if(head == null || indices.length == 0 || indices == null) {
#       return null;
#     }
#      for (int i = 0; i < indices.length; i++) {
#        if (i == 0) {
#            newHead = delete(head, indices[i]);
#        } else {
#            newHead = delete(newHead, indices[i] - i);
#        }
#      }
#      return newHead;
#   }

def delete_duplicate0(head):
  dummy = ListNode(0)
  cur = dummy
  dummy.next = head

  if head is None:
    return head

  while cur.next is not None and cur.next.next is not None:
    if cur.next.value == cur.next.next.value:
      target_value = cur.next.value
      while cur.next is not None and cur.next.value == target_value:
        cur.next = cur.next.next  # update next pointer, might be null
    else:
      cur = cur.next
  return dummy.next



























