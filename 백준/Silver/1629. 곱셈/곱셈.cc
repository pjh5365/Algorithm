#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll A, B, C;
ll find(ll a, ll b) {
  if (b == 1) return a % C;
  ll ret = find(a, b / 2);
  ret = (ret * ret) % C;
  if (b % 2) ret = (ret * a) % C;  // 홀수라면 1개 곱해줘야 한다.
  return ret;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> A >> B >> C;
  cout << find(A, B) << '\n';
}
