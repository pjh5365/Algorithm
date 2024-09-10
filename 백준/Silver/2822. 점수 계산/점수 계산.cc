#include <bits/stdc++.h>
using namespace std;
int a[8], tmp, b[8];
unordered_set<int> s;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  for (int i = 0; i < 8; i++) {
    cin >> tmp;
    a[i] = tmp;
    b[i] = tmp;
  }
  sort(a, a + 8);
  int sum = 0;
  for (int i = 7; i > 2; i--) {
    s.insert(a[i]);
    sum += a[i];
  }

  cout << sum << '\n';
  for (int i = 0; i < 8; i++) {
    if (s.find(b[i]) != s.end()) cout << i + 1 << ' ';
  }
  cout << '\n';
}
