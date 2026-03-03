#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  while (n--) {
    string a, b, c, d;
    cin >> a >> b;
    c = a;
    d = b;

    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    if (a == b) cout << c << " & " << d << " are anagrams.\n";
    else cout << c << " & " << d << " are NOT anagrams.\n";
  }
}
