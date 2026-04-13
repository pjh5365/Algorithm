#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, tmp;
  int arr[51] = {0};
  cin >> n;
  while (n--) {
    cin >> tmp;
    arr[tmp]++;
  }

  int ret = -1;
  for (int i = 0; i <= 50; i++) {
    if (i == arr[i]) ret = i;
  }
  cout << ret;
}
