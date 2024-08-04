#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N, M;
    cin >> N >> M;
    string teamName, name;
    int teamNum;
    unordered_map<string, vector<string>> m1;
    unordered_map<string, string> m2;
    while (N > 0)
    {
        cin >> teamName;
        cin >> teamNum;
        for (int i = 0; i < teamNum; i++)
        {
            cin >> name;
            m1[teamName].push_back(name);
            m2[name] = teamName;
        }
        sort(m1[teamName].begin(), m1[teamName].end());
        N--;
    }
    int type;
    for (int i = 0; i < M; i++)
    {
        cin >> name;
        cin >> type;
        if (type == 0)
        {
            for (string s : m1[name])
                cout << s << '\n';
        }
        else
        {
            cout << m2[name] << '\n';
        }
    }
}
