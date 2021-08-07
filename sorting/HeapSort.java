package sorting;

public class HeapSort {
    public void heapSort(int heapSort[]) {
        int n = heapSort.length;
        //Builds the heap by repeatedly calling the heapify method
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(heapSort, n, i);
        //Extract elements from the heap and put them in sorted order
        for (int i = n - 1; i >= 0; i--) {
            int temp = heapSort[0];
            heapSort[0] = heapSort[i];
            heapSort[i] = temp;
            heapify(heapSort, i, 0);
        }
    }

    // This makes sure that the subtree rooted at subtreeIndex is a heap
    void heapify(int array[], int sizeOfHeap, int subtreeIndex) {
        int largest = subtreeIndex;
        int left = 2 * subtreeIndex + 1;
        int right = 2 * subtreeIndex + 2;
        if (left < sizeOfHeap && array[left] > array[largest])
            largest = left;
        if (right < sizeOfHeap && array[right] > array[largest])
            largest = right;
        if (largest != subtreeIndex) {
            int swap = array[subtreeIndex];
            array[subtreeIndex] = array[largest];
            array[largest] = swap;
            heapify(array, sizeOfHeap, largest);
        }
    }

    public static void main(String args[]) {
        int arrayToBeSorted[] = {120, 101, 123, 15, 61, 327};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arrayToBeSorted);
        System.out.println("Sorted array :");
        for (int i = 0; i < arrayToBeSorted.length; ++i)
            System.out.print(arrayToBeSorted[i] + " ");
    }
}
