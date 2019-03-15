package com.MyList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;//注意是uti下的包
import java.util.NoSuchElementException;

/**
 * 双向链表实现LinkedList
 *
 * @param <E>
 */
public class MyLinkedList<E> implements Iterable<E> {
    private int theSize;
    private int modeCount = 0;//每次对add和move的调用都会更新modeCount，将其存储在迭代器中判断迭代过程中是否发生add和move行为
    private ListNode beginMarker;
    private ListNode endMarker;

    private class ListNode<E> {
        public ListNode(E data, ListNode p, ListNode n) {
            this.value = data;
            this.pre = p;
            this.next = n;
        }

        private E value;
        private ListNode pre;
        private ListNode next;
    }

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        doclear();
    }

    public void doclear() {
        beginMarker = new ListNode(null, null, null);
        endMarker = new ListNode(null, beginMarker, null);
        beginMarker.next = endMarker;//构建初始双向链表
        theSize = 0;
        modeCount++;
    }

    public boolean add(E x) {
        add(size(), x);
        return true;
    }

    public void add(int index, E value) {
        addBefore(getNode(index, 0, size()), value);
    }

    public E set(int index, E val) {
        ListNode<E> node = getNode(index);
        E valuetemp = node.value;
        node.value = val;
        return valuetemp;
    }

    /**
     * 将结点值为value的新结点插到node前面
     *
     * @param node
     * @param value
     */
    private void addBefore(ListNode node, E value) {
        ListNode newnode = new ListNode(value, node.pre, node);
        node.pre.next = newnode;
        node.pre = newnode;
        theSize++;
        modeCount++;
    }

    public E remove(int index) {
        return (E) remove(getNode(index));
    }

    private E remove(ListNode<E> node) {
        E val = node.value;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        theSize--;
        modeCount++;
        return val;
    }

    private ListNode getNode(int index) {
        return getNode(index, 0, size() - 1);
    }

    //在获取ListNode之前判断待获取下标是否越界
    private ListNode getNode(int index, int Lowwer, int Upper) {
        ListNode p;
        if (index < Lowwer || index > Upper) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > index; i--) {
                p = p.pre;
            }
        }
        return p;
    }

    public boolean IsEmpty() {
        return theSize == 0;
    }

    public int size() {
        return theSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>();
    }

    private class LinkedListIterator<E> implements Iterator<E> {
        private ListNode<E> current = beginMarker.next;
        private int expectedcount = modeCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return  current!=endMarker;
        }

        @Override
        public E next() {
            E val=null;
            if (modeCount!=expectedcount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }
          val=current.value;
            current=current.next;
            okToRemove=true;
            return  val;
        }

        @Override
        public void remove() {
            if (modeCount!=expectedcount){
                throw new ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.pre);
            okToRemove=false;
            expectedcount++;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list=new MyLinkedList<>();
        for (int i = 0; i <5 ; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator=list.iterator();
        System.out.println("遍历元素：");
        while(iterator.hasNext())
        {
            System.out.print(iterator.next());
        }
    }
}
