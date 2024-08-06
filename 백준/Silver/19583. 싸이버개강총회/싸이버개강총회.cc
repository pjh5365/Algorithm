#include <bits/stdc++.h>
using namespace std;
int main()
{
    string S, E, Q, t, nick;
    cin >> S >> E >> Q;
    unordered_set<string> us;
    int ret = 0;
    while (1)
    {
        cin >> t >> nick;
        if (cin.eof() == true)
            break;

        if (t <= S)
        {
            us.insert(nick);
        }
        else if (t <= Q && t >= E && (us.find(nick) != us.end()))
        {
            ret++;
            us.erase(nick);
        }
    }
    cout << ret << '\n';
}
