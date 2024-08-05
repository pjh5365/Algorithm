#include <bits/stdc++.h>
using namespace std;
int main()
{
    string s;
    cin >> s;

    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] != s[s.length() - 1 - i])
        {
            cout << '0' << '\n';
            return 0;
        }
    }
    cout << '1' << '\n';
    return 0;
}
