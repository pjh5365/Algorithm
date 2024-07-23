#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;
    int score[101];

    for (int i = 0; i < N; i++)
    {
        cin >> score[i];
    }

    int max = -100;
    int result = 100;
    for (int i = 0; i < M; i++)
    {
        int sum = 0;
        char tmp = 0;
        int now = 0;
        cin >> now;
        for (int j = 0; j < N; j++)
        {
            cin >> tmp;
            if (tmp == 'O')
            {
                sum += score[j];
            }
        }
        if (sum > max)
        {
            result = now;
            max = sum;
        }
        else if (sum == max && result > now)
        {
            result = now;
            max = sum;
        }
    }

    cout << result << ' ' << max << '\n';
}