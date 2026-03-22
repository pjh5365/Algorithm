#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, m, tmp;
  int x1, x2, y1, y2;
  x1 = x2 = y1 = y2 = -1;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> tmp;
      if (tmp == 1) {
        if (x1 == -1 && y1 == -1) {
          x1 = i;
          y1 = j;
        } else {
          x2 = i;
          y2 = j;
        }
      }
    }
  }
  cout << abs(x2 - x1) + abs(y2 - y1);
}
