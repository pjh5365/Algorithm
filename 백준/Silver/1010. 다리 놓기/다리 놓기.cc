#include <bits/stdc++.h>
using namespace std;
int main()
{
    int T;
    cin >> T;
    int N, M;
    while (T > 0)
    {
        cin >> N >> M;
        int result = 1;
        int tmp = 1;
        for (int i = M; i > M - N; i--)
        {
            result *= i;
            result /= tmp++;
        }
        cout << result << '\n';
        T--;
    }
}
