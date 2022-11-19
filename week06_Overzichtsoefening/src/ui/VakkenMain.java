package ui;

import domain.model.BinaryMaxHeap;
import domain.model.Vak;

public class VakkenMain {
    public static void main(String[] args) {
        Vak bop = new Vak("BOP", 5);
        Vak oop = new Vak("OOP", 6);
        Vak algo = new Vak("Algo", 3);
        Vak web1 = new Vak("Web1", 4);
        Vak web2 = new Vak("Web2", 3);
        Vak pd = new Vak("Probleemoplossend Denken", 3);

        BinaryMaxHeap<Vak> heap = new BinaryMaxHeap<>();
        heap.addValue(bop);
        heap.addValue(oop);
        heap.addValue(algo);
        heap.addValue(web1);
        heap.addValue(web2);
        heap.addValue(pd);

        System.out.println("Dit vak moet je eerst studeren: " + heap.getMax());

        System.out.println("Aan het studeren: " + heap.removeGreatest());

        System.out.println("Dit vak moet je nu studeren: " + heap.getMax());
        System.out.println("Deze vakken moet ik nog allemaal studeren: ");
        heap.print();
    }
}
