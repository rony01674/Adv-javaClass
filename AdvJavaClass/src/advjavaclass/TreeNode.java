package advjavaclass;

public class TreeNode<E> {

    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
        element = e;
    }
    
    // Create the root node
    TreeNode<Integer> root = new TreeNode<>(60);
    
    // Create the left child node
    root.left = new TreeNode<>(55);
    
    // Create the right chile node
    root.right = new TreeNode<>(100);
}
