// Binary Search Tree Node
class Node {
    int val;
    Node left; 
    Node right;

    public Node(int key) {
        val = key;
        left = null;
        right = null;
    }
}

// Binary Search Tree Class
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert new nodes
    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.val)
            root.left = insert(root.left, key);
        else if (key > root.val)
            root.right = insert(root.right, key);

        return root;
    }

    // Traverse the binary tree in order and print values
    void traverse(Node root) {
        if (root != null) {
            traverse(root.left);
            System.out.print(root.val + " ");
            traverse(root.right);
        }
    }

    // Search for a specific value
    Node search(Node root, int key) {
        if (root == null || root.val == key)
            return root;

        if (root.val < key)
            return search(root.right, key);

        return search(root.left, key);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("Inorder traversal of the constructed tree:");
        tree.traverse(tree.root);

        int key = 50;
        if (tree.search(tree.root, key) != null)
            System.out.println("\n" + key + " found in the tree");
        else
            System.out.println("\n" + key + " not found in the tree");
    }
}
