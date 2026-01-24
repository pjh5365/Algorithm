#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, s;

  c = s = 100;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> b;
    if (a > b) {
      s -= a;
    } else if (a < b) {
      c -= b;
    }
  }
  cout << c << "\n" << s << "\n";
  return 0;
}