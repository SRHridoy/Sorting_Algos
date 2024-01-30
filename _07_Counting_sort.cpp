#include<iostream>
using namespace std;

void printArray(int array[], int n);
//counting sort:
void countingSort(int array[], int n, int k){
    int countArray[k+1] = {0};
    int helperArray[n];
    //calculate occurrences :
    for (int i = 0; i < n; i++)
    {
        countArray[array[i]]++;
    }
    //calculate positions :
    for (int i = 1; i <= k; i++)
    {
        countArray[i] = countArray[i] + countArray[i-1];
    }
    //building helper array :
    for (int i = n-1; i >= 0; i--)
    {
        helperArray[--countArray[array[i]]] = array[i];
    }
    //coping to real array : 
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
    int k = 0;
    cout << "Enter the array : \n";
    for(int i = 0; i < n; i++)
    {
        cin >> array[i];
        if(array[i]>k)
            k = array[i];
    }

    countingSort(array, n, k);

    cout << "\nAfter Counting Sorting :\n";
    printArray(array,n);
}

//printing : 
void printArray(int array[], int n){
    for (int i = 0; i < n; i++)
    {
        cout << array[i]<< " ";
    }cout << endl;
}