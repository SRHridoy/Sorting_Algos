import java.util.Scanner;

public class _08_Radix_sort {

    public static void main(String[] args) {
        int[] array = input();
        int n = array.length;

        radixSort(array,n);
        System.out.println("\nAfter Radix Sorting : ");
        printArray(array,n);
    }
//Radix sort:
    public static void radixSort(int[] array, int n){
        int max = getMax(array, n);
        for(int pos = 1; max/pos>0; pos*=10){
           countSort(array,n,pos);
        }
    }
    //Count sort:
    public static void countSort(int[] array, int n, int pos){
        int[] counterArray = new int[10];
        int[] helperArray = new int[n];

        for(int i = 0; i < n; i++){
            counterArray[array[i/pos]%10]++;
        }

        for(int i = 1; i < 10; i++){
            counterArray[i] = counterArray[i] + counterArray[i-1];
        }

        for(int i = n-1; i>=0; i--){
            helperArray[--counterArray[array[i/pos]%10]] = array[i];
        }

        for(int i = 0; i < n; i++){
            array[i] = helperArray[i];
        }
    }

    //findig max :
    public static int getMax(int[]array, int n){
        int mx = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i]>mx){
                mx = array[i];
            }
        }
        return mx;
    }

    //Taking input : 
    public static int[] input(){
        int n;
        System.out.println("Enter the size of the array : ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the array : ");
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