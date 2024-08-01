#include <bits/stdc++.h>
using namespace std;
int a[26];
int main()
{
    string input;
    cin >> input;
    for (int i = 0; i < input.length(); i++)
    {
        a[input.at(i) - 'a']++;
    }
    for (auto i : a)
        cout << i << ' ';
}
