#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, m;
  int arr[1000][1000]{};
  int mx[1000]{};
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> arr[i][j];
      mx[i] = max(mx[i], arr[i][j]);
    }
  }

  for (int i = 0; i < m; i++) {
    int ret = 0;
    for (int j = 0; j < n; j++) {
      if (arr[j][i] != mx[j]) {
        ret++;
      }
    }
    cout << ret << " ";
  }
}
