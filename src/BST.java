import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        if (binarySearch(val, root))
            return true;
        return false;
    }

    public boolean binarySearch(int val, BSTNode currentNode) {
        if (currentNode.getVal() == val)
            return true;
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            return false;
        }
        if (currentNode.getLeft() != null && val < currentNode.getVal()) {
            return binarySearch(val, currentNode.getLeft());
        }
        if (currentNode.getRight() != null) {
            return binarySearch(val, currentNode.getRight());
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        findInorder(root, arr);
        return arr;
    }

    public void findInorder(BSTNode currentNode, ArrayList<BSTNode> arr) {
        if (currentNode.getLeft() != null && arr.indexOf(currentNode.getLeft()) == -1)
            findInorder(currentNode.getLeft(), arr);
        arr.add(currentNode);
        if (currentNode.getRight() != null && arr.indexOf(currentNode.getRight()) == -1)
            findInorder(currentNode.getRight(), arr);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        findPreorder(root, arr);
        return arr;
    }

    public void findPreorder(BSTNode currentNode, ArrayList<BSTNode> arr) {
        arr.add(currentNode);
        if (currentNode.getLeft() != null && arr.indexOf(currentNode.getLeft()) == -1)
            findPreorder(currentNode.getLeft(), arr);
        if (currentNode.getRight() != null && arr.indexOf(currentNode.getRight()) == -1)
            findPreorder(currentNode.getRight(), arr);
    }
    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        findPostorder(root, arr);
        return arr;
    }

    public void findPostorder(BSTNode currentNode, ArrayList<BSTNode> arr) {
        if (currentNode.getLeft() != null && arr.indexOf(currentNode.getLeft()) == -1)
            findPostorder(currentNode.getLeft(), arr);
        if (currentNode.getRight() != null && arr.indexOf(currentNode.getRight()) == -1)
            findPostorder(currentNode.getRight(), arr);
        arr.add(currentNode);
    }
    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // Checks to see if the value is already in the tree
        if (search(val))
            return;
        findInsert(val, root);
    }

    // Searches recursively through the tree until it reaches the correct location to insert
    public void findInsert(int val, BSTNode currentNode) {
        if (currentNode.getLeft() != null && val < currentNode.getVal())
            findInsert(val, currentNode.getLeft());
        else if (currentNode.getRight() != null && val > currentNode.getVal())
            findInsert(val, currentNode.getRight());
        else if (val > currentNode.getVal())
            currentNode.setRight(new BSTNode(val));
        else
            currentNode.setLeft(new BSTNode(val));
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
