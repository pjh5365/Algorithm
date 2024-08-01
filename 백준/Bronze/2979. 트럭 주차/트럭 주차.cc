#include <bits/stdc++.h>
using namespace std;
int input[4];
int a[101];
int main()
{
    cin >> input[1] >> input[2] >> input[3];

    int s, e;
    for (int i = 0; i < 3; i++)
    {
        cin >> s >> e;
        for (int j = s; j < e; j++)
            a[j]++;
    }
    int ret = 0;
    for (int i : a)
        ret += input[i] * i;
    cout << ret << '\n';
}
