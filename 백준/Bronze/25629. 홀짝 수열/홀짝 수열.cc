#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, tmp;
  cin >> n;
  vector<int> v1;
  vector<int> v2;
  while (n--) {
    cin >> tmp;
    if (tmp % 2 != 0) v1.push_back(tmp);
    else v2.push_back(tmp);
  }

  int ret = v1.size() - v2.size();

  if (ret >= 0 && ret <= 1) cout << "1";
  else cout << "0";
}
