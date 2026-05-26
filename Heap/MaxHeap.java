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

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Get right child index
    private int rightChild(int i) {
        return 2 * i + 2;
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

    public int delete(){
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int root = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return root;
    }

    public void heapify(int i){
        int curr = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if(left < size && heap[curr] < heap[leftChild(i)]){
            curr = left;
        }
        if(right < size && heap[curr] < heap[rightChild(i)]){
            curr = right;
        }
        if(curr != i){
            swap(curr, i);
            heapify(curr);
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

        System.out.println(h.delete());
        System.out.println(h.delete());
        
        System.out.println("Heap After Deletion:");
        h.printHeap();
    }
}