// 从origin stack中不断pop() element
// 对于helper stack，如果helper stack peek() < element，则将helper stack中的元素全部转移到origin stack
// 再将element push()到helper stack中
// 不断重复上述步骤，直到origin stack isEmpty
// 最后，所有的元素已经按照descending order排序好（smallest on top），只需将其转移到origin stack，则origin stack即为所需排序
// 时间复杂度为O(n^2)，空间复杂度为O(n)
