#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N, M;
    while (true)
    {
        cin >> N >> M;
        if (N == 0 && M == 0)
            break;
        int a[1000000], b[1000000];
        for (int i = 0; i < N; i++)
            cin >> a[i];
        for (int i = 0; i < M; i++)
            cin >> b[i];

        int aIndex = 0;
        int bIndex = 0;
        int ret = 0;
        while (true)
        {
            if (a[aIndex] == b[bIndex])
            {
                ret++;
                aIndex++;
                bIndex++;
            }
            else if (a[aIndex] < b[bIndex])
                aIndex++;
            else
                bIndex++;

            if (aIndex >= N || bIndex >= M)
                break;
        }
        cout << ret << '\n';
    }
}
