#include<iostream>
using namespace std;

void printArray(int array[], int n);
//Selection sort : 
void selectionSort(int array[], int n){
    for (int i = 0; i < n-1; i++)
    {
        cout << "\nPass : " << i+1 <<"\n";
        int min = i;
        for (int j = i+1; j < n; j++)
        {
            if(array[j]<array[min]){
                min = j;
            }  
            //printArray(array,n); 
        }
        if(min!=i)
            swap(array[i],array[min]);
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

    selectionSort(array,n);

    cout << "\nAfter Selection Sorting :\n";
    printArray(array,n);
    
}