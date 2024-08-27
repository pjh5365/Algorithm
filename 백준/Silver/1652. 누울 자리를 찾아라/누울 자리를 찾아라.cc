#include <bits/stdc++.h>
using namespace std;
int N, ret1, ret2, cnt;
bool check;
char a[100][100];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;

  for (int i = 0; i < N; i++) {
    cnt = 0;
    check = false;
    for (int j = 0; j < N; j++) {
      cin >> a[i][j];
      if (a[i][j] == '.') {
        cnt++;
        if (cnt >= 2 && !check) {
          ret1++;
          check = true;
        }
      } else {
        cnt = 0;
        check = false;
      }
    }
  }

  for (int i = 0; i < N; i++) {
    cnt = 0;
    check = false;
    for (int j = 0; j < N; j++) {
      if (a[j][i] == '.') {
        cnt++;
        if (cnt >= 2 && !check) {
          ret2++;
          check = true;
        }
      } else {
        cnt = 0;
        check = false;
      }
    }
  }
  cout << ret1 << ' ' << ret2 << '\n';
}
