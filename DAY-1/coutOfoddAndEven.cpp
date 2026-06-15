#include <iostream>
using namespace std;
int main() {
    int n;
    cin>>n;
    int oddCount=0, evenCount=0;
    for (int i=0;i<n;i++) {
        int x;
        cin>>x;
        if (x%2==0) {
            evenCount++;
        } else {
            oddCount++;
        }
    }
    cout << "Odd numbers: " << oddCount << endl;
    cout << "Even numbers: " << evenCount << endl;
    return 0;
}