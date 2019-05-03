package data_struct.array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(8);
        for(int i = 0; i < 10; i++){
            array.addLast(i);
            System.out.println(array);
        }

        for(int i = 0; i < 10; i++){
            array.removeLast();
            System.out.println(array);

        }
    }
}
