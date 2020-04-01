public class LinkedListDeque<T> {
    private linked_node sentinel;;
    private int size;
    private linked_node last;
    private  linked_node first;

    /* Nested class of the naive recursive linked list as the
    * foundation of linked list deque
    */
    private class linked_node {
        T item;
        private linked_node next;
        private linked_node front;
        private linked_node (T f, linked_node before, linked_node after) {
            item = f;
            front = before;
            next = after;
        }
    }
    /* Constructor function takes in a integer to construct a linked list deque*/
    public LinkedListDeque(T x) {
        size = 1;
        /* We don't care what value we have for sentinel node. */
        sentinel = new linked_node(null, null, null);
        last = new linked_node(x, sentinel, sentinel);
        sentinel.front = last;
        sentinel.next = last;
        last.next = sentinel;
        first = last;
    }
    /* Constructor function takes void to construct an empty linked list deque*/
    public LinkedListDeque() {
        size = 0;
        sentinel = new linked_node(null, null, null);
        sentinel.front = sentinel;
        sentinel.next = sentinel;
        last = sentinel;
        first = last;
    }

    public void addLast(T x) {
        size += 1;
        last.next = new linked_node(x, last, sentinel);
        sentinel.front = last.next;
        last = sentinel.front;
        first = sentinel.next;
    }

    public void addFirst(T x) {
        size += 1;
        first.front = new linked_node(x, sentinel, first);
        sentinel.next = first.front;
        first = sentinel.next;
        last = sentinel.front;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        linked_node p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item);
            System.out.print(" ");
            p = p.next;
        }
    }
    /* Update both first and last pointer to sentinel.next and sentinel.front respectively.*/
    public T removeFirst() {
            
        if (size == 0) {
            return null;
        }
        size -= 1;
        T remove = first.item;
        first = first.next;
        first.front.next = null;
        first.front.front = null;
        sentinel.next = first;
        first.front = sentinel;
        last = sentinel.front;
        return remove;
    }

    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        size -= 1;
        T remove = last.item;
        last = last.front;
        last.next.front = null;
        last.next.next = null;
        sentinel.front = last;
        last.next = sentinel;
        first = sentinel.next;
        return remove;
    }

    public T get(int index) {
        if (index > size) {
            return null;
        }
        linked_node ptr = sentinel;
        int iter = 0;
        while (iter <= index) {
            ptr = ptr.next;
            iter += 1;
        }
        return ptr.item;
    }

    /* This get recursive function has not been implemented*/
    public T getRecursive(int index) {
        return null;
    }
}
