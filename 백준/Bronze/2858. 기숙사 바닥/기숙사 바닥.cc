#include <bits/stdc++.h>
using namespace std;

int main() {
  int r, b;
  cin >> r >> b;
  int total = r + b;
  for (int i = 3; i < total; i++) {
    for (int j = i; j >= 3; j--) {
      int brown = (i - 2) * (j - 2);
      int red = i * j - brown;
      if (brown == b && red == r) {
        cout << max(i, j) << " " << min(i, j);
        return 0;
      }
    }
  }
}
