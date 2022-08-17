public class test {

    public static void main(String args[]) {



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
