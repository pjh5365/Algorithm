#include <bits/stdc++.h>
using namespace std;
int ret[100][100];
char m[100][100];
int H, W;
queue<pair<int, int>> q;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> H >> W;
  for (int i = 0; i < H; i++) {
    for (int j = 0; j < W; j++) {
      cin >> m[i][j];
      if (m[i][j] == 'c') q.push({i, j});
    }
  }
  while (!q.empty()) {
    pair<int, int> now = q.front();
    q.pop();
    for (int i = now.second + 1; i < W; i++) {
      if (m[now.first][i] == 'c') break;
      ret[now.first][i] = ret[now.first][i - 1] + 1;
    }
  }
  for (int i = 0; i < H; i++) {
    for (int j = 0; j < W; j++) {
      if (ret[i][j] == 0) {
        if (m[i][j] == 'c')
          cout << 0 << ' ';
        else
          cout << -1 << ' ';
      } else {
        cout << ret[i][j] << ' ';
      }
    }
    cout << '\n';
  }
}
