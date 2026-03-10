#include <bits/stdc++.h>
using namespace std;

int main() {
  int t;
  string tmp;
  cin >> t;
  while (t--) {
    int r, c;
    int ret = 0;
    cin >> r >> c;
    char arr[400][400];
    string s;

    for (int i = 0; i < r; i++) {
      cin >> s;
      for (int j = 0; j < c; j++) {
        arr[i][j] = s[j];
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (arr[i][j] == 'o') {
          if (i > 0 && i < r - 1) {
            if (arr[i - 1][j] == 'v' && arr[i + 1][j] == '^') ret++;
          }
          if (j > 0 && j < c - 1) {
            if (arr[i][j - 1] == '>' && arr[i][j + 1] == '<') ret++;
          }
        }
      }
    }
    cout << ret << "\n";
  }
}
