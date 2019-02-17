package advjavaclass;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {

    protected TreeNode root;
    protected int size = 0;

    /**
     * Create a default binary search tree
     */
    public BST() {
    }

    /**
     * Create a binary search tree from an array of objects
     */
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    @Override
    /**
     * Return true if the element is in the tree
     */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else { // Element matches current.element
                return true; // Element is found
            }
        }
        return false;
    }

    @Override
    /**
     * Insert element e into the binary search tree. Return true if the element
     * is inserted successfully.
     */
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e); // Create a new root
        } else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Duplicate node not inserted
                }
            }
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }
            size++;

        }
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree
     */
    protected void inorder() {
        if (root == null) {
            return;
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
    }

    @Override
    /**
     * Postorder traversal from the root
     */
    public void postorder() {
        postorder(root);
    }

    /**
     * Postorder traversal from a subtree
     */
    protected void postorder() {
        if (root == null) {
            return;

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + " ");
        }
    }

    @Override
    public void preorder() {

    }

    /**
     * Preorder traversal from a subtree
     */
    protected void preorder() {
        if (root == null) {
            return;
            System.out.println(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    /**
     * This inner class is static, because it does not access 110any instance
     * members defined in its outer class
     */
    public static class TreeNode<E extends Comparable<E>> {

        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }
    
    public int getSiz
}
