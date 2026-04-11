#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, b;
  string a, c;

  cin >> n;
  double ret = 0;
  int sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> a >> b >> c;
    sum += b;
    if (c == "A+") {
      ret += b * 4.3;
    } else if (c == "A0") {
      ret += b * 4.0;
    } else if (c == "A-") {
      ret += b * 3.7;
    } else if (c == "B+") {
      ret += b * 3.3;
    } else if (c == "B0") {
      ret += b * 3.0;
    } else if (c == "B-") {
      ret += b * 2.7;
    } else if (c == "C+") {
      ret += b * 2.3;
    } else if (c == "C0") {
      ret += b * 2.0;
    } else if (c == "C-") {
      ret += b * 1.7;
    } else if (c == "D+") {
      ret += b * 1.3;
    } else if (c == "D0") {
      ret += b * 1.0;
    } else if (c == "D-") {
      ret += b * 0.7;
    }
  }

  printf("%0.2f", round(ret / sum * 100) / 100);
}
