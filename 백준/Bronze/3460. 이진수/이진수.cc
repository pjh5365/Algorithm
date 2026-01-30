#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n;
  cin >> t;
  while (t--) {
    cin >> n;
    string s = "";
    int idx = 0;
    while (n > 0) {
      if (n % 2) cout << idx << " "; 
      idx++;
      n >>= 1;
    }
    cout << "\n";
  }

  return 0;
}
