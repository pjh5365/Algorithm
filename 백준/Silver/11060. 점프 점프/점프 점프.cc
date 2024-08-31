#include <bits/stdc++.h>
using namespace std;
int N, ret = -1;
int a[1000];
int visited[1000];
void bfs() {
  memset(visited, -1, sizeof(visited));
  queue<pair<int, int>> q;
  q.push({0, 0});
  visited[0] = 0;
  while (!q.empty()) {
    for (int i = 1; i <= a[q.front().first]; i++) {
      int X = q.front().first + i;
      int cnt = q.front().second + 1;

      if (X > N - 1) continue;

      if (visited[X] == -1) {
        visited[X] = cnt;
        q.push({X, cnt});
      } else if (visited[X] > cnt) {
        visited[X] = cnt;
        q.push({X, cnt});
      }
    }
    q.pop();
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> N;
  for (int i = 0; i < N; i++) cin >> a[i];
  bfs();
  cout << visited[N - 1] << '\n';
}
