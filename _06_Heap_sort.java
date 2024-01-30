import java.util.Scanner;

public class _06_Heap_sort {
    //heapsort:
    public static void heapSort(int[] array, int n){
        //Build maxheap:
        for(int i= n/2; i>=1; i--){
            maxHeapify(array,n,i);
        }
        //Deleting : 
        for(int i = n; i >= 2; i--){
            int temp = array[1];
            array[1] = array[i];
            array[i] = temp;

            maxHeapify(array, i-1, 1);
        }
    }
    //maxHeapify:
    public static void maxHeapify(int[] array, int n, int i){
        int largest = i;
        int l = 2*i;
        int r = 2*i + 1;

        if(l<=n && array[largest]<array[l]){
            largest = l;
        }
        if(r<=n && array[largest]<array[r]){
            largest = r;
        }
        if(largest!=i){
            array[largest] = array[largest] + array[i];
            array[i] = array[largest] - array[i];
            array[largest] = array[largest] - array[i];

            maxHeapify(array, n, largest);
        }

    }
//Main program : 
    public static void main(String[] args) {
        int[] array = input();
        int n = array.length-1;

        heapSort(array,n);
        System.out.println("\nAfter Heap Sorting : ");
        printArray(array,n);
    }
//Input : 
    public static int[] input(){
        int n;
        System.out.println("Enter the size of the array : ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] array = new int[n+1];
        System.out.println("\nEnter the array : ");
        for(int i = 1; i <= n; i++){
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }
    //Printing : 
    public static void printArray(int[] array, int n){
        for(int i = 1; i <= n; i++){
            System.out.print(array[i]+" ");
        }System.out.println();
    }
}
