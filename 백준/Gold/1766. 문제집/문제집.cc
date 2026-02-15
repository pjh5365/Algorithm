#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, m, a, b;
    cin >> n >> m;
    vector<int> deg(n + 1);
    vector<vector<int>> graph(n + 1);
    for (int i = 0; i < m; i++) {
      cin >> a >> b;
      graph[a].push_back(b);
      deg[b]++;
    }

    priority_queue<int> q;
    for (int i = 1; i <= n; i++) {
      if (deg[i] == 0) {
        q.push(-i);
      }
    }

    while (!q.empty()) {
      int now = -q.top();
      q.pop();

      cout << now << " ";

      for (int next : graph[now]) {
        deg[next]--;
        if (deg[next] == 0) {
          q.push(-next);
        }
      }
    }

    return 0;
}
