#include <bits/stdc++.h>
using namespace std;
int L, P, tmp;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> L >> P;
  int total = L * P;
  for (int i = 0; i < 5; i++) {
    cin >> tmp;
    cout << tmp - total << ' ';
  }
  cout << '\n';
}
