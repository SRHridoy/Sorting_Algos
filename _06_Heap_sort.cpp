#include<iostream>
using namespace std;

void printArray(int array[], int n);
void maxHeapify(int array[], int n, int i);
//HeapSort:
void heapSort(int array[], int n){
    //building : 
    for (int i = n/2; i >= 1; i--)
    {
        maxHeapify(array,n,i);
    }
    //Deleting :
    for (int i = n; i >= 2; i--)
    {
        swap(array[1],array[i]);
        maxHeapify(array,i-1,1);
    }
}

//MaxHeapify:
void maxHeapify(int array[], int n, int i){
    int largest = i;
    int l = 2*i;
    int r = 2*i + 1;
    
    if ( l <= n && array[largest]<array[l])
    {
        largest = l;
    }

    if ( r <= n && array[largest]<array[r])
    {
        largest = r;
    }
    
    if(largest!=i){
        swap(array[largest],array[i]);
        maxHeapify(array,n,largest);
    }
    
}

int main(){
    int n;
    cout << "Enter the size of the array : \n";
    cin >> n;
    int array[n+1];
    cout << "Enter the array : \n";
    for(int i = 1; i <= n; i++)
    {
        cin >> array[i];
    }

    heapSort(array, n);

    cout << "\nAfter Heap Sorting :\n";
    printArray(array,n);
}

//printing : 
void printArray(int array[], int n){
    for (int i = 1; i <= n; i++)
    {
        cout << array[i]<< " ";
    }cout << endl;
}