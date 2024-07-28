#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n = 1;

    while (true)
    {
        cin >> n;

        if (n == 0)
        {
            return 0;
        }

        int result = 0;
        for (int i = 1; i <= n; i++)
        {
            result += i;
        }

        cout << result << '\n';
    }
}
