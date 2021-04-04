package ds.cs61b;

public class LinkedListDeque<T> {

    public class Node {
        public Node prev;
        public Node next;
        public T item;

        public Node(T item) {
            this.item = item;

        }

        public void displayNode() {
            System.out.println("{ " + item + " } ");
        }
    }


    private Node first;
    private Node last;

    private int size;

    public LinkedListDeque(T x) {

        this.first = null;
        this.last = null;

    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Adds an item to the front of the list.
     */
    public void addFirst(T x) {


        Node node = new Node(x);

        if (isEmpty()) {
            last = node;
        } else {
            first.prev = node;
        }
        node.next = first;
        this.first = node;
        size += 1;

    }

    public void addLast(T x) {
        Node node = new Node(x);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        node.prev = last;
        this.last = node;
        size += 1;

    }

    public T removeFirst() {
//        Node temp = first;
        if (isEmpty()) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;

        return first.item;
    }

    public T removeLast() {
//        Node temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.prev.next = null;

        }
        last = last.prev;

        return last.item;
    }

    public T get(int index) {
        Node n = first;
        int count = 0;
        while (n.next != null) {
            n = n.next;
            count++;
            if (index == count) {
                return n.item;
            }
        }
        return null;
    }


    public T getFirst() {
        return first.item;
    }

    public boolean insertAfter(T key, T d) {
        Node current = first; // we start from the beginning of the list
        while (current.item != key) { // as long as we have not found the key in a particular node
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Node n = new Node(d);

        if (current == last) {
            current.next = null;
            last = n;
        } else {
            n.next = current.next;

            current.next.prev = n;
        }
        n.prev = current;
        current.next=n;
        return true;
    }
    
    public int size() {
        return size;

    }


    public void printDeque() {
        System.out.println("List (first --> last) ");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }
}


