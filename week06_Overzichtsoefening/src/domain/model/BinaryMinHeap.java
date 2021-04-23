package domain.model;
import java.util.ArrayList;
import java.util.Collections;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        if (this.isEmpty()) throw new IllegalStateException("Kan niet zoeken in een lege heap");
        return values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (isEmpty())
            values = new ArrayList<>();

        values.add(value);//achteraan toevoegen
        bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        if (values.size() <= 1) return; //als er maar 1 waarde is
        int addedIndex = values.size()-1;
        int levels = getLevels();
        E added = values.get(addedIndex);
        for (int i = 0; i < levels; i++) {
            int parentIndex = getParentIndex(addedIndex);
            E parent = values.get(parentIndex);
            int result = parent.compareTo(added);
            if (result > 0) {
                Collections.swap(values, parentIndex, addedIndex);
                addedIndex = parentIndex;
            } else return;
        }
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getLevels() {
        return (int) Math.floor(Math.log(values.size())/ Math.log(2)) + 1;
    }

    public int getLevelOfI(int index) {
        return (int) Math.floor(Math.log(index+1)/ Math.log(2));
    }

    public E removeSmallest() {
        if (isEmpty()) throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = getMin();// res bevat de kleinste = eerste element van de lijst
        values.set(0, values.get(values.size() - 1));// verwissel eerste met de laatste
        values.remove(values.size() - 1); // verwijder de laatste
        bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        if (values.size() <= 1) return; //als er maar 1 waarde is
        int levels = getLevels();
        int swappedIndex = 0;
        E swapped = values.get(0);
        for (int i = 1; i < levels; i++) {
            int leftChildIndex = getLeftChildIndex(swappedIndex);

            //has left child?
            if (leftChildIndex > values.size()-1) return;
            E leftChild = values.get(leftChildIndex);
            int leftResult = leftChild.compareTo(swapped);

            //has right child?
            if (leftChildIndex + 1 <= values.size()-1) {
                E rightChild = values.get(leftChildIndex + 1);
                int rightResult = rightChild.compareTo(swapped);

                //compare left and right children, choose smallest
                if (rightResult < 0 && leftChild.compareTo(rightChild) > 0) {
                    Collections.swap(values, swappedIndex, leftChildIndex+1);
                    swappedIndex = leftChildIndex+1;
                } else if (leftResult < 0) {
                    //swap with left child
                    Collections.swap(values, swappedIndex, leftChildIndex);
                    swappedIndex = leftChildIndex;
                }
            } else if (leftResult < 0) {
                //swap with left child
                Collections.swap(values, swappedIndex, leftChildIndex);
                swappedIndex = leftChildIndex;
            } else return;
        }
    }

    public int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    public ArrayList<E> getPath(E value) {
        if (values.isEmpty() || !values.contains(value)) return null;
        ArrayList<E> path = new ArrayList<>();
        path.add(value);
        int index = values.indexOf(value);
        int level = getLevelOfI(index);
        for (int i=0; i<level; ++i) {
            int parentIndex = getParentIndex(index);
            path.add(0, values.get(parentIndex));
            index = parentIndex;
        }

        return path;
    }
}
