import java.util.Objects;

public class ArrayDeque<T> {
    private int size;
    private T [] ary;

    /* Constructor function that instantiate data member of ArrayDeque
    * of size and ary*/
    public ArrayDeque() {
        size = 0;
        ary = (T []) new Object[8];
    }

    public void resize(int capacity) {
        T [] new_ary = (T []) new Object[capacity];
        System.arraycopy(ary, 0, new_ary, 0, size);
        ary = new_ary;
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
        T [] new_ary = (T []) new Object[size + 1];
        System.arraycopy(new_ary, 0, ary, 1, size);
        ary = new_ary;
        size += 1;
        ary[0] = x;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque(){
        for (int i = 0; i <= size - 1; ++i)
        System.out.println(ary[i]);
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return ary[index];
    }

    public T removeLast(){
        if (size == 0) {
            return null;
        }
        T num = ary[size - 1];
        size -= 1;
        if (size / ary.length < 0.4) {
            resize(size / 2);
        }
        return num;
    }

    public T removeFirst(){
        if (size == 0) {
            return null;
        }
        T num = ary[0];
        size -= 1;
        T [] new_ary = (T []) new Object[size];
        System.arraycopy(ary, 1, new_ary, 0, size -1);
        ary = new_ary;
        if (size / ary.length < 0.4){
            resize(size / 2);
        }
        return num;
    }
}
