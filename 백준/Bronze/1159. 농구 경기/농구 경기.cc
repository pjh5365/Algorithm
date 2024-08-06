#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N;
    string s;
    cin >> N;
    unordered_map<char, int> map;
    set<char> set;
    for (int i = 0; i < N; i++)
    {
        cin >> s;
        map[s[0]]++;
        set.insert(s[0]);
    }
    bool check = false;
    for (char i : set)
    {
        if (map[i] >= 5)
        {
            cout << i;
            check = true;
        }
    }
    if (!check)
        cout << "PREDAJA" << '\n';
}
