import org.junit.Test;

public class LinkedListDeque<T>{
    private linked_node sentinel;;
    public int size;
    private linked_node last;
    private  linked_node first;

    /* Nested class of the naive recursive linked list as the
    * foundation of linked list deque
    */
    private class linked_node{
        T item;
        private linked_node next;
        private linked_node front;
        private linked_node (T f, linked_node before, linked_node after){
            item = f;
            front = before;
            next = after;
        }
    }
    /* Constructor function takes in a integer to construct a linked list deque*/
    public LinkedListDeque(T x){
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
    public LinkedListDeque(){
        size = 0;
        sentinel = new linked_node(null, null, null);
        sentinel.front = sentinel;
        sentinel.next = sentinel;
        last = sentinel;
        first = last;
    }

    public void addLast(T x){
        size += 1;
        last.next = new linked_node(x, last, sentinel);
        sentinel.front = last.next;
        last = sentinel.front;
        first = sentinel.next;
    }

    public void addFirst(T x){
        size += 1;
        first.front = new linked_node(x, sentinel, first);
        sentinel.next = first.front;
        first = sentinel.next;
        last = sentinel.front;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        linked_node p = sentinel;
        while (p.next != sentinel){
            System.out.print(p.next.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    public T removeFirst(){
        size -= 1;
        if (sentinel.next == sentinel){
            return null;
        }
        T remove = first.item;
        first = first.next;
        first.front.next = null;
        first.front.front = null;
        sentinel.next = first;
        first.front = sentinel;
        return remove;
    }

    public T removeLast(){
        size -= 1;
        if (size() == 0){
            return null;
        }
        T remove = last.item;
        last = last.front;
        last.next.front = null;
        last.next.next = null;
        sentinel.front = last;
        last.next = sentinel;
        return remove;
    }

    public T get(int index){
        if (index > size){
            return 0;
        }
        linked_node ptr = sentinel;
        T iter = 0;
        while (iter <= index){
            ptr = ptr.next;
            ++iter;
        }
        return ptr.item;
    }

    /* This get recursive function has not been implemented*/
    public T getRecursive(int index){
    return null;
    }
}
