import java.util.Scanner;
public class _04_Quick_sort {
    public static void main(String[] args) {
        int[] array = input();
        int n = array.length;
        int lb = 0, ub = n-1;
        quickSort(array,lb,ub);
        System.out.println("\nAfter Quick Sorting : ");
        printArray(array,n);
    }
//Quick Sort : 
    public static void quickSort(int[] array, int lb, int ub){
        if(lb<ub){
            int loc = partition(array, lb, ub);
            quickSort(array, lb, loc-1);
            quickSort(array, loc+1, ub);
        }
    }

    public static int partition(int[] array, int lb, int ub){
        int start = lb;
        int end = ub;
        int pivot = array[lb];

        while (start<end) {
            while (array[start]<=pivot) {
                start++;
            }
            while (array[end]>pivot) {
                end--;
            }
            if(start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        int temp = array[lb];
        array[lb] = array[end];
        array[end] = temp;
        return end;
    }


//Taking input : 
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

    //Print array : 
    public static void printArray(int[] array, int n){
        for(int i = 0; i < n; i++){
            System.out.print(array[i]+" ");
        }System.out.println();
    }
}