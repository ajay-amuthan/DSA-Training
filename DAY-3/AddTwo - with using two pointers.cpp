#include <iostream>
#include <vector>
using namespace std;

int main() {
    int target = 9;
    vector<int> num = {2, 5, 3, 7, 11};
    

    vector<pair<int, int>> numWithIndices;
    for(int i = 0; i < num.size(); i++) {
        numWithIndices.push_back({num[i], i});
    }
    
    
    sort(numWithIndices.begin(), numWithIndices.end());
    
    
    
    int left = 0;                              
    int right = numWithIndices.size() - 1;     
    
    while(left < right) {
        int sum = numWithIndices[left].first + numWithIndices[right].first;
        
        if(sum == target) {
            
            cout << numWithIndices[left].second << " " << numWithIndices[right].second;
            break;
        } 
        else if(sum < target) {
            
            left++;
        } 
        else {
            
            right--;
        }
    }
    
    cout << " ";
    return 0;
}