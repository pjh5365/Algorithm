#include <bits/stdc++.h>
using namespace std;
int N, m1, m2, ret = 100;
vector<int> v[51];
vector<int> retV;
int visited[51];
void bfs(int now) {
  memset(visited, 0, sizeof(visited));
  queue<pair<int, int>> q;
  q.push({now, 0});
  visited[now] = 1;
  while (!q.empty()) {
    for (int i : v[q.front().first]) {
      int cnt = q.front().second + 1;
      if (visited[i] == 0 || visited[i] > cnt) {
        visited[i] = cnt;
        q.push({i, cnt});
      }
    }
    q.pop();
  }
  int maxValue = 0;
  for (int i = 1; i <= N; i++) maxValue = max(maxValue, visited[i]);

  if (ret > maxValue) {
    ret = maxValue;
    retV.clear();
    retV.push_back(now);
  } else if (ret == maxValue) {
    retV.push_back(now);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  while (true) {
    cin >> m1 >> m2;
    if (m1 == -1 && m2 == -1) break;

    v[m1].push_back(m2);
    v[m2].push_back(m1);
  }

  for (int i = 1; i <= N; i++) bfs(i);

  sort(retV.begin(), retV.end());

  cout << ret << ' ' << retV.size() << '\n';
  for (int i : retV) cout << i << ' ';
  cout << '\n';
}
