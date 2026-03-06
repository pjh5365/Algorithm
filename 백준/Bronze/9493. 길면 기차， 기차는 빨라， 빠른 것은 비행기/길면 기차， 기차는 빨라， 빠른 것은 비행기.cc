#include <bits/stdc++.h>
using namespace std;

int main() {
  int m, a, b;
  while (1) {
    cin >> m >> a >> b;
    if (m == 0 && a == 0 && b == 0) break;

    double A = m / (double)a * 3600;
    double B = m / (double)b * 3600;

    int tmp = round(abs(A - B));
    printf("%d:%02d:%02d\n", tmp / 3600, tmp % 3600 / 60, tmp % 60);
  }
}
