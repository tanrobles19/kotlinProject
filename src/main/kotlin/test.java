public class test {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);

        TreeNode tres = new TreeNode(3);

        root.right = tres;

        tres.left = new TreeNode(6);
        tres.right = new TreeNode(19);

        System.out.println(findNode(root, tres).val);
//        println( findNode(root, tres)?.`val` );
    }
    public static TreeNode findNode(TreeNode cloned, TreeNode target){

        if(cloned == null) return null;

        if (cloned.val == target.val) {
            return cloned;
        }

        if(cloned.left != null) {
            TreeNode current = findNode(cloned.left, target);
            if(current != null) return current;
        }

        if(cloned.right != null) {
            TreeNode current = findNode(cloned.right, target);
            if(current != null) return current;
        }

        return null;

    }// end fun findNode()

}
