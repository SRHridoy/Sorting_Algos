import java.util.Scanner;

public class _07_Counting_sort {
    public static void main(String[] args) {
        int[] array = input();
        int n = array.length;
        int k = max(array,n);

        countingSort(array,n,k);
        System.out.println("\nAfter Counting Sorting : ");
        printArray(array,n);
    }

//Counting sort:
    public static void countingSort(int[] array, int n, int k){
        int[] countingArray = new int[k+1];
        int[] helperArray = new int[n];
        //compute countingArray:
        for(int i = 0; i < n; i++){
            countingArray[array[i]]++;
        }
        //compute the locations:
        for(int i = 1; i <= k; i++){
            countingArray[i] = countingArray[i]+countingArray[i-1];
        }
        //building helperArray:
        for(int i = n-1; i >= 0; i--){
            helperArray[--countingArray[array[i]]] = array[i];
        }
        //coping to original array:
        for(int i = 0; i < n; i++){
            array[i] = helperArray[i];
        }
    }

    //findig k :
    public static int max(int[]array, int n){
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
