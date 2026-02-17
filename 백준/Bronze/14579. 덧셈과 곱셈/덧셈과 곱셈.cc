#include <bits/stdc++.h>
using namespace std;

int main() {
    int a, b;

    cin >> a >> b;

    int ret = 0;
    for (int i = 1; i <= a; i++) ret += i;

    int tmp = ret;
    for (int i = a + 1; i <= b; i++) {
      tmp += i;
      ret *= tmp;
      ret %= 14579;
    }
    cout << ret;

    return 0;
}
