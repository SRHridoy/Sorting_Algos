#include<iostream>
using namespace std;

void printArray(int array[], int n);
int getMax(int array[], int n);
void countSort(int array[], int n, int pos);
//Radix sort:
void radixSort(int array[], int n){
    int max = getMax(array,n);
    for (int pos = 1; max/pos > 0 ; pos*=10)
    {
        countSort(array, n, pos);
    }
    
}
//count sort:
void countSort(int array[], int n, int pos){
    int counterArray[10] = {0};
    int helperArray[n];

    for (int i = 0; i < n; i++)
    {
        counterArray[array[i/pos]%10]++;
    }

    for (int i = 1; i < 10; i++)
    {
        counterArray[i] = counterArray[i]+counterArray[i-1];
    }

    for (int i = n-1; i >= 0; i--)
    {
        helperArray[--counterArray[array[i/pos]%10]] = array[i];
    }
    
    for (int i = 0; i < n; i++)
    {
        array[i] = helperArray[i];
    }
    
}

int main(){
    int n;
    cout << "Enter the size of the array : \n";
    cin >> n;
    int array[n+1];
    cout << "Enter the array : \n";
    for(int i = 0; i < n; i++)
    {
        cin >> array[i];
    }

    radixSort(array, n);

    cout << "\nAfter Radix Sorting :\n";
    printArray(array,n);
}

//printing : 
void printArray(int array[], int n){
    for (int i = 0; i < n; i++)
    {
        cout << array[i]<< " ";
    }cout << endl;
}
//getMax:
int getMax(int array[],int n){
    int max = 0;
    for (int i = 0; i < n; i++)
    {
        if(array[i]>max){
            max = array[i];
        }
    }
    return max;
}