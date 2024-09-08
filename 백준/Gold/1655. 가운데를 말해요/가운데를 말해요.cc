#include <bits/stdc++.h>
using namespace std;
int N, tmp;
priority_queue<int> maxQ;
priority_queue<int, vector<int>, greater<int>> minQ;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  while (N--) {
    cin >> tmp;
    if (maxQ.empty() ||
        maxQ.size() == minQ.size())  // 최대큐가 비어있거나 개수가 동일할 때
      maxQ.push(tmp);
    else  // 아니라면 최소큐에
      minQ.push(tmp);

    // 값을 교환해야하는 경우
    if ((!maxQ.empty() && !minQ.empty()) && maxQ.top() > minQ.top()) {
      int t1 = maxQ.top();
      int t2 = minQ.top();
      maxQ.pop();
      minQ.pop();
      minQ.push(t1);
      maxQ.push(t2);
    }
    // 최대큐의 값을 먼저 추가하므로 항상 최대큐출력
    cout << maxQ.top() << '\n';
  }
}
