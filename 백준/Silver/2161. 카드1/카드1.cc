#include <bits/stdc++.h>
using namespace std;
int N;
queue<int> q;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  for (int i = 1; i <= N; i++) q.push(i);
  while (!q.empty()) {
    cout << q.front() << ' ';
    q.pop();
    if (q.empty()) break;
    int tmp = q.front();
    q.pop();
    q.push(tmp);
  }
}
