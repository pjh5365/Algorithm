#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll N, P, Q;
unordered_map<ll, ll> m;
ll solve(ll x) {
  // A0 = 1
  if (x == 0) return 1;
  // 이미 값이 존재한다면 리턴 (DP)
  if (m[x]) return m[x];
  // Ai의 값 계산
  m[x] = solve(x / P) + solve(x / Q);
  return m[x];
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> N >> P >> Q;
  cout << solve(N) << '\n';
}
