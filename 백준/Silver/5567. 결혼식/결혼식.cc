#include <bits/stdc++.h>
using namespace std;
int n, m, a, b;
vector<int> adj[501];
unordered_set<int> s;
void dfs(int now, int depth) {
  // 친구의 친구까지만 초대
  if (depth == 2) {
    return;
  }
  for (int i : adj[now]) {
    if (i != 1) s.insert(i);  // 상근이는 제외
    dfs(i, depth + 1);
  }
}
int main() {
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    cin >> a >> b;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  dfs(1, 0);
  cout << s.size() << '\n';
}
