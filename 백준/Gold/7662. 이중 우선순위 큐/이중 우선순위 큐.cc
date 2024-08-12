#include <bits/stdc++.h>
using namespace std;
int T, k, Q;
char input;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> T;
  while (T--) {
    cin >> k;
    multiset<int> s;
    while (k--) {
      cin >> input;
      if (input == 'D') {
        cin >> Q;
        if (s.empty()) continue;
        if (Q == 1)
          s.erase(prev(s.end()));  // 이진 검색트리의 마지막 값 (최대값) 제거
        else
          s.erase(s.begin());  // 이진 검색트리의 첫번째 값 (최소값) 제거
      } else {
        cin >> Q;
        s.insert(Q);
      }
    }
    if (s.empty())
      cout << "EMPTY" << '\n';
    else
      cout << *prev(s.end()) << ' ' << *s.begin() << '\n';
  }
}
