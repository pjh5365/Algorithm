#include <bits/stdc++.h>
using namespace std;

int main() {
    int t, n;
    cin >> t;
    while (t--) {
      cin >> n;
      int tmp;
      int ret = 0;
      for (int i = 0; i < n; i++) {
        cin >> tmp; 
        ret += tmp;
      }

      cout << ret << "\n";
    }

    return 0;
}
