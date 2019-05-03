package data_struct.array;

public class Array<E> {
    private E[] data;
    private  int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public E getLast(){
        return getElement(size - 1);
    }

    public E getFirst(){
        return getElement(0);
    }

    public E getElement(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("getElement fail, 0 =< index < size");
        }
        return data[index];
    }

    //在第index位置上插入一个元素e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index > 0");
        }
        if(size == getCapacity()){
            resize(getCapacity() * 2);
        }
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    public E remove(int index){
        if(index >= size || index < 0){
            throw new IllegalArgumentException("remove fail, 0=<index < size");
        }
        E res = data[index];
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        if(size == getCapacity()/4){
            resize(getCapacity()/2);
        }
        return res;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    private void resize(int newCapacity){
        E [] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //如果数组中有元素e，返回其索引值，否则返回-1
    public int contain(E e) {
        for(int i = 0; i < size; i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size: %d, capacity: %d\n", size, data.length));
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
