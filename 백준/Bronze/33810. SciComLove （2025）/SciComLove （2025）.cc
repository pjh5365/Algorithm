#include <bits/stdc++.h>
using namespace std;

int main() {
  string s;
  string a = "SciComLove";

  cin >> s;

  int ret = 0;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] != a[i]) ret++;
  }
  cout << ret;
}
