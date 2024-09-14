#include <bits/stdc++.h>
using namespace std;
int N, tmp, ret;
int a[1000];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  for (int i = 0; i < N; i++) cin >> a[i];
  for (int i = 0; i < N; i++) {
    cin >> tmp;
    tmp -= a[i];
    if (tmp >= 0) ret++;
  }
  cout << ret << '\n';
}
