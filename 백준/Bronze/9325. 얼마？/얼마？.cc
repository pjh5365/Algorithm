#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, s, n, q, p;

  cin >> t;
  while (t--) {
    cin >> s >> n;
    int ret = s;
    for (int i = 0; i < n; i++) {
      cin >> q >> p;
      ret += q * p;
    }
    cout << ret << "\n";
  }
  return 0;
}