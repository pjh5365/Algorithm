#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int A[1001], B[1001];
ll dpA[1001], dpB[1001];
int T, n, m;
ll ret;
vector<int> v1, v2;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> T >> n;
  for (int i = 1; i <= n; i++) {
    cin >> A[i];
    dpA[i] = dpA[i - 1] + A[i];
  }
  cin >> m;
  for (int i = 1; i <= m; i++) {
    cin >> B[i];
    dpB[i] = dpB[i - 1] + B[i];
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 0; j < i; j++) {
      v1.push_back(dpA[i] - dpA[j]);
    }
  }

  for (int i = 1; i <= m; i++) {
    for (int j = 0; j < i; j++) {
      v2.push_back(dpB[i] - dpB[j]);
    }
  }

  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());

  for (int i : v1) {
    int find = T - i;  // 필요한 값
    // 필요한 값의 개수 구하기
    ret += upper_bound(v2.begin(), v2.end(), find) -
           lower_bound(v2.begin(), v2.end(), find);
  }
  cout << ret << '\n';
}
