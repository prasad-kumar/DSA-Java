import java.util.*;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTreeBuilder {

        static int idx = -1;
        public static Node BuildTree(int[] nodes) {

            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            // creating root node
            Node newNode = new Node(nodes[idx]);
            
            // creating left subtree
            newNode.left = BuildTree(nodes);
            // creating right subtree
            newNode.right = BuildTree(nodes);

            return newNode;
        }
    }

    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }

        //printing root
        System.out.print(root.data + " ");

        //printing left subtree
        preOrderTraversal(root.left);

        //printing right subtree
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }

        //printing left subtree
        postOrderTraversal(root.left);

        //printing right subtree
        postOrderTraversal(root.right);

        //printing root
        System.out.print(root.data + " ");
    }

    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }

        //printing left subtree
        inOrderTraversal(root.left);

        //printing root
        System.out.print(root.data + " ");

        //printing right subtree
        inOrderTraversal(root.right);
    }

    public static void levelOrderTraversal(Node root) {

        // chack if root is null (empty tree)
        if(root == null){
            return;
        }
        // create queue and add root and null(nextline) to queue
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        //iterate until queue becomes empty
        while(!q.isEmpty()){
            // get currNode for queue
            Node currNode = q.remove();
            
            //check if currNode is null or not
            if(currNode == null){
                // first print newline (beacause null means new line)
                System.out.println();

                // check queue is empty after null if its empty(means end of tree) break the loop
                if(q.isEmpty()){
                    break;
                }else{
                    // else add null for next level
                    q.add(null);
                }
            }else{

                //print currNode data
                System.out.print(currNode.data + " ");

                // check if currNode have any left node or not
                if(currNode.left != null){
                    // if currNode has left node then add it to queue
                    q.add(currNode.left);
                }

                // check if currNode have any right node or not
                if(currNode.right != null){
                    // if currNode has right node then add it to queue
                    q.add(currNode.right);
                }
            }
        }
    }

    //class for save info of diameter
    static class TreeInfo{
        int height;
        int diam;
        
        TreeInfo(int height, int diam){
            this.height = height;
            this.diam = diam;
        }
    }
    
    public static TreeInfo getDiameter(Node root){
        if(root == null) {
           return new TreeInfo(0, 0);
       }
 
       TreeInfo leftTI = getDiameter(root.left);
       TreeInfo rightTI = getDiameter(root.right);
 
       int myHeight = Math.max(leftTI.height, rightTI.height) + 1;
 
       int diam1 = leftTI.height + rightTI.height + 1;
       int diam2 = leftTI.diam;
       int diam3 = rightTI.diam;
 
       int myDiam = Math.max(diam1, Math.max(diam2, diam3));
 
       return new TreeInfo(myHeight, myDiam);
    }

    // this main function declred by govansh
    public static void main(String args[]) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTreeBuilder tree = new BinaryTreeBuilder();

        Node root = tree.BuildTree(nodes);

        // preOrderTraversal(root);
        // postOrderTraversal(root);
        // inOrderTraversal(root);
        levelOrderTraversal(root);
    }
}
