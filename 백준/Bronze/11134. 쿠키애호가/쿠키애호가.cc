#include <bits/stdc++.h>
using namespace std;

int main() {
    int t, n, c;
    cin >> t;
    while (t--) {
      cin >> n >> c;
      int ret = 0;
      while (n > 0) {
        n -= c;
        ret++;
      }
      cout << ret << "\n";
    }

    return 0;
}
