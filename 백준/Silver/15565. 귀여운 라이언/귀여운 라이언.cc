#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N, K;
    cin >> N >> K;
    vector<int> v;
    int input;
    for (int i = 0; i < N; i++)
    {
        cin >> input;
        if (input == 1) // 라이언 인형의 인덱스만 삽입
            v.push_back(i);
    }
    if (v.size() < K)
        cout << -1 << '\n';
    else
    {
        int ret = 1e9;
        int sIndex = 0, eIndex = K - 1;
        for (int i = 0; i <= v.size() - K; i++)
        {
            ret = min(ret, v[eIndex] - v[sIndex] + 1);
            sIndex++;
            eIndex++;
        }
        cout << ret << '\n';
    }
}
