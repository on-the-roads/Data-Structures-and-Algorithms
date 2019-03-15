package com.Tree;

import org.junit.Ignore;

import sun.reflect.generics.tree.Tree;

import com.alogrium.week1.quickfind_UF;

public class BSTree<T extends Comparable<T>> extends TreeNode<T> {
    public BSTree(T value) {
        super(value);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 查找是否含有此元素
     */
    public int Find(T x, TreeNode<T> bTree) {
        if (bTree == null) // 查找失败
            return 0;
        int result = x.compareTo((T) bTree.getValue());
        if (result > 0) // 右子树查找
            return Find(x, bTree.getRightChild());
        else if (result < 0)
            return Find(x, bTree.getLeftChild());
        else
            return 1;
    }

    /**
     * 寻找最小的元素
     */
    public T Findmin(TreeNode<T> bTree) {
        if (bTree == null)
            return null;
        else if (bTree.getLeftChild() == null)
            return bTree.getValue();
        else
            return Findmin(bTree.getLeftChild());
    }

    /**
     * 寻找最大的元素
     *
     * @return T
     */
    public T Findmax(TreeNode<T> bTree) {
        if (bTree == null)
            return null;
        else if (bTree.getRightChild() == null)
            return bTree.getValue();
        else
            return Findmax(bTree.getRightChild());
    }

    /**
     * 插入元素
     */
    public TreeNode<T> Insert(T x, TreeNode<T> bTree) {
        if (bTree == null)// 元素为空，则生成并返回一个结点
            bTree = new TreeNode<T>(x);
        // 开始找要插入元素的位置
        int result = x.compareTo(bTree.getValue());
        if (result < 0)
            bTree.setLeftChild(Insert(x, bTree.getLeftChild()));// 递归插入左子树
        else if (result > 0)
            bTree.setRightChild(Insert(x, bTree.getRightChild()));// 递归插入右子树
        else
            // 元素存在，什么也不做
            ;
        return bTree;
    }

    /**
     * 删除结点
     */
    public TreeNode<T> delete(T x, TreeNode<T> bTree) {
        if (bTree == null) {
            System.err.println("不存在该元素");
            return null;
        }
        T temp = null;
        int compResult = x.compareTo(bTree.getValue());
        if (compResult < 0)// 左子树递归删除
        {
            bTree.setLeftChild(delete(x, bTree.getLeftChild()));
        } else if (compResult > 0)// 右子树递归删除
        {
            bTree.setRightChild(delete(x, bTree.getRightChild()));
        } else // 找到要删除的结点
        {
            if (bTree.getLeftChild() != null && bTree.getRightChild() != null)// 被删除的结点有左右子节点
            {
                temp = Findmin(bTree.getRightChild());// 找到右子树的最小元素填充到删除的结点
                bTree.setValue(temp);
                // 删除右子树的最小元素结点
                bTree.setRightChild(delete(temp, bTree.getRightChild()));
            } else {
                if (bTree.getLeftChild() == null)// 有右孩子或者无子节点
                    bTree = bTree.getRightChild();
                else if (bTree.getRightChild() == null)// 有左孩子或者没有子结点
                    bTree = bTree.getLeftChild();
            }
        }
        return bTree;
    }

    public static void main(String[] args) {
        BSTree<Integer> root = new BSTree<Integer>(3);
        root.addLeftChild(1);
        root.addRightChild(4);
        root.getLeftChild().addLeftChild(0);
        root.getLeftChild().addRightChild(2);
        root.getRightChild().addRightChild(5);

        System.out.print("该树的元素为（层序遍历）：");
        TreeTools.LevelOrderTraversal2(root);
        System.out.println();
        System.out.print("树的节点个数:");
        System.out.println(TreeTools.getTreeNodenumByPreOrder(root));

        System.out.print("查找是否存在'6'这个元素：");
        int IsFind = root.Find(6, root);
        System.out.println(IsFind);

        System.out.print("最小元素为：");
        System.out.println(root.Findmin(root));

        System.out.print("最大元素为：");
        System.out.println(root.Findmax(root));
        System.out.println("添加元素‘6’，层序遍历结果为:");
        root.Insert(6, root);
        TreeTools.LevelOrderTraversal2(root);
        System.out.println();

        System.out.println("删除元素‘7’，层序遍历结果为:");
        root.delete(7, root);
        TreeTools.LevelOrderTraversal2(root);
        System.out.println();

        System.out.println("删除元素‘6’，层序遍历结果为:");
        root.delete(6, root);
        TreeTools.LevelOrderTraversal2(root);
        System.out.println();

        System.out.println("删除元素‘4’，层序遍历结果为:");
        root.delete(4, root);
        TreeTools.LevelOrderTraversal2(root);
    }

}
