import java.util.*;

class BST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    int search(Node root, int key, int position) {
        if (root == null)
            return -1;

        if (root.data == key)
            return position;

        if (key < root.data)
            return search(root.left, key, position * 2);
        else
            return search(root.right, key, position * 2 + 1);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            tree.root = tree.insert(tree.root, sc.nextInt());

        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);

        int key = sc.nextInt();

        int position = tree.search(tree.root, key, 1);

        if (position != -1)
            System.out.println("\nPosition: " + position);
        else
            System.out.println("\nNot Found");

        sc.close();
    }
}