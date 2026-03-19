#include <bits/stdc++.h>
using namespace std;

int main() {
  int a, b, c, n;
  cin >> a >> b >> c >> n;

  for (int i = 0; i <= n / a; i++) {
    for (int j = 0; j <= n / b; j++) {
      for (int k = 0; k <= n / c; k++) {
        int tmp = n;
        tmp -= a * i;
        tmp -= b * j;
        tmp -= c * k;
        if (tmp == 0) {
          cout << "1";
          return 0;
        }
      }
    }
  }
  cout << "0";
}
