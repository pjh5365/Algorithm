#include <bits/stdc++.h>
using namespace std;

int main()
{
    char arr[50];
    string s;
    cin >> s;
    int len = s.length();
    for (int i = 0; i < len; i++)
    {
        arr[i] = s.at(i);
    }

    for (int i = 0; i < len; i++)
    {
        if (arr[i] == '.')
            continue;

        if (i + 1 < len)
        {
            if (arr[i + 1] == '.') // 실패
            {
                cout << -1 << '\n';
                return 0;
            }
            arr[i] = 'B';
            arr[i + 1] = 'B';
            if (i + 3 < len)
            {
                bool onlyB = false;
                for (int j = i + 1; j < i + 4; j++)
                {
                    if (arr[j] == '.')
                    {
                        i++;
                        onlyB = true;
                        break;
                    }
                }
                if (!onlyB)
                {
                    for (int j = i; j < i + 4; j++)
                        arr[j] = 'A';
                    i += 3;
                }
            }
            else
            {
                i++;
            }
        }
    }
    for (int i = 0; i < len; i++)
    {
        if (arr[i] == 'X')
        {
            cout << -1 << '\n';
            return 0;
        }
    }
    for (int i = 0; i < len; i++)
        cout << arr[i];
    cout << '\n';
}
