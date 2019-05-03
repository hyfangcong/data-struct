package data_struct.queue;

public interface Queue<E> {
    int getSize();
    int getCapacity();
    void enqueue(E e);
    E dequeue();
    boolean isEmpty();
}
