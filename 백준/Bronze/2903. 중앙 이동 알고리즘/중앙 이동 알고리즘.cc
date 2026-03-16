#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  int ret = 2;

  cin >> n;
  while (n--) ret = (ret * 2) - 1;
  cout << ret * ret;
}
