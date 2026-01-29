#include <bits/stdc++.h>
using namespace std;
int main() {
  int y, c, p;
  cin >> y >> c >> p;

  c /= 2;

  cout << min(y, min(c, p));

  return 0;
}
