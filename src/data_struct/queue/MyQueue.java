package data_struct.queue;

public interface MyQueue<E> {
    int getSize();
    int getCapacity();
    void enqueue(E e);
    E dequeue();
    boolean isEmpty();
}
