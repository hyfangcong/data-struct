package data_struct.stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);

        for(int i =0; i < 8; i++){
            stack.push(i);
            System.out.println(stack);
        }

        for(int i = 0; i < 6; i++){
            stack.pop();
            System.out.println(stack);
        }
    }
}
