#include <bits/stdc++.h>
using namespace std;
int sum[100001];
int tmp;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, K;
    cin >> N >> K;
    for (int i = 1; i <= N; i++)
    {
        cin >> tmp;
        sum[i] = sum[i - 1] + tmp;
    }
    int ret = -1e9;
    for (int i = K; i <= N; i++)
        ret = max(ret, sum[i] - sum[i - K]);
    cout << ret << '\n';
}
