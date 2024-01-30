import java.util.Scanner;

public class _05_Merge_sort {
    public static void main(String[] args) {
        int[] array = input();
        int n = array.length;
        int lb = 0, ub = n-1;

        mergeSort(array,lb,ub);
        System.out.println("\nAfter Merge Sorting : ");
        printArray(array,n);
    }
//Merge Sort : 
    public static void mergeSort(int[] array, int lb, int ub){
        if(lb<ub){
            int mid = (lb+ub)/2;
            mergeSort(array, lb, mid);
            mergeSort(array, mid+1, ub);
            merge(array, lb, mid, ub);
        }
    }

//Merge : 
    public static void merge(int[] array, int lb, int mid, int ub){
        int i = lb;
        int j = mid+1;
        int k = 0;
        
        int helperArray[] = new int[(ub - lb + 1)];

        while (i<=mid && j<=ub) {
            if(array[i]<=array[j]){
                helperArray[k] = array[i];
                k++;
                i++;
            }else{
                helperArray[k] = array[j];
                k++;
                j++;
            }
        }

        if(i>mid){
            while (j<=ub){
                helperArray[k] = array[j];
                k++;
                j++;
            }
        }else{
            while (i<=mid) {
                helperArray[k] = array[i];
                k++;
                i++;
            }
        }

        for(int m = 0; m < helperArray.length; m++){
            array[lb+m] = helperArray[m];
        }
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
