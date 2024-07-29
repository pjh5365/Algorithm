#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N, M;
    cin >> N >> M;
    int arr[2][50];
    for (int i = 0; i < M; i++)
    {
        cin >> arr[0][i] >> arr[1][i];
    }
    sort(arr[0], arr[0] + M);               // 패키지로 사는경우 정렬
    sort(arr[1], arr[1] + M);               // 낱개로 사는경우 정렬
    int result = arr[0][0] * ((N / 6) + 1); // 전체를 패키지로 사는 경우를 일단 최소값으로 지정
    int i = 0;
    while (i < (N / 6) + 1)
    {
        int tmp = i * 6;
        result = min(result, ((N - tmp) * arr[1][0]) + (arr[0][0] * i));
        i++;
    }

    cout << result << '\n';
}
