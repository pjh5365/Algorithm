#include <bits/stdc++.h>
using namespace std;
int N, a[100000];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  for (int i = 0; i < N; i++) cin >> a[i];

  int sIndex = 0, eIndex = N - 1;
  int ret1 = 0, ret2 = N - 1;
  int min = 2e9;
  while (sIndex < eIndex) {
    int tmp = a[sIndex] + a[eIndex];
    if (abs(tmp) < abs(min)) {
      min = tmp;
      ret1 = sIndex;
      ret2 = eIndex;
    }
    if (abs(a[sIndex] + a[eIndex - 1]) <= abs(a[sIndex + 1] + a[eIndex]))
      eIndex--;
    else
      sIndex++;
  }
  cout << a[ret1] << ' ' << a[ret2] << '\n';
}
