#include <bits/stdc++.h>
using namespace std;
int N, M, ret;
char a[50][50];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
string input;
void bfs(int x, int y) {
  int visited[50][50];
  memset(visited, 0, sizeof(visited));
  queue<tuple<int, int, int>> q;
  q.push({x, y, 1});
  visited[x][y] = 1;
  while (!q.empty()) {
    for (int i = 0; i < 4; i++) {
      int X = get<0>(q.front()) + dx[i];
      int Y = get<1>(q.front()) + dy[i];
      int cnt = get<2>(q.front()) + 1;

      if (X < 0 || X > N - 1 || Y < 0 || Y > M - 1) continue;

      if (visited[X][Y] == 0 && a[X][Y] == 'L') {
        visited[X][Y] = cnt;
        q.push({X, Y, cnt});
        ret = max(ret, visited[X][Y]);
      }
    }
    q.pop();
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> N >> M;
  for (int i = 0; i < N; i++) {
    cin >> input;
    for (int j = 0; j < M; j++) {
      a[i][j] = input.at(j);
    }
  }

  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      if (a[i][j] == 'L') {
        bfs(i, j);
      }
    }
  }
  cout << ret - 1 << '\n';
}
