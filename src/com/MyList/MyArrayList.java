package com.MyList;

import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    private static final int DefaultSize = 10;
    private int theSize=0;
    private E[] theItems= (E[]) new Object[1];//设置长度为1为了避免空指针异常

    public void clear() {
        doclear();
    }

    private void doclear() {
        theSize = 0;
        ensureCapacity(DefaultSize);
    }

    private void ensureCapacity(int newSize) {
        if (newSize <=theSize) {
            return;
        }
        E[] s = (E[]) new Object[newSize];
        for (int i = 0; i < theSize; i++)
            s[i] = theItems[i];
        theItems = s;
    }

    public int size() {
        return theSize;
    }

    public boolean IsEmpty() {
        return theSize == 0;
    }

    public void trimToSize() {
        ensureCapacity(theSize);
    }

    public E get(int index) {
        if (index < 0 || index > size() - 1)
            throw new ArrayIndexOutOfBoundsException();
        return theItems[index];
    }

    public E set(int index, E newval) {
        if (index < 0 || index > size() - 1)
            throw new ArrayIndexOutOfBoundsException();
        E oldval = theItems[index];
        theItems[index] = newval;
        return oldval;
    }

    public  void add(int index,E newval)
    {
        if(theItems.length==size()){
            ensureCapacity(size()*2);
        }
        for(int i=theSize;i>index;i--)
        {
            theItems[i]=theItems[i-1];
        }
        theItems[index]=newval;
        theSize++;
    }
    public boolean add(E newval)
    {
        add(size(),newval);
        return true;
    }
    public E remove(int index)
    {
        E oldval=theItems[index];

        for(int i=index+1;i<size();i++)
        {
            theItems[i-1]=theItems[i];
        }
        theSize--;
        return  oldval;
    }
    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<E>();
    }
    private class MyArrayListIterator<E> implements Iterator<E> {
        private  int current=0;
        @Override
        public boolean hasNext() {
            return current<(size()-1);
        }
        @Override
        public E next() {
           return (E) theItems[current++];
        }
        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list=new MyArrayList<>();
        for (int i=0;i<8;i++)
        {
            list.add(i);
        }
        Iterator<Integer> iterator=list.iterator();
        System.out.println("遍历输出：");
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
}
