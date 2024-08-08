#include <bits/stdc++.h>
using namespace std;
int N;
string p, prefix, suffix, s;
int main()
{
    int N;
    cin >> N;
    cin >> p;
    prefix = p.substr(0, p.find('*'));
    suffix = p.substr(p.find('*') + 1);
    for (int i = 0; i < N; i++)
    {
        cin >> s;
        if (prefix.size() + suffix.size() > s.size())
        {
            cout << "NE" << '\n';
            continue;
        }
        if (prefix == s.substr(0, prefix.length()) && suffix == s.substr(s.size() - suffix.size()))
            cout << "DA" << '\n';
        else
            cout << "NE" << '\n';
    }
}
