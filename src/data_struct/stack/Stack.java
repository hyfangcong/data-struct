package data_struct.stack;

public interface Stack<E> {
    int getSize();
    int getCapacity();
    void push(E e);
    E pop();
    E peek();
}
