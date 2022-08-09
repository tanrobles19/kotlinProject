
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(10)

    val cinco = TreeNode(5)
    val quince = TreeNode(15)

    root.right = quince
    root.left = cinco

    cinco.left = TreeNode(3)
    cinco.right = TreeNode(7)

    quince.right = TreeNode(18)

//    println( findNode(root, tres)?.`val` )


    println(sumOfBST(root, 7, 15))

}

fun sumOfBST(root: TreeNode?, low: Int, high: Int): Int {

    if (root == null) return 0

    var sum = 0

    root.left?.let {
        sum+= sumOfBST(it, low, high)
    }

    root.right?.let {
        sum+= sumOfBST(it, low, high)
    }

    return if(checkRange(root.`val`, low, high)) root.`val` + sum else sum

}// end fun sumOfBST()

private fun checkRange(value: Int, low: Int, high: Int) = value in low..high


    fun findNode(node: TreeNode?, target: TreeNode): TreeNode?{

    if(node == null) return null

    if (node.`val` == target.`val`) {
        return node
    }

    node.left?.let {
        findNode(node.left, target)?.let {
            return it
        }
    }

    node.right?.let {
        findNode(node.right, target)?.let {
            return it
        }
    }

    return null

}// end fun findNode()

private fun checkTree(root: TreeNode?): Boolean {

    val leftCount = root?.left?.`val` ?: 0

    val rightCount = root?.right?.`val` ?: 0

    return root?.`val` == (leftCount + rightCount)

}