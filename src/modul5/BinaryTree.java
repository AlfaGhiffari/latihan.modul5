package modul5;

public class BinaryTree {
    Node root;

    void newNode(String data){
        root = newNode(root, new Node(data));
    }
    Node newNode(Node root, Node newData){
        if(root == null){
            root = newData;
            return root;
        }
        else{
            if(newData.data.compareTo(root.data) < 0){
                root.left = newNode(root.left, newData);
            }else{
                root.right = newNode(root.right, newData);
            }
        }
        return root;
    }
    
    void preOrder(Node n){
        if(n != null){
            System.out.println(n.data + " ");
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    void inOrder(Node n){
        if(n != null){
            inOrder(n.left);
            System.out.println(n.data + " ");
            inOrder(n.right);
        }
    }

    void postOrder(Node n){
        if(n != null){
            postOrder(n.left);
            postOrder(n.right);
            System.out.println(n.data + " ");
        }
    }
}
