#include <bits/stdc++.h>
using namespace std;
int N, L[21], J[21], dp[101];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> N;
  for (int i = 1; i <= N; i++) cin >> L[i];
  for (int i = 1; i <= N; i++) cin >> J[i];

  for (int i = 1; i <= N; i++) {
    for (int j = 100; j >= L[i]; j--) {
      dp[j] = max(dp[j], dp[j - L[i]] + J[i]);
    }
  }
  cout << dp[99] << '\n';
}
