#include <bits/stdc++.h>
using namespace std;
set<int> s;
int N, Q, input, x, tmp, now = 1;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N >> Q;
  for (int i = 1; i <= N; i++) {
    cin >> tmp;
    if (tmp) s.insert(i);  // 명소라면 인덱스 저장
  }
  while (Q--) {
    cin >> input;
    if (input == 1) {
      cin >> x;
      if (s.find(x) != s.end())  // 이미 명소라면 명소에서 제거
        s.erase(x);
      else  // 명소가 아니라면 명소에 추가
        s.insert(x);
    } else if (input == 2) {
      cin >> x;
      now = (now + x - 1) % N + 1;  // 이동
    } else {
      if (s.empty())
        cout << -1 << '\n';
      else {
        auto index = s.lower_bound(now); // 같거나 큰값의 위치
        if (index != s.end())
          cout << *index - now << '\n';
        else
          cout << N - now + *(s.begin()) << '\n';
      }
    }
  }
}
