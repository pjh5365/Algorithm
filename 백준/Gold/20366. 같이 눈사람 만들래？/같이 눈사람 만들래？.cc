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
    int result = 1000000000;

    // 4개가 정렬되어 있다면 arr[0] + arr[3] - (arr[1] + arr[2]) 가 최소값이다.
    for (int l1 = 0; l1 < N; l1++)
    {
        for (int r1 = l1 + 3; r1 < N; r1++)
        {
            int l2 = l1 + 1;
            int r2 = r1 - 1;

            while (l2 < r2)
            {
                result = min(result, abs(arr[l1] + arr[r1] - (arr[l2] + arr[r2])));

                if (arr[l1] + arr[r1] <= arr[l2] + arr[r2])
                    r2--;
                else
                    l2++;
            }
        }
    }
    cout << result << '\n';
    return 0;
}
