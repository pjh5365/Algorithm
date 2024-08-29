#include <bits/stdc++.h>
using namespace std;
int N, M, sI, eI, tmp;
int sum[100001];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  for (int i = 1; i <= N; i++) {
    cin >> tmp;
    sum[i] = sum[i - 1] + tmp;
  }
  cin >> M;
  for (int i = 0; i < M; i++) {
    cin >> sI >> eI;
    cout << sum[eI] - sum[sI - 1] << '\n';
  }
}
