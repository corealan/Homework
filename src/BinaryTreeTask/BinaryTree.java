package BinaryTreeTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;
    List<TreeNode> treeNodes = new ArrayList<>();


    //Рекурсивный метод чтобы пройтись по дереву прямым обходом и добавить его узлы в список по порядку
    private List<TreeNode> getPreOrderedList(TreeNode current) {
        if (current != null) {
            treeNodes.add(current);
            getPreOrderedList(current.getLeftChild());
            getPreOrderedList(current.getRightChild());
        }
        return treeNodes;
    }

    //НЕРекурсивный метод чтобы пройтись по дереву прямым обходом и добавить его узлы в список по порядку
    private List<TreeNode> getPreOrderedListNoRecursion(TreeNode current){
        if(current != null){
            Stack<TreeNode> treeNodeStack = new Stack<>();
            treeNodeStack.push(current);
            while (!treeNodeStack.isEmpty()){
                current = treeNodeStack.pop();
                treeNodes.add(current);
                if(current.getRightChild() != null){
                    treeNodeStack.push(current.getRightChild());
                }
                if(current.getLeftChild() != null){
                    treeNodeStack.push(current.getLeftChild());
                }
            }
        }
        return treeNodes;
    }

    public TreeNode next(TreeNode current){
        treeNodes = getPreOrderedListNoRecursion(root); // Идем прямым обходом и добавляем узлы в список по порядку
        for(int i = 0; i < treeNodes.size()-1; i++){ // Идем по списку с нодами
            if(treeNodes.get(i).getData() == current.getData()){ // Нашли ноду значение которой равно текущей
                return treeNodes.get(i+1); // Ура ура возвращаем следующую ноду
            }
        }
        return null; // Если у текущая нода - послденяя то вернем null
    }
    public void addNode(TreeNode newNode) {
        if (root == null) {
            root = newNode;
        }
        else {
            TreeNode currentNode = root;
            TreeNode parent;
            while (true){
                parent = currentNode;
                if(newNode.getData() == currentNode.getData()){
                    return;
                }
                if(newNode.getData() < currentNode.getData()){
                    currentNode = currentNode.getLeftChild();
                    if(currentNode == null){
                        parent.setLeftChild(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();
                    if(currentNode == null){
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

}
