#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, tmp;
  vector<int> v;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    v.push_back(tmp);
  }
  sort(v.begin(), v.end());
  int ret = 0;
  for (int i = 0; i < n; i++) {
    ret = max(ret, v[i] + (n - i));
  }
  cout << ret;
}
