#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        
        vector<int> d(n + 1), dp(n + 1), indeg(n + 1);
        vector<vector<int>> graph(n + 1);

        for (int i = 1; i <= n; i++) {
            cin >> d[i];
            dp[i] = d[i];  // 최소 시간은 자기 자신
        }

        for (int i = 0; i < k; i++) {
            int x, y;
            cin >> x >> y;
            graph[x].push_back(y);
            indeg[y]++;   // 진입차수 증가
        }

        int w;
        cin >> w;

        queue<int> q;
        // 진입차수 0인 노드를 큐에 넣는다
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) 
                q.push(i);
        }

        // 위상 정렬
        while (!q.empty()) {
            int cur = q.front(); 
            q.pop();

            for (int nxt : graph[cur]) {
                indeg[nxt]--;
                dp[nxt] = max(dp[nxt], dp[cur] + d[nxt]);

                if (indeg[nxt] == 0) {
                    q.push(nxt);
                }
            }
        }

        cout << dp[w] << "\n";
    }

    return 0;
}
