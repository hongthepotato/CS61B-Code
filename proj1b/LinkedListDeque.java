public class LinkedListDeque<T> implements Deque<T>{
    private final linkedNode sentinel;;
    private int size;
    private linkedNode last;
    private linkedNode first;

    /*
     * Nested class of the naive recursive linked list as the foundation of linked
     * list deque
     */
    private class linkedNode {
        T item;
        private linkedNode next;
        private linkedNode front;

        private linkedNode(final T f, final linkedNode before, final linkedNode after) {
            item = f;
            front = before;
            next = after;
        }
    }

    /* Constructor function takes in a integer to construct a linked list deque */
    public LinkedListDeque(final T x) {
        size = 1;
        /* We don't care what value we have for sentinel node. */
        sentinel = new linkedNode(null, null, null);
        last = new linkedNode(x, sentinel, sentinel);
        sentinel.front = last;
        sentinel.next = last;
        last.next = sentinel;
        first = last;
    }

    /* Constructor function takes void to construct an empty linked list deque */
    public LinkedListDeque() {
        size = 0;
        sentinel = new linkedNode(null, null, null);
        sentinel.front = sentinel;
        sentinel.next = sentinel;
        last = sentinel;
        first = last;
    }

    @Override
    public void addLast(final T x) {
        size += 1;
        last.next = new linkedNode(x, last, sentinel);
        sentinel.front = last.next;
        last = sentinel.front;
        first = sentinel.next;
    }

    @Override
    public void addFirst(final T x) {
        size += 1;
        first.front = new linkedNode(x, sentinel, first);
        sentinel.next = first.front;
        first = sentinel.next;
        last = sentinel.front;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        linkedNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item);
            System.out.print(" ");
            p = p.next;
        }
    }


    /*
     * Update both first and last pointer to sentinel.next and sentinel.front
     * respectively.
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        final T remove = first.item;
        first = first.next;
        first.front.next = null;
        first.front.front = null;
        sentinel.next = first;
        first.front = sentinel;
        last = sentinel.front;
        return remove;
    }

    @Override
    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        size -= 1;
        final T remove = last.item;
        last = last.front;
        last.next.front = null;
        last.next.next = null;
        sentinel.front = last;
        last.next = sentinel;
        first = sentinel.next;
        return remove;
    }

    @Override
    public T get(final int index) {
        if (index > size) {
            return null;
        }
        linkedNode ptr = sentinel;
        int iter = 0;
        while (iter <= index) {
            ptr = ptr.next;
            iter += 1;
        }
        return ptr.item;
    }

    /* This get recursive function has not been implemented */
    public T getRecursive(final int index) {
        return null;
    }
}
