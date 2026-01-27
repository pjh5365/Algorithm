#include <bits/stdc++.h>
using namespace std;
int main() {
  set<int> s;
  int n, a;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    s.insert(a);
  }

  for (int i = 1; i < *prev(s.end()); i++) {
    if (s.find(i) == s.end()) {
      cout << i;
      return 0;
    }
  }
  cout << *prev(s.end()) + 1;
  return 0;
}
