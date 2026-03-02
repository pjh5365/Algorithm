#include <bits/stdc++.h>
using namespace std;

int main() {
  int q;
  string s;
  cin >> q;
  while (q--) {
    cin >> s;
    int ret = 0;
    for (int i = 3; i <= s.length(); i++) {
      if (s.substr(i - 3, 3) == "WOW") ret++;
    }
    cout << ret << "\n";
  }
}
