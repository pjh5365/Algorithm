#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, tmp;
  cin >> n;
  vector<int> v;
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    v.push_back(tmp);
  }
  sort(v.rbegin(), v.rend());
  int ret = 0;

  for (int i = 0; i < n; i++) {
    ret = max(ret, v[i] + i + 1);
  }
  cout << ret + 1;
}
