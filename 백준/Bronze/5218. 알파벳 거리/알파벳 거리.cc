#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  string a, b;
  cin >> t;
  while (t--) {
    cin >> a >> b;
    cout << "Distances: ";
    for (int i = 0; i < a.length(); i++) {
      int A = a[i];
      int B = b[i];
      if (B >= A) cout << B - A << " ";
      else cout << B + 26 - A << " ";
    }
    cout << "\n";
  }

  return 0;
}
