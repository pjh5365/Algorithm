#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, tmp;
  cin >> n;
  int ret = 0;

  for (int i = 0; i < n; i++) {
    cin >> tmp;
    if (tmp < 0) {
      ret += -1 * tmp;
    } else {
      ret += tmp;
    }
  }

  for (int i = 0; i < n; i++) {
    cin >> tmp;
    if (tmp < 0) {
      ret += -1 * tmp;
    } else {
      ret += tmp;
    }
  }

  cout << ret;
}
