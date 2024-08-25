#include <bits/stdc++.h>
using namespace std;
int N, M;
int dis[1001][1001];
bool visited[1001];
vector<int> graph[1001];
void dfs(int now, int destination, int count) {
  if (now == destination) {
    cout << count << '\n';
    return;
  }
  for (int i : graph[now]) {
    if (!visited[i]) {
      visited[i] = true;
      dfs(i, destination, count + dis[now][i]);
      visited[i] = false;
    }
  }
}
int main() {
  cin >> N >> M;
  int node1, node2, len;
  for (int i = 0; i < N - 1; i++) {
    cin >> node1 >> node2 >> len;
    graph[node1].push_back(node2);
    graph[node2].push_back(node1);
    dis[node1][node2] = len;
    dis[node2][node1] = len;
  }
  for (int i = 0; i < M; i++) {
    cin >> node1 >> node2;
    visited[node1] = true;
    dfs(node1, node2, 0);
    visited[node1] = false;
  }
}
