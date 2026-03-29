#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, p;
  while (1) {
    cin >> n;
    if (n == 0) return 0;
    cin >> p;
    vector<int> v;
    v.push_back(p % 2 ? p + 1 : p - 1);
    v.push_back(p % 2 ? n - p : n - p + 1);
    v.push_back(p % 2 ? n - p + 1 : n - p + 2);
    sort(v.begin(), v.end());

    for (int i : v) cout << i << " ";
    cout << "\n";
  }
}
