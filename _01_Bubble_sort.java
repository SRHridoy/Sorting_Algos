import java.util.Scanner;

class _01_Bubble_sort{
    public static void main(String[] args) {
        int[] array = input();
        int n = array.length;

        bubbleSort(array,n);
        System.out.println("\nAfter Sorting : ");
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

    public static void bubbleSort(int[] array, int n){
        for(int i = 0; i < n-1; i++){
            System.out.println("\nPass: "+(i+1));
            boolean isSwapped = false;
            for(int j = 0; j < n-i-1; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSwapped = true;
                }
                printArray(array, n);
            }
            if(!isSwapped)
                    break;
        }
    }

    public static void printArray(int[] array, int n){
        for(int i = 0; i < n; i++){
            System.out.print(array[i]+" ");
        }System.out.println();
    }
}