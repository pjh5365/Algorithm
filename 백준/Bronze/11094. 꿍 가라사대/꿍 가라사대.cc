#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  string buf;
  cin >> n;
  getline(cin, buf);
  while (n--) {
    getline(cin, s);
    if (s.substr(0, 10)  == "Simon says") {
      cout << s.substr(10) << "\n";
    }
  }

  return 0;
}
