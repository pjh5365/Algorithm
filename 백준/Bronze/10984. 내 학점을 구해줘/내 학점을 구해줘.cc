#include <bits/stdc++.h>
using namespace std;

int main() {
    int t, n, c;
    cin >> t;
    double g;
    while (t--) {
      cin >> n;
      int ret1 = 0;
      double ret2 = 0;
      for (int i = 0; i < n; i++) {
        cin >> c >> g;
        ret1 += c;
        ret2 += g * c;
      }
      ret2 /= ret1;

      printf("%d %0.1lf \n", ret1, ret2);
    }

    return 0;
}
