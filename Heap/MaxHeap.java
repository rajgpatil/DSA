class MaxHeap {
    int[] heap;
    int size;
    int capacity;
    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }
    
    private int parent(int i){
        return (i-1)/2;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int val){
        if(size == capacity){
            System.out.println("Heap is full");
            return;     
        }
        heap[size] = val;
        int current = size;
        size++;
        while(current > 0 && heap[current] > heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }

    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        MaxHeap h = new MaxHeap(10);

        h.insert(50);
        h.insert(30);
        h.insert(40);
        h.insert(10);
        h.insert(5);
        h.insert(20);
        h.insert(60);

        System.out.println("Heap:");
        h.printHeap();
    }
}