// 참고: https://github.com/encrypted-def/basic-algo-lecture/blob/master/0x15/solutions/20166.cpp
#include <bits/stdc++.h>
using namespace std;
int dx[8] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy[8] = {1, -1, 0, 0, 1, -1, 1, -1};
string m[10];
int N, M, K;
unordered_map<string, int> cnt; // 만들 수 있는 문자열 조합을 미리 계산
void dfs(int x, int y, string s)
{
    cnt[s]++;
    if (s.size() == 5)
        return;
    for (int i = 0; i < 8; i++)
    {
        // 배열을 벗어나는경우 다음칸으로 자동이동됨
        int X = (x + dx[i] + N) % N;
        int Y = (y + dy[i] + M) % M;
        dfs(X, Y, s + m[X][Y]);
    }
}
int main()
{
    cin >> N >> M >> K;
    for (int i = 0; i < N; i++)
        cin >> m[i];
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            dfs(i, j, string(1, m[i][j]));
    for (int i = 0; i < K; i++)
    {
        string s;
        cin >> s;
        cout << cnt[s] << '\n';
    }
}
