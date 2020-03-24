public class ArrayDeque {
    private int size;
    private int [] ary;

    /* Constructor function that instantiate data member of ArrayDeque
    * of size and ary*/
    public ArrayDeque(){
        size = 0;
        ary = new int[8];
    }

    public void resize(){
        int [] new_ary = new int[2 * size];
        System.arraycopy(ary, 0, new_ary, 0, size);
        ary = new_ary;
    }

    public void reduce(){
        if (ary.length * 0.25 > size){
            int [] new_ary = new int [(int) (ary.length * 0.5)];
            System.arraycopy(ary, 0, new_ary, 0, size);
            ary = new_ary;
            return;
        }return;
    }

    public void addLast(int x){
        if (size == ary.length){
            resize();
            size += 1;
            ary[size - 1] = x;
            return;
        }
        size += 1;
        ary[size - 1] = x;
    }

    public void addFirst(int x){
        int [] new_ary = new int[size + 1];
        System.arraycopy(new_ary, 0, ary, 1, size);
        ary = new_ary;
        size += 1;
        ary[0] = x;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printDeque(){
        for (int i = 0; i <= size - 1; ++i)
        System.out.println(ary[i]);
    }

    public int get(int index){
        if (index >= size){
            return 0;
        }
        return ary[index];
    }

    public int removeLast(){
        int num = ary[size - 1];
        size -= 1;
        resize();
        return num;
    }

    public void removeFirst(){
        size -= 1;
        int [] new_ary = new int[size];
        System.arraycopy(ary, 1, new_ary, 0, size -1);
        ary = new_ary;
    }
}
