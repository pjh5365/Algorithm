#include <bits/stdc++.h>
using namespace std;
int N, tmp;
priority_queue<int> q;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  while (N--) {
    cin >> tmp;
    if (tmp == 0) {
      if (q.size() == 0) {
        cout << '0' << '\n';
      } else {
        cout << q.top() << '\n';
        q.pop();
      }
    } else {
      q.push(tmp);
    }
  }
}
