public class MaxHeap {
    private static final int FRONT = 0;

    private Double[] arr;
    private int current;
    private int size;

    public MaxHeap(int size) {
        this.size = size;
        this.arr = new Double[size];
        this.current = -1;
    }

    public boolean isEmpty() {
        return current == -1;
    }

    public void insert(Double value) {
        if (current >= size - 1) {
            return;
        }

        arr[++current] = value;
        int temp = current;
        while (temp > 0) {
            int parent = (temp - 1) / 2;
            if (arr[temp] > arr[parent]) {
                swap(temp, parent);
            }
            temp = parent;
        }
    }

    private void heapify(int idx) {
        if (idx * 2 + 2 > current) {
            if (current == 1 && arr[1] > arr[0]) {
                swap(0, 1);
            }
            return;
        }

        int leftIdx = idx * 2 + 1;
        int rightIdx = idx * 2 + 2;
        if (arr[leftIdx] > arr[rightIdx]) {
            if (arr[leftIdx] > arr[idx]) {
                swap(leftIdx, idx);
                heapify(leftIdx);
            }
        } else {
            if (arr[rightIdx] > arr[idx]) {
                swap(rightIdx, idx);
                heapify(rightIdx);
            }
        }
    }

    private void swap(int i1, int i2) {
        double temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public Double pop() {
        swap(FRONT, current--);
        heapify(FRONT);
        return arr[current + 1];
    }
}