package data_struct.stack;

public interface MyStack<E> {
    int getSize();
    int getCapacity();
    void push(E e);
    E pop();
    E peek();
}
