#include<iostream>
using namespace std;

void printArray(int array[], int n);
void merge(int array[],int lb,int mid, int ub);
//Merge sort : 
void mergeSort(int array[], int lb, int ub){
    if(lb<ub){
        int mid = (lb+ub)/2;
        mergeSort(array,lb,mid);
        mergeSort(array,mid+1,ub);
        merge(array,lb,mid,ub);
    }
}

//Merge : 
void merge(int array[], int lb, int mid, int ub){
    int i = lb;
    int j = mid+1;
    int k = lb;

    int helperArray[lb+ub];

    while (i<=mid && j<= ub)
    {
        if(array[i]<=array[j]){
            helperArray[k] = array[i];
            k++,i++;
        }else{
            helperArray[k] = array[j];
            k++,j++;
        }
    }

    //if left:
    if(i>mid){
        while (j<=ub)
        {
            helperArray[k] = array[j];
            k++,j++;
        } 
    }else{
        while (i<=mid)
        {
            helperArray[k] = array[i];
            k++,i++;
        }
        
    }
    

    //Copying helper to our main array : 
    for (int i = lb; i <= ub; i++)
    {
        array[i] = helperArray[i];
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
    int lb = 0, ub = n-1;
    mergeSort(array,lb,ub);

    cout << "\nAfter Merge Sorting :\n";
    printArray(array,n);
    
}