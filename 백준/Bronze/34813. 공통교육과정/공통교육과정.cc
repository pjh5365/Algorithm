#include <bits/stdc++.h>
using namespace std;

int main() {
  string s;
  cin >> s;
  if (s[0] == 'F') {
    cout << "Foundation";
  } else if (s[0] == 'C') {
    cout << "Claves";
  } else if (s[0] == 'V') {
    cout << "Veritas";
  } else if (s[0] == 'E') {
    cout << "Exploration";
  }
  return 0;
}