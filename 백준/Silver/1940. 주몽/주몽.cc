#include <bits/stdc++.h>
using namespace std;
int N, M;
int a[15000];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N >> M;
  for (int i = 0; i < N; i++) cin >> a[i];
  sort(a, a + N);
  int sIndex = 0, eIndex = N - 1;
  int result = 0;
  while (sIndex < eIndex) {
    int sum = a[sIndex] + a[eIndex];
    if (sum == M) {
      result++;
      sIndex++;
      eIndex--;
    } else if (sum < M)
      sIndex++;
    else
      eIndex--;
  }
  cout << result << '\n';
}
