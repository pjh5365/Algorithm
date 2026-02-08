#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  cin >> a >> b;
  int ret = 1e9;
  if (a.length() < b.length()) {
    for (int i = 0; i <= b.length() - a.length(); i++) {
      int cnt = 0;
      for (int j = 0; j < a.length(); j++) {
        if (b[j + i] != a[j]) {
          cnt++;
        }
      }
      ret = min(ret, cnt);
    }
  } else {
    ret = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a[i] != b[i]) {
        ret++;
      }
    }
  }

  cout << ret;

  return 0;
}
