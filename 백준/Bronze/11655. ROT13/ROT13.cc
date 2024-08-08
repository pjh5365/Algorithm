#include <bits/stdc++.h>
using namespace std;
int main()
{
    string s;
    getline(cin, s);
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] >= 65 && s[i] <= 77)
            cout << (char)(s[i] + 13);
        else if (s[i] >= 78 && s[i] <= 90)
            cout << (char)(s[i] - 13);
        else if (s[i] >= 97 && s[i] <= 109)
            cout << (char)(s[i] + 13);
        else if (s[i] >= 109 && s[i] <= 122)
            cout << (char)(s[i] - 13);
        else
            cout << s[i];
    }

    cout << '\n';
}
