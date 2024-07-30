#include <bits/stdc++.h>
using namespace std;

/**
 * 로그를 보고 현재 회사에 남아있는 사람의 이름 출력하기 (사전순)
 */
int main()
{
    int n;
    cin >> n;
    unordered_set<string> s;

    string name, action;
    for (int i = 0; i < n; i++)
    {
        cin >> name >> action;
        if (action.compare("enter") == 0)
        {
            s.insert(name);
        }
        else
        {
            s.erase(name);
        }
    }
    vector<string> result(s.begin(), s.end());
    sort(result.begin(), result.end(), greater<string>());
    for (auto r : result)
        cout << r << '\n';
}