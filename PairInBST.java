import java.util.HashMap;

public class PairInBST {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        Node root = constructBST(arr);
        int sum = 130;
        System.out.println(findPair(root, sum));
    }

    public static Node constructBST(int[] arr) {
        Node root = null;
        for (int i : arr) {
            root = insert(root, i);
        }
        return root;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static boolean findPair(Node root, int sum) {
        HashMap<Integer, Node> map = new HashMap<>();
        return findPairHelper(root, sum, map);
    }

    public static boolean findPairHelper(Node root, int sum, HashMap<Integer, Node> map) {
        if (root == null) {
            return false;
        }

        if (map.containsKey(sum - root.data)) {
            System.out.println("Pair is (" + (sum - root.data) + "," + root.data + ")");
            return true;
        }

        map.put(root.data, root);

        if (findPairHelper(root.left, sum, map) || findPairHelper(root.right, sum, map)) {
            return true;
        }

        
        map.remove(root.data);
        return false;

    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
