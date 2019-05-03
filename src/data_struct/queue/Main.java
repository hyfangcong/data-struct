package data_struct.queue;

import data_struct.queue.LoopQueue;

public class Main {
    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for(int i = 0; i < 11; i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        for(int i = 0; i < 6; i++){
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }
    }
}
