#include <bits/stdc++.h>
using namespace std;
static bool comp(pair<string, int> &a, pair<string, int> &b)
{
    return a.second < b.second;
}
int main()
{
    int K, L;
    cin >> K >> L;
    string s;
    unordered_map<string, int> m;
    for (int i = 0; i < L; i++)
    {
        cin >> s;
        m[s] = i;
    }
    vector<pair<string, int>> v(m.begin(), m.end());
    sort(v.begin(), v.end(), comp);
    int count = 0;
    for (auto i : v)
    {
        cout << i.first << '\n';
        count++;
        if (count == K)
            break;
    }
}
