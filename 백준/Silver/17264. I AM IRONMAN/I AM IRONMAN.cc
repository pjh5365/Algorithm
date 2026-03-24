#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, p, w, l, g;
  string a, b;
  cin >> n >> p;
  map<string, string> m;
  cin >> w >> l >> g;
  while (p--) {
    cin >> a >> b;
    m.insert({a, b});
  }

  int ret = 0;
  while (n--) {
    cin >> a;
    if (m[a] == "W") ret += w;
    else {
      ret -= l;
      if (ret < 0) {
        ret = 0;
      }
    }
    if (ret >= g) {
      cout << "I AM NOT IRONMAN!!";
      return 0;
    }
  }
  cout << "I AM IRONMAN!!"; 
}
