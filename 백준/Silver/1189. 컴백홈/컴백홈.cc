#include <bits/stdc++.h>
using namespace std;
int R, C, K, ret;
char a[5][5];
bool visited[5][5];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
void dfs(int x, int y, int count) {
  if (x == 0 && y == C - 1) {
    if (count == K) ret++;
    return;
  }
  for (int i = 0; i < 4; i++) {
    int X = x + dx[i];
    int Y = y + dy[i];

    if (X < 0 || X > R - 1 || Y < 0 || Y > C - 1) continue;

    if (!visited[X][Y] && a[X][Y] != 'T') {
      visited[X][Y] = true;
      dfs(X, Y, count + 1);
      visited[X][Y] = false;
    }
  }
}
int main() {
  cin >> R >> C >> K;
  string s;
  for (int i = 0; i < R; i++) {
    cin >> s;
    for (int j = 0; j < C; j++) {
      a[i][j] = s.at(j);
    }
  }
  visited[R - 1][0] = true;
  dfs(R - 1, 0, 1);

  cout << ret << '\n';
}
