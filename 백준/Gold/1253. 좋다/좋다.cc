#include <bits/stdc++.h>
using namespace std;
int N, A[2000], ret = 0;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  for (int i = 0; i < N; i++) cin >> A[i];
  sort(A, A + N);

  for (int i = 0; i < N; i++) { 
    int sIndex = 0, eIndex = N - 1;
    while (sIndex < eIndex) {
      int sum = A[sIndex] + A[eIndex];
      if (sum == A[i]) {
        if (sIndex != i && eIndex != i) {
          ret++;
          break;
        } else if (sIndex == i)
          sIndex++;
        else if (eIndex == i)
          eIndex--;
      } else if (sum < A[i])
        sIndex++;
      else
        eIndex--;
    }
  }
  cout << ret << '\n';
}
