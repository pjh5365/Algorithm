#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, d, n, s, p;
  cin >> t;
  while (t--) {
    cin >> d >> n >> s >> p;
    int a = d + n * p;
    int b = n * s;

    if (a > b) {
      cout << "do not parallelize \n";
    } else if (a < b) {
      cout << "parallelize \n";
    } else {
      cout << "does not matter \n";
    }
  }

  return 0;
}
