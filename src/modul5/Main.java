package modul5;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.newNode("haha");
        tree.newNode("hihi");
        tree.newNode("huhu");
        tree.newNode("hehe");
        tree.newNode("hoho");
        tree.newNode("zzzz");


        System.out.print("\nPre Order :\n");
        tree.preOrder(tree.root);
        System.out.print("\nIn Order :\n");
        tree.inOrder(tree.root);
        System.out.print("\nPost Order :\n");
        tree.postOrder(tree.root);

    }
}
