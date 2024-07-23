#include <bits/stdc++.h>
using namespace std;
int main()
{
    int H, I, A, R, C;
    cin >> H >> I >> A >> R >> C;
    int result = (H * I) - (A * R * C);
    cout << result << '\n';
}