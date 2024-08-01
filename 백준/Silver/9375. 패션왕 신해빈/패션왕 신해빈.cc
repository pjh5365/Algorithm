#include <bits/stdc++.h>
using namespace std;
int main()
{
    int T;
    cin >> T;

    while (T > 0)
    {
        int n;
        cin >> n;
        unordered_map<string, int> m;
        string tmp, a;
        for (int i = 0; i < n; i++)
        {
            cin >> tmp >> a;
            if (m.find(a) != m.end())
            {
                m[a]++;
            }
            else
            {
                m[a] = 1;
            }
        }
        int ret = 1;
        for (auto i : m)
            ret *= i.second + 1;
        cout << ret - 1 << '\n';
        T--;
    }
}
