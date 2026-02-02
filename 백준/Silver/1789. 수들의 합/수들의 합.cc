#include <bits/stdc++.h>
using namespace std;
int main() {
  long long s;
  long long sum = 0;
  long long ret = 1;

  cin >> s;

  for (int i = 0; i <= s; i++) {
    sum += i;
    if (sum <= s) {
      ret = i;
    } else {
      break;
    }
  }
  cout << ret;
  return 0;
}
