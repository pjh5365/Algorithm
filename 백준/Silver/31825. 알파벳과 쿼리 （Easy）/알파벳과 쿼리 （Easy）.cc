#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, q, a, b, c;
  string s;

  cin >> n >> q;
  cin >> s;
  while (q--) {
    cin >> a >> b >> c;
    int cnt = 0;
    if (a == 1) {
      char before = ' ';
      for (int i = b - 1; i < c; i++) {
        if (s[i] != before) {
          cnt++;
          before = s[i];
        }
      }
      cout << cnt << "\n";
    } else {
      for (int i = b - 1; i < c; i++) {
        s[i] = (s[i] - 'A' + 1) % 26 + 'A';
      }
    }
  }
}
