#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N, M;
    cin >> N >> M;

    unordered_map<string, string> m;
    string site;
    string pw;
    for (int i = 0; i < N; i++)
    {
        cin >> site >> pw;
        m.insert({site, pw});
    }
    for (int i = 0; i < M; i++)
    {
        cin >> site;
        cout << m[site] << '\n';
    }
}
