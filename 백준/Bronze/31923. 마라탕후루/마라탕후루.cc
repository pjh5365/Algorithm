#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, p, q, tmp;
  cin >> n >> p >> q;
  vector<int> v;
  vector<int> a;
  vector<int> b;

  for (int i = 0; i < n; i++) {
    cin >> tmp;
    a.push_back(tmp);
  }
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    b.push_back(tmp);
  }

  for (int i = 0; i < n; i++) {
    int cnt = 0;
    while (cnt <= 10000) {
      if (a[i] == b[i]) {
        v.push_back(cnt);
        break;
      }
      a[i] += p;
      b[i] += q;
      cnt++;
    }
  }

  if (v.size() == n) {
    cout << "YES \n";
    for (int i = 0; i < n; i++) cout << v[i] << " ";
  } else {
    cout << "NO";
  }
}
