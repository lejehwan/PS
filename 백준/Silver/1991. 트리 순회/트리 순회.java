import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                char parent = input[0].charAt(0);
                char left = input[1].charAt(0);
                char right = input[2].charAt(0);
                insertNode(parent, left, right);
            }
            traversal();

            System.out.println(sb);
        }
    }

    private static void traversal() {
        Node node = tree.get('A');
        preOrder(node);
        sb.append("\n");
        inOrder(node);
        sb.append("\n");
        postOrder(node);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }

    private static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    private static void preOrder(Node node) {
        if (node == null) return;
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void insertNode(char parent, char left, char right) {
        tree.putIfAbsent(parent, new Node(parent));
        Node parentNode = tree.get(parent);

        if (left != '.') {
            tree.putIfAbsent(left, new Node(left));
            parentNode.left = tree.get(left);
        }

        if (right != '.') {
            tree.putIfAbsent(right, new Node(right));
            parentNode.right = tree.get(right);
        }
    }

}
