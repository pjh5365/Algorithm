#include <bits/stdc++.h>
using namespace std;

int main() {
  string s;
  cin >> s;

  if (s.length() >= 5) {
    if (s.substr(s.length() - 5) == "driip") cout << "cute";
    else cout << "not cute";
  } else cout << "not cute";
}
