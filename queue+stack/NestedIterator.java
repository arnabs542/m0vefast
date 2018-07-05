//http://www.lintcode.com/problem/flatten-nested-list-iterator/
//Flatten Nested List Iterator
public class NestedIterator implements Iterator<Integer> {
    //TODO
    private Stack<NestedInteger> stack;
    //TODO
    private void pushListToStack(List<NestedInteger> nestedList) {
        Stack<NestedInteger> tempStack = new Stack<>();
        for (NestedInteger nested : nestedList) {
            tempStack.push(nested);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
      //TODO
        stack = new Stack<>();
        pushListToStack(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
      //TODO
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
      //TODO
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushListToStack(stack.pop().getList());
        }

        return !stack.isEmpty();
    }

    @Override
    public void remove() {}
}
