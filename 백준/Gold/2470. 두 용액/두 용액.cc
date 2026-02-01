#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int arr[100000];

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + n);

  int sIdx = 0;
  int eIdx = n - 1;
  int min = 2e9;
  int ret1 = 0;
  int ret2 = 0;

  while (sIdx < eIdx) {
    int now = arr[sIdx] + arr[eIdx];
    if (abs(now) < abs(min)) {
      ret1 = sIdx;
      ret2 = eIdx;
      min = now;
    }
    if (now < 0) {
      sIdx++;
    } else {
      eIdx--;;
    }
  }

  cout << arr[ret1] << " " << arr[ret2];

  return 0;
}
