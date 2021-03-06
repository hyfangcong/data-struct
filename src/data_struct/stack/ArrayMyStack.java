package data_struct.stack;

import data_struct.array.Array;

public class ArrayMyStack<E> implements MyStack<E> {
    private Array<E> array;

    public ArrayMyStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayMyStack() {
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("MyStack: size: %d, capacity: %d\n", array.getSize(), array.getCapacity()));
        sb.append("[");
        for(int i = 0; i < array.getSize(); i++){
            sb.append(array.getElement(i));
            if(i + 1 != array.getSize()){
                sb.append(", ");
            }
        }
        sb.append("] top");

        return sb.toString();
    }
}
