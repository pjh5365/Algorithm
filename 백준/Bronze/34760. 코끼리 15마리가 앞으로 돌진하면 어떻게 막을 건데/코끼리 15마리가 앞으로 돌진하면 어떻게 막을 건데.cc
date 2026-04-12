#include <bits/stdc++.h>
using namespace std;

int main() {
  int tmp;
  int mx = 0;
  int ret = 0;
  int cnt = 0;
  for (int i = 0; i < 15; i++) {
    cin >> tmp;
    if (tmp > mx) {
      cnt = 1;
      mx = tmp;
    } else if (tmp == mx) {
      cnt++;
    }
  }

  if (tmp == mx) {
    if (cnt != 1) {
      ret = mx + 1;
    } else {
      ret = mx;
    }
  } else {
    ret = mx + 1;
  }

  cout << ret;
}
