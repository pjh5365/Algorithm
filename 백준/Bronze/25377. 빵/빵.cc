#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, a, b;
    int ret = 1e9;
    cin >> n;
    while (n--) {
      cin >> a >> b;
      if (b - a >= 0) {
        ret = min(ret, b);
      }
    }

    if (ret == 1e9) ret = -1;

    cout << ret;

    return 0;
}
