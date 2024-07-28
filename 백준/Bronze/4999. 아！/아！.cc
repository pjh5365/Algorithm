#include <bits/stdc++.h>

using namespace std;

int main()
{
    string a, b;
    cin >> a;
    cin >> b;

    if (a.find(b) == string::npos)
    {
        cout << "no";
    }
    else
    {
        cout << "go";
    }
}
