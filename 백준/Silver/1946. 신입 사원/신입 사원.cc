#include <bits/stdc++.h>
using namespace std;
int main()
{
    int T, N;
    cin >> T;
    pair<int, int> p[100000];
    while (T > 0)
    {
        cin >> N;
        for (int i = 0; i < N; i++)
        {
            cin >> p[i].first >> p[i].second;
        }
        sort(p, p + N); // 서류등수로 정렬
        int result = 1;
        int min = p[0].second; // 서류 1등의 면접등수, 해당 등수보다 숫자가 낮아야 통과가능
        for (int i = 1; i < N; i++)
        {
            if (p[i].second < min)
            {
                result++;
                min = p[i].second;
            }
        }
        cout << result << '\n';
        T--;
    }
}
