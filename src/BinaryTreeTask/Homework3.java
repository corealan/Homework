package BinaryTreeTask;

public class Homework3 {
    // Задача 2. Выбрал бы вариант с обходом без рекурсии, т.к если дерево окажется достаточно большим то можно получить переполнение стека.
    //Вообще меня не покидает чувство, что можно было бы и как то получше решить, без treeNodes в BinaryTree, наприме :)
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode newNode = new TreeNode(26);
        TreeNode newNode1 = new TreeNode(4);
        TreeNode newNode2 = new TreeNode(12);
        TreeNode newNode3 = new TreeNode(55);
        TreeNode newNode4 = new TreeNode(13);
        TreeNode newNode5 = new TreeNode(77);
        TreeNode newNode6 = new TreeNode(243);
        TreeNode newNode8 = new TreeNode(5);
        TreeNode newNode9 = new TreeNode(1);
        binaryTree.addNode(newNode);
        binaryTree.addNode(newNode1);
        binaryTree.addNode(newNode2);
        binaryTree.addNode(newNode3);
        binaryTree.addNode(newNode4);
        binaryTree.addNode(newNode5);
        binaryTree.addNode(newNode6);
        binaryTree.addNode(newNode8);
        binaryTree.addNode(newNode9);

        System.out.println(binaryTree.next(newNode5).getData());
    }


}
