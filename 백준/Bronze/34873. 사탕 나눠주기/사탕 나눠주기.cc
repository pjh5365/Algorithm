#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, tmp;
  int arr[100001] = {0};

  cin >> n;
  for (int i = 0; i < 2 * n; i++) {
    cin >> tmp;
    arr[tmp]++;
  }

  for (int i = 1; i <= 2 * n; i++) {
    if (arr[i] > 2) {
      cout << "No";
      return 0;
    }
  }
  cout << "Yes";
}
