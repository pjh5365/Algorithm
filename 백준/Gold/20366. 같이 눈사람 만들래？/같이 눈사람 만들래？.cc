#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    int arr[600];
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + N);

    int result = 1'000'000'000;

    for (int i1 = 0; i1 < N; i1++)
    {
        for (int i2 = i1 + 3; i2 < N; i2++)
        {
            int j1 = i1 + 1, j2 = i2 - 1;

            while (j1 < j2)
            {
                result = min(result, abs(arr[i1] + arr[i2] - arr[j1] - arr[j2]));

                if (arr[i1] + arr[i2] <= arr[j1] + arr[j2])
                    j2--;
                else
                    j1++;
            }
        }
    }

    cout << result << '\n';
    return 0;
}
