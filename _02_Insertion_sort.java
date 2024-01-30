import java.util.Scanner;

public class _02_Insertion_sort {
    public static void main(String[] args) {
        int[] array = input();
        int n = array.length;

        insertionSort(array,n);
        System.out.println("\nAfter Insetion Sorting : ");
        printArray(array,n);
    }

    public static int[] input(){
        int n;
        System.out.println("Enter the size of the array : ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("\nEnter the array : ");
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    public static void insertionSort(int[] array, int n){
        for(int i = 1; i < n; i++){
            System.out.println("\nPass : "+i);
            int temp = array[i];
            int j = i-1;
            while (j>=0 && array[j]>temp) {
                array[j+1] = array[j];
                j--;
                printArray(array, n);
            }
            array[j+1] = temp;
            printArray(array, n);
        }
    }

    public static void printArray(int[] array, int n){
        for(int i = 0; i < n; i++){
            System.out.print(array[i]+" ");
        }System.out.println();
    }
}
