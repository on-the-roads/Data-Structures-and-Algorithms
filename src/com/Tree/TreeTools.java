package com.Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import com.Tree.TreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * 树的基本操作类
 */
public class TreeTools {

    /**
     * 求树中结点个数
     */
    public static int getTreeNodenumByPreOrder(TreeNode root) {
        // 前序遍历代码基础上修改
        if (root == null) {
            return 0;
        }
        int leftnum = getTreeNodenumByPreOrder(root.getLeftChild());
        int rightnum = getTreeNodenumByPreOrder(root.getRightChild());
        return leftnum + rightnum + 1;
    }

    /**
     * 求树的高度
     */
    public static int getTreeHeightByPostOrder(TreeNode root) {
        // 后续遍历代码基础上修改
        int LeftHeight, RightHeight, H;
        if (root == null)
            return 0;

        LeftHeight = getTreeHeightByPostOrder(root.getLeftChild());
        RightHeight = getTreeHeightByPostOrder(root.getRightChild());
        H = (LeftHeight > RightHeight) ? LeftHeight : RightHeight;
        return H + 1;
    }

    /**
     * 先序遍历（递归方法）：根，左，右
     */
    public static void PreOrderTraversal1(TreeNode root) {
        if (root != null) {
            System.out.println(root.getValue());
            PreOrderTraversal1(root.getLeftChild());
            PreOrderTraversal1(root.getRightChild());
        }
    }

    /**
     * 先序遍历（非递归方法：堆栈）：根，左，右
     */
    public static void PreOrderTraversal2(TreeNode root) {
        Stack stack = new Stack();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {// 一直向左并将沿途节点压入堆栈
                System.out.println(node.getValue());// 压栈是第一次碰到该结点，此时输出为先序遍历
                stack.push(node);
                node = node.getLeftChild();
            }

            if (!stack.isEmpty()) {
                node = (TreeNode) stack.pop();// 节点弹出堆栈
                node = node.getRightChild();
            }

        }
    }

    /**
     * 中序遍历（递归方法）：左，根，右
     */
    public static void InOrderTraversal1(TreeNode root) {
        if (root != null) {
            InOrderTraversal1(root.getLeftChild());
            System.out.println(root.getValue());
            InOrderTraversal1(root.getRightChild());
        }
    }

    /**
     * 中序遍历（非递归方法：使用堆栈）：左，根，右
     */
    public static void InOrderTraversal2(TreeNode root) {
        Stack stack = new Stack();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeftChild();
            }

            if (!stack.isEmpty()) {
                node = (TreeNode) stack.pop();// 弹栈是第二次遇见该结点，输出为中序遍历
                System.out.println(node.getValue());
                node = node.getRightChild();
            }

        }
    }

    /**
     * 后序遍历（递归方法）：左，右，根
     */
    public static void PostOrderTraversal1(TreeNode root) {
        if (root != null) {
            PostOrderTraversal1(root.getLeftChild());
            PostOrderTraversal1(root.getRightChild());
            System.out.println(root.getValue());
        }
    }

    /**
     * 后序遍历（非递归方法1：使用双堆栈）：左，右，根
     */
    public static void PostOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> resultStack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node); // 第一次访问该结点元素
                resultStack.push(node);
                node = node.getRightChild();
            }
            node = stack.pop();
            node = node.getLeftChild();
        }

        // 依次出栈resultstack中的元素
        while (!resultStack.isEmpty()) {
            TreeNode top = resultStack.peek();
            System.out.print(top.getValue() + " ");
            resultStack.pop();

        }
    }

    /**
     * 后序遍历（非递归方法2：使用双堆栈）：左，右，根
     *
     * @param root
     */
    public static void PostOrderTraversal2s(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<Integer> s2 = new Stack<Integer>();
        TreeNode node = root;
        while (!s1.isEmpty() || node != null) {
            while (node != null) {
                s1.push(node);
                s2.push(0);
                node = node.getLeftChild();
            }
            while (!s1.isEmpty() && s2.peek() == 1) {
                s2.pop();
                System.out.print(s1.pop().getValue() + " ");
            }
            if (!s1.isEmpty()) {
                s2.pop();
                s2.push(1);
                node = s1.peek().getRightChild();
            }
        }
    }

    /**
     * 层序遍历（递归方法）
     *
     * @param root
     */
    public static void LevelOrderTraversal1(TreeNode root) {
        if (root == null)
            return;
        int depth = getTreeHeightByPostOrder(root);
        for (int i = 1; i <= depth; i++) {
            levelOrder(root, i);
        }
    }

    private static void levelOrder(TreeNode root, int i) {
        if (root == null || i < 1)
            return;
        TreeNode node = root;
        if (i == 1)
            System.out.print(node.getValue() + " ");
        levelOrder(root.getLeftChild(), i - 1);
        levelOrder(root.getRightChild(), i - 1);
    }

    /**
     * 层序遍历(非递归方法，队列实现)：
     * 从结点访问其左、右儿子结点 :
     * 1.从队列中取出一个元素
     * 2.访问该元素所指结点
     * 3.若该元素所指结点的左、右孩子结点非空，则将左右孩子的结点顺序入列
     */
    public static void LevelOrderTraversal2(TreeNode root) {
        ArrayBlockingQueue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(
                30);
        TreeNode node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.getValue() + " ");
            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
    }


    /**
     * 深度优先搜索（DFS）
     * 堆栈实现
     */
    public static void DFS(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.getValue() + " ");
            if (node.getRightChild() != null)
                stack.push(node.getRightChild());//先添加右子树
            if (node.getLeftChild() != null)
                stack.push(node.getLeftChild());//后添加左子树
        }
    }

}
