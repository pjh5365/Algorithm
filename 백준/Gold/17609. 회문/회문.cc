#include <bits/stdc++.h>
using namespace std;
int T, ret;
string s;
void check(int left, int right, bool isRemoved) {
  while (left < right) {
    if (s[left] == s[right]) {
      left++;
      right--;
    } else {
      if (isRemoved) {
        if (ret == 100) ret = 2; // 이번 탐색이 최초탐색이라면
        return;
      }
      check(left + 1, right, true);
      check(left, right - 1, true);
      return;
    }
  }
  ret = isRemoved;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> T;
  while (T > 0) {
    cin >> s;
    ret = 100;
    check(0, s.length() - 1, false);
    cout << ret << '\n';
    T--;
  }
}
