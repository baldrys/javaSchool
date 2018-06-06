package tasks.fromPresentation.fifthTask;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int currentSize;


    //constructor for class
    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    //Node class used to hold the information, and link to each other
    public class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        //constructor for node class
        public Node(E data, Node<E> next, Node<E> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public E getData(){
            return this.data;
        }
        public void setData(E newData){
            this.data = newData;
        }
        public Node<E> getNext(){
            return this.next;
        }
        public void setNext(Node<E> newNext){
            this.next = newNext;
        }

        public Node<E> getPrev(){
            return this.prev;
        }
        public void setPrev(Node<E> newPrev){
            this.prev = newPrev;
        }
    }

    class LinkedListIterator implements Iterator<T>{
        private Node<T> current;
        public LinkedListIterator(){
            current = head;
        }
        public T next(){
            if (current == null){
                throw new NoSuchElementException();
            }
            T temp = current.getData();
            current = current.getNext();
            return temp;
        }
        public boolean hasNext(){
            return current != null;
        }
    }
    class LinkedListIteratorReverse implements Iterator<T>{
        private Node<T> current;
        public LinkedListIteratorReverse(){
            current = tail;
        }
        public T next(){
            if (current == null){
                throw new NoSuchElementException();
            }
            T temp = current.getData();
            current = current.getPrev();
            return temp;
        }
        public boolean hasNext(){
            return current != null;
        }
    }
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    public Iterator<T> iteratorReverse(){
        return new LinkedListIteratorReverse();
    }



    public int size(){
        return this.currentSize;
    }
    public boolean isEmpty(){
        return this.size() == 0;
    }
    public void add(int pos, T x){
        if(pos < 0 || pos > size()){
            throw new IndexOutOfBoundsException();
        }
        if(pos == size()){
            add(x);
            return;
        }
        if (pos == 0){
            head = new Node<>(x, head, null);
        }else{
            Node<T> current = head;
            for(int j = 0; j < pos-1; j++){
                current = current.getNext();
            }
            current.setNext(new Node<>(x, current.getNext(),current.getPrev()));
        }
        currentSize++;

    }

    public void add(T x){
        if(isEmpty()){
            head = new Node<>(x, null, null);

            tail = head;
        }else{
            tail.setNext(new Node<>(x, null, tail));

            tail = tail.getNext();
        }
        currentSize++;
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Element 0");
        list.add("Element 1");
        list.add("Element 2");

        Iterator<String> iter = list.iteratorReverse();

        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
    }
}
