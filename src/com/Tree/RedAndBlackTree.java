package com.Tree;

/**
 * 红黑树的实现
 */
public class   RedAndBlackTree{
    private final boolean RED = true;
    private final boolean BLACK = false;
    private Node root;
    private boolean IsRed(Node node){
        if(node==null)
            return false;
        else
            return node.color==RED;
    }
    //结点定义
    class Node <Integer>{
        public Node Left;
        public Node Right;
        public Integer key;
        public String value;
        public int number;
        public boolean color;

        public Node(Integer key, String value, int number, boolean color) {
            this.key = key;
            this.value = value;
            this.number = number;
            this.color = color;
        }
    }

    //查找
    //和二叉树的查找方法一样，但由于红黑树的平衡性比二叉树好，所以查找速度更快
    public String getValue(Integer key){
        return getValue(root,key);
    }
    private String getValue(Node node,Integer key){
        if(node==null)
            return null;
        int cmp=key.compareTo((Integer) node.key);
        if(cmp==0)
            return node.value;
        if(cmp>0)
           return getValue(node.Right,key);
        else
            return getValue(node.Left,key);
    }

    //左旋转
    private Node RotateLeft(Node h){
        Node x=h.Right;
        h.Right=x.Left;
        x.Left=h;
        x.color=h.color;
        h.color=RED;
        return x;
    }
    //右旋转
    private Node RotateRight(Node h){
        Node x=h.Left;
        h.Left=x.Right;
        x.Right=h;
        x.color=h.color;
        h.color=RED;
        return x;
    }

    //颜色反转
    private Node FlipColor(Node h)
    {
        h.Left.color=h.Right.color=BLACK;
        h.color=RED;
        return h;
    }

    //插入操作
    public void put(Integer key,String value){
        root=put(root,key,value);

    }

    private Node put(Node node,Integer key,String value){
        if(node==null)
            return new Node(key,value,1,RED);
        int cmp=key.compareTo((Integer) node.key);
        if(cmp==0)
            node.value=value;
        else if(cmp>0)
             put(node.Right,key,value);
        else
             put(node.Left,key,value);

        if(!IsRed(node.Left)&&IsRed(node.Right))//左旋
            node=RotateLeft(node);
        if(IsRed(node.Left)&&IsRed(node.Left.Left))//右旋
           node= RotateRight(node);
        if(IsRed(node.Left)&&IsRed(node.Right))//反转颜色
           node= FlipColor(node);
        node.number=Size(node.Left)+Size(node.Right)+1;
        return  node;
    }

    private int Size(Node h){
        if(h==null)
            return 0;
        return h.number;
    }
}
