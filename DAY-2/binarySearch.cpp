#include <iostream>
#include <vector>
using namespace std;
int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++) {
        cin>>arr[i];
    }
    int key;
    cin>>key;
    int low=0,high=n-1,mid;
    while(low<=high) {
        mid=(low+high)/2;
        if(arr[mid]==key) {
            cout<<mid;
            return 0;
        }
        else if(arr[mid]>key) {
            high=mid-1;
        }
        else {
            low=mid+1;
        }
    }
    return 0;
}