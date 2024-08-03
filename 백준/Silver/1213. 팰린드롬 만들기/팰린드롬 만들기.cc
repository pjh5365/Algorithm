#include <bits/stdc++.h>
using namespace std;
int a[26];
int main()
{
    string input;
    cin >> input;

    for (int i = 0; i < input.length(); i++)
        a[input[i] - 'A']++;
    int count = 0;
    int index = 0;
    for (int i = 0; i < 26; i++)
    {
        if (a[i] % 2 == 1) // 홀수라면 ++
        {
            index = i; // 홀수 인덱스 저장
            count++;
        }
    }

    if (count > 1)
    { // 홀수가 1개 이상이라면 불가능
        cout << "I'm Sorry Hansoo" << '\n';
    }
    else
    {
        for (int i = 0; i < 26; i++) // 앞부분 출력
        {
            for (int j = 0; j < a[i] / 2; j++)
                cout << (char)('A' + i);
        }
        if (count == 1) // 홀수가 1개 있다면 중간에 출력
        {
            cout << (char)('A' + index);
        }
        for (int i = 26; i >= 0; i--) // 뒷부분 출력
        {
            for (int j = 0; j < a[i] / 2; j++)
                cout << (char)('A' + i);
        }
    }
}
