#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N;
    int arr[1000];
    int result[1000];
    fill(result, result + 1000, 0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    for (int i = 0; i < N; i++)
    {
        if (i % 2 == 1)
        {
            result[0] -= arr[i];
        }
        else
        {
            result[0] += arr[i];
        }
    }
    result[0] /= 2;
    cout << result[0] << '\n';
    for (int i = 1; i < N; i++)
    {
        result[i] = arr[i - 1] - result[i - 1];
        cout << result[i] << '\n';
    }
}