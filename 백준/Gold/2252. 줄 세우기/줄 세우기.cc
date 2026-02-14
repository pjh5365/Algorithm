#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;
    int a, b;

    vector<int> idx(n + 1);
    vector<int> deg(n + 1);
    vector<vector<int>> graph(n + 1);

    for (int i = 1; i <= n; i++) {
      idx[i] = i;
    }

    for (int i = 0; i < m; i++) {
      cin >> a >> b;
      graph[a].push_back(b);
      deg[b]++;
    }

    queue<int> q;
    for (int i = 1; i <= n; i++) {
      if (deg[i] == 0) {
        q.push(i);
      }
    }

    while (!q.empty()) {
      int cur = q.front();
      q.pop();
      cout << cur << " ";

      for (int next : graph[cur]) {
        deg[next]--;

        if (idx[cur] > idx[next]) {
          int tmp = idx[cur];
          idx[cur] = idx[next];
          idx[next] = tmp;
        }

        if (deg[next] == 0) {
          q.push(next);
        }
      }
    }

    return 0;
}
