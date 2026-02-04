#include <bits/stdc++.h>
using namespace std;
int main() {
  int v, a = 0, b = 0;
  string s;
  cin >> v;
  cin >> s;

  for (int i = 0; i < s.length(); i++) {
    if (s[i] == 'A') a++;
    else b++;
  }

  if (a > b) cout << "A";
  else if (a < b) cout << "B";
  else cout << "Tie";

  return 0;
}
