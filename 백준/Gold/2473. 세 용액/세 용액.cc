#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int N;
ll a[5000], ret[3] = {3000000000, 3000000000, 3000000000};
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> N;
  for (int i = 0; i < N; i++) cin >> a[i];

  sort(a, a + N);

  for (int i = 0; i < N; i++) {
    for (int j = i + 1; j < N; j++) {
      int sum = a[i] + a[j];
      int idx = lower_bound(a, a + N, -sum) - a;

      for (int k = -2; k <= 2; k++) {  // 최적의 용액이 음수에 있는 경우도 추가해서 계산
        if (idx + k < 0 || idx + k >= N) continue;
        if (idx + k == i || idx + k == j) continue;
        if (abs(ret[0] + ret[1] + ret[2]) > abs(a[i] + a[j] + a[idx + k])) {
          tie(ret[0], ret[1], ret[2]) = {a[i], a[j], a[idx + k]};
        }
      }
    }
  }
  sort(ret, ret + 3);
  cout << ret[0] << ' ' << ret[1] << ' ' << ret[2] << '\n';
}
