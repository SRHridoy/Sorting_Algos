#include<iostream>
using namespace std;

void printArray(int array[], int n);
int partition(int array[],int lb, int ub);
//Quick sort : 
void quickSort(int array[], int lb, int ub){
    if(lb<ub){
        int loc = partition(array,lb,ub);
        quickSort(array,lb,loc-1);
        quickSort(array,loc+1,ub);
    }
}

//Partiton :
int partition(int array[], int lb, int ub){
    int start = lb;
    int end = ub;
    int pivot = array[lb];

    while (start<end)
    {
        while (array[start]<= pivot)
        {
            start++;
        }
        
        while (array[end]>pivot)
        {
            end--;
        }
        if(start<end)
            swap(array[start],array[end]);
    }
    swap(array[lb],array[end]);
    return end;
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
    int lb = 0, ub = n-1;
    quickSort(array,lb,ub);

    cout << "\nAfter Quick Sorting :\n";
    printArray(array,n);
    
}