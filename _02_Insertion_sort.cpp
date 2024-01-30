#include<iostream>
using namespace std;

void printArray(int array[], int n);
//Insertion sort : 
void insertionSort(int array[], int n){
    for (int i = 1; i < n; i++)
    {
        cout << "\nPass : " << i <<"\n";
        int temp = array[i];
        int j = i-1;
        while(j>=0 && array[j]>temp){
            array[j+1] = array[j];
            j--;
            printArray(array,n);
        }
        array[j+1] = temp;
        printArray(array,n);
    }
    
    
}
//printing : 
void printArray(int array[], int n){
    for (int i = 0; i < n; i++)
    {
        cout << array[i]<< " ";
    }cout << endl;
}

int main(){
    int n;
    cout << "Enter the size of the array : \n";
    cin >> n;
    int array[n];
    cout << "Enter the array : \n";
    for(int i = 0; i < n; i++)
    {
        cin >> array[i];
    }

    insertionSort(array,n);

    cout << "\nAfter Insertion Sorting :\n";
    printArray(array,n);
    
}