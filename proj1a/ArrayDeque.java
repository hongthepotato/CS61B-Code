public class ArrayDeque<T> {
    private int size;
    private T [] ary;

    /* Constructor function that instantiate data member of ArrayDeque
    * of size and ary*/
    public ArrayDeque() {
        size = 0;
        ary = (T []) new Object[8];
    }

    private void resize(int capacity) {
        T [] newAry = (T []) new Object[capacity];
        System.arraycopy(ary, 0, newAry, 0, size);
        ary = newAry;
    }

    public void addLast(T x) {
        if (size == ary.length) {
            resize(size * 2);
            size += 1;
            ary[size - 1] = x;
            return;
        }
        size += 1;
        ary[size - 1] = x;
    }

    public void addFirst(T x) {
        if (size == ary.length) {
            resize(2 * size);
        }
        T [] newAry = (T []) new Object[size + 1];
        System.arraycopy(ary, 0, newAry, 1, size);
        ary = newAry;
        size += 1;
        ary[0] = x;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int i = 0; i <= size - 1; ++i) {
            System.out.println(ary[i]);
        }
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return ary[index];
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removedElement = ary[size - 1];
        if ((double) size / ary.length < 0.4) {
            resize(ary.length / 2);
        }
        size -= 1;
        return removedElement;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removedElement = ary[0];
        T [] newAry = (T []) new Object[size];
        System.arraycopy(ary, 1, newAry, 0, size - 1);
        ary = newAry;
        if ((double) size / ary.length < 0.4) {
            resize(size / 2);
        }
        size -= 1;
        return removedElement;
    }
}
