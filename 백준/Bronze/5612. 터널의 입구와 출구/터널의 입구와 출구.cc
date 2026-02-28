#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, m, a, b;
  cin >> n >> m;
  int ret = m;
  int now = m;
  bool flag = false;
  while (n--) {
    cin >> a >> b;
    now += a;
    now -= b;
    if (now < 0) flag = true;
    ret = max(now, ret);
  }
  if (flag) ret = 0;
  cout << ret;
}
