package searching;

public class BinarySearchT {
    Node root;

    void insert(int key){
        root = insertNode(root, key);
    }

    Node insertNode(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.key){
            root.left = insertNode(root.left, key);
        } else if (key > root.key){
            root.right = insertNode(root.right, key);
            
        }
        return root;
    }

    void preOrder(){
        preOrderNode(root);
    }

    void preOrderNode(Node root){
        if(root != null) {
            System.out.println(root.key +" ");
            preOrderNode(root.left);
            preOrderNode(root.right);
        }
    }

    void postOrder(){
        postOrderNode(root);
    }

    void postOrderNode(Node root){
        if(root != null){
            postOrderNode(root.left);
            postOrderNode(root.right);
            System.out.println(root.key + " ");
        }
    }

    void inorder(){
        inorderNode(root);
    }

    void inorderNode(Node root){
        if(root != null){
            inorderNode(root.left);
            System.out.println(root.key + " ");
            inorderNode(root.right);
        }
    }


    Boolean Search(int key){
        return SearchNode(root, key) != null;
    }

    Node SearchNode(Node root, int key){
        if(root == null || root.key == key){
            return root;
        }

        if ( root.key > key){
            return SearchNode(root.left, key);
        }
        return SearchNode(root.right, key);
    }

    void Delete(int key){
        root = DeleteNode(root, key);
    }

    Node DeleteNode(Node root, int key) {
        if(root == null) return root;

        if( key < root.key){
            root.left = DeleteNode(root.left, key);
        } else if( key > root.key){
            root.right = DeleteNode(root.right, key);
        } else {
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }

            root.key = minValue(root.right);
            root.right = DeleteNode(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root){
        int minv = root.key;
        while( root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args){
        BinarySearchT tree = new BinarySearchT();
            tree.insert(20);
            tree.insert(70);
            tree.insert(10);
            tree.insert(60);
            tree.insert(50);
            tree.insert(40);
            tree.insert(80);

            System.out.println(" in order\n");
             tree.inorder();

            System.out.println(" preOrder: \n ");
            tree.preOrder();

            System.out.println(" post order: \n");
       
            tree.postOrder();
    }
}
