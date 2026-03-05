#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, tmp;
  long long ret = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> tmp;
      ret += tmp;
    }
  }
  cout << ret;
}
