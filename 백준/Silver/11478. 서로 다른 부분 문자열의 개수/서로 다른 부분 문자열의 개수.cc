#include <bits/stdc++.h>
using namespace std;
int main()
{
    string s;
    cin >> s;
    unordered_set<string> set;
    for (int i = 0; i < s.length(); i++)
    {
        for (int j = 1; j + i <= s.length(); j++)
        {
            set.insert(s.substr(i, j));
        }
    }
    cout << set.size() << '\n';
}
