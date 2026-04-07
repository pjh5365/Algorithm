#include <bits/stdc++.h>
using namespace std;

int main() {
  int t;
  cin >> t;
  while (t--) {
    int ret = 0;
    int m = 200;
    int tmp;

    for (int i = 0; i < 7; i++) {
      cin >> tmp;
      if (tmp % 2 == 0) {
        ret += tmp;
        m = min(m, tmp);
      }      
    }
    cout << ret << " " << m << "\n";
  }
}
