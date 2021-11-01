package BinaryTreeTask;

public class TreeNode {
    public TreeNode(int data) {
        this.data = data;
    }

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public void setData(int data) {
        this.data = data;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }
}
