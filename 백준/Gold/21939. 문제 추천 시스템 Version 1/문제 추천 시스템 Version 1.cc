#include <bits/stdc++.h>
using namespace std;
int N, P, L, M, x;
string command;
set<pair<int, int>> s;      // 문제집
unordered_map<int, int> m;  // 문제와 난이도를 담고 있는 맵
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> N;
  while (N--) {
    cin >> P >> L;
    s.insert({L, P});
    m[P] = L;
  }
  cin >> M;
  while (M--) {
    cin >> command;

    if (command == "recommend") {
      cin >> x;
      if (x == -1)
        cout << (*s.begin()).second << '\n';
      else
        cout << (*prev(s.end())).second << '\n';
    } else if (command == "add") {
      cin >> P >> L;
      s.insert({L, P});
      m[P] = L;  // 들어왔던 문제라면 업데이트
    } else {
      cin >> x;
      s.erase({m[x], x});
    }
  }
}
