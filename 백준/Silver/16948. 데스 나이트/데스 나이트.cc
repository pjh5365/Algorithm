#include <bits/stdc++.h>
using namespace std;
int visited[200][200];
int N, r1, c1, r2, c2;
int dx[] = {-2, -2, 0, 0, 2, 2};
int dy[] = {-1, 1, -2, 2, -1, 1};
void bfs() {
  queue<tuple<int, int, int>> q;
  q.push({r1, c1, 1});
  while (!q.empty()) {
    for (int i = 0; i < 6; i++) {
      int x = get<0>(q.front()) + dx[i];
      int y = get<1>(q.front()) + dy[i];
      int cnt = get<2>(q.front()) + 1;

      if (x < 0 || y < 0 || x > N - 1 || y > N - 1) continue;

      if (visited[x][y] == 0 || visited[x][y] > cnt) {
        visited[x][y] = cnt;
        q.push({x, y, cnt});
      }
    }
    q.pop();
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  cin >> r1 >> c1 >> r2 >> c2;
  bfs();
  cout << visited[r2][c2] - 1 << '\n';
}
