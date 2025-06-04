#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<int> graph[10001];
bool visited[10001];
int result[10001];

int dfs(int now) {
    visited[now] = true;
    int ret = 1;
    for (int next : graph[now]) {
        if (!visited[next]) {
            ret += dfs(next);
        }
    }
    return ret;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> N >> M;
    
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        graph[b].push_back(a);
    }

    int maxValue = 0;

    for (int i = 1; i <= N; i++) {
        memset(visited, false, sizeof(visited));
        result[i] = dfs(i);
        maxValue = max(maxValue, result[i]);
    }

    for (int i = 1; i <= N; i++) {
        if (result[i] == maxValue) {
            cout << i << " ";
        }
    }

    cout << "\n";
    return 0;
}
