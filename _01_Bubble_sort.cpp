#include<iostream>
using namespace std;

void printArray(int array[], int n);
//bubble sort : 
void bubbleSort(int array[], int n){
    for (int i = 0; i < n-1; i++)
    {
        cout << "\nPass : " <<i+1 << "\n"; 
        bool isSwapped = false;
        for (int j = 0; j < n-i-1; j++)
        {
            if(array[j]>array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                isSwapped = true;
            }
            printArray(array,n);
        }
        //For Optimization :
        if(!isSwapped)
            break;
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

    bubbleSort(array,n);

    cout << "\nAfter Sorting :\n";
    printArray(array,n);
    
}