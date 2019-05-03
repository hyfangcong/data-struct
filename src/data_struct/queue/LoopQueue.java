package data_struct.queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public int getCapacity(){
        return data.length -1;
    }

    @Override
    public void enqueue(E e){
        //如果队列满，进行扩容
        if((tail + 1) % data.length == front){
            resize(2*getCapacity());
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue(){
        if(front == tail){
            throw  new IllegalArgumentException("enqueue fail, queue is empty");
        }

        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity()/4)
            resize(getCapacity()/2);
        return res;
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity +1];
        for(int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue: size: %d, capacity: %d\n", size, getCapacity()));
        sb.append("front [");
        for(int i = front; i != tail; i = (i + 1) % data.length){
            sb.append(data[i]);
            if(i + 1 != tail){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public  void ff(){
        System.out.println();
    }

    private static class TT{

    }

}

