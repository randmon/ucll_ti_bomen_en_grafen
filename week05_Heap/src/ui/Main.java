package ui;

import domain.BinaryMinHeap;

public class Main {
    public static void main(String[] args) {
        BinaryMinHeap<Integer> heap = new BinaryMinHeap<>();
        heap.addValue(3);
        heap.addValue(2);
        heap.addValue(1);
        heap.addValue(0);
        heap.addValue(-1);
        heap.addValue(-2);
        heap.addValue(-4);
        heap.addValue(2);
        heap.addValue(-7);
        heap.print();

        for (int i = 1 ; i <= 2; i++){
            System.out.println(heap.removeSmallest());
            heap.print();
        }

        System.out.println("Path to -2: " + heap.getPath(-2));
        System.out.println("Path to 0: " + heap.getPath(0));
        System.out.println("Path to 2: " + heap.getPath(2));
        System.out.println("Path to 3: " + heap.getPath(3));

        System.out.println("Level of index 9998: " + Math.floor(Math.log(9998)/Math.log(2)));
    }
}
