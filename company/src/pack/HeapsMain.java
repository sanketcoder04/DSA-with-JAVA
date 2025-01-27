package pack;

import java.util.ArrayList;

class Heap {
    private ArrayList<Integer> list;

    public Heap() {
        this.list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    public void insert(int value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int parentIndex = parent(index);
        if (list.get(index) < list.get(parentIndex)) {
            swap(index, parentIndex);
            upheap(parentIndex);
        }
    }

    public int remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from Empty Heap..");
        }
        int root = list.get(0);
        int last = list.remove(list.size() - 1);

        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return root;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min) > list.get(left)) {
            min = left;
        }
        if (right < list.size() && list.get(min) > list.get(right)) {
            min = right;
        }
        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public ArrayList<Integer> heapSort() throws Exception {
        ArrayList<Integer> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
}

public class HeapsMain {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        try {
            System.out.println(heap.remove());
            ArrayList<Integer> list = heap.heapSort();
            System.out.println(list);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
