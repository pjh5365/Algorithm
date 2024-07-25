#include <bits/stdc++.h>
using namespace std;
int main()
{
    int T, N;
    int arr[10];
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> N;
        fill(arr, arr + 10, 0);
        int sum = 0;
        int count = 0;
        bool fail = false;
        string now = "";

        while (sum < 10)
        {
            sum = 0;
            now = to_string(N * (count + 1));
            for (int j = 0; j < now.length(); j++)
            {
                arr[now.at(j) - '0'] = 1;
            }
            for (int j = 0; j < 10; j++)
            {
                sum += arr[j];
            }
            count++;
            if (count > 1000000)
            {
                fail = true;
                break;
            }
        }

        if (fail)
            cout << "Case #" << i + 1 << ": INSOMNIA" << '\n';
        else
            cout << "Case #" << i + 1 << ": " << now << '\n';
    }
}
