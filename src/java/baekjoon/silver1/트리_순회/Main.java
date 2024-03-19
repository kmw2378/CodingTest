import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int count = Integer.parseInt(reader.readLine());

        final Node<String> root = inputNode();
        final Tree<String> tree = new Tree<>(root);
        for (int i = 1; i <= count - 1; i++) {
            tree.add(inputNode());
        }

        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
    }

    private static Node<String> inputNode() throws IOException {
        final String[] split = reader.readLine().split(" ");
        if (isNullElement(split[1])) {
            split[1] = null;
        }

        if (isNullElement(split[2])) {
            split[2] = null;
        }

        return new Node<>(split[0], split[1], split[2]);
    }

    private static boolean isNullElement(final String s) {
        return s.equals(".");
    }
}
class Tree<T> {
    private final Node<T> root;

    public Tree(final Node<T> root) {
        this.root = root;
    }

    public void add(final Node<T> node) {
        final Node<T> findNode = find(node.getElement(), root);
        if (findNode == null) {
            return;
        }
        findNode.setLeft(node.getLeft());
        findNode.setRight(node.getRight());
    }

    private Node<T> find(final T element, final Node<T> node) {
        if (node == null) {
            return null;
        }

        if (node.getElement().equals(element)) {
            return node;
        }

        final Node<T> leftNode = find(element, node.getLeft());
        if (leftNode != null) {
            return leftNode;
        }

        return find(element, node.getRight());
    }

    public void preOrder() {
        rPreOrder(root);
        System.out.println();
    }

    public void inOrder() {
        rInOrder(root);
        System.out.println();
    }

    public void postOrder() {
        rPostOrder(root);
        System.out.println();
    }

    private void rPreOrder(final Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getElement());
        rPreOrder(node.getLeft());
        rPreOrder(node.getRight());
    }

    private void rInOrder(final Node<T> node) {
        if (node == null) {
            return;
        }

        rInOrder(node.getLeft());
        System.out.print(node.getElement());
        rInOrder(node.getRight());
    }

    private void rPostOrder(final Node<T> node) {
        if (node == null) {
            return;
        }

        rPostOrder(node.getLeft());
        rPostOrder(node.getRight());
        System.out.print(node.getElement());
    }
}

class Node<T> {
    private final T element;
    private Node<T> left;
    private Node<T> right;

    public Node(final T element, final T leftElement, final T rightElement) {
        this.element = element;
        if (leftElement != null) {
            this.left = new Node<>(leftElement);
        }

        if (rightElement != null) {
            this.right = new Node<>(rightElement);
        }
    }

    private Node(final T element, final Node<T> left, final Node<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    private Node(final T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setLeft(final Node<T> left) {
        this.left = left;
    }

    public void setRight(final Node<T> right) {
        this.right = right;
    }
}
