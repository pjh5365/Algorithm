#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, a = 0, b = 0;
    string s;
    cin >> n;
    while (n--) {
      cin >> s;
      if (abs(a - b) >= 2) continue;
      if (s[0] == 'D') a++;
      else b++;

    }

    cout << a << ":" << b;

    return 0;
}
