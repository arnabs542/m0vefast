//each node has extra atribute which is parent of itself
/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
//solution1:
public TreeNode LCA2(TreeNode root, TreeNode node1, TreeNode node2){
    ArrayList<ParentTreeNode> pathA = getPath2Root(node1);
    ArrayList<ParentTreeNode> pathB = getPath2Root(node2);

    int indexA = pathA.size() - 1;
    int indexB = pathB.size() - 1;

    ParentTreeNode lowestAncestor = null;
    while(indexA >= 0 && indexB >= 0){
        if(pathA.get(indexA) != pathB.get(indexB))
            break;
        lowestAncestor = pathA.get(indexA);
        indexA--;
        indexB--;
    }
    return lowestAncestor;
}
//from root->node
private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node){
    ArrayList<ParentTreeNode> path = new ArrayList<>();
    while(node != null){
        path.add(node);
        node = node.parent;
    }
    return path;
}



//lai
public TreeNode LCA2(TreeNode root, TreeNode node1, TreeNode node2){
    int one = length(node1);
    int two = length(node2);
    //ganrantee first list is shorter, second list is longer
    if(one <= two)
        return mergeNode(node1, node2, two - one);
    else
        return mergeNode(node2, node1, one - two);
}
private TreeNode mergeNode(TreeNode shorter, TreeNode longer, int diff){
    while(diff > 0){
        longer = longer.parent; //keep going up
        diff--;
    }
    while(longer != shorter){
        longer = longer.parent;
        shorter = shorter.parent;
    }
    return longer;
}
//length of the path from node to root
private int length(TreeNode node){
    int length = 0;
    while(node != null){
        length++;
        node = node.parent;
    }
    return length;
}
