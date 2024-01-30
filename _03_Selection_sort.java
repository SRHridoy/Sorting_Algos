import java.util.Scanner;
public class _03_Selection_sort {
    public static void main(String[] args) {
        int[] array = input();
        int n = array.length;

        selectionSort(array,n);
        System.out.println("\nAfter Selection Sorting : ");
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

    public static void selectionSort(int[] array, int n){
        for(int i = 0; i < n-1; i++){
            System.out.println("\nPass : "+(i+1));
            int min = i;
            for(int j = i+1; j < n; j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
            printArray(array, n);
        }
    }

    public static void printArray(int[] array, int n){
        for(int i = 0; i < n; i++){
            System.out.print(array[i]+" ");
        }System.out.println();
    }
}