import classes.*;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft( new TreeNode(4));
        root.getLeft().setRight( new TreeNode(5));
        root.getRight().setLeft( new TreeNode(6));
        root.getRight().setRight( new TreeNode(7));
        VerticalOrderTraversal traversal = new VerticalOrderTraversal();
        System.out.println(traversal.verticalOrder(root));
    }
}