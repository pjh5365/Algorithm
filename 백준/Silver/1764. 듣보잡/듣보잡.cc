#include <bits/stdc++.h>
using namespace std;
int N, M;
string input;
unordered_set<string> s1;
unordered_set<string> s2;
vector<string> v;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> N >> M;

  for (int i = 0; i < N; i++) {
    cin >> input;
    s1.insert(input);
  }
  for (int i = 0; i < M; i++) {
    cin >> input;
    s2.insert(input);
  }

  // sort(s1.begin(), s1.end());
  // sort(s2.begin(), s2.end());

  for (string i : s1) {
    if (s2.find(i) != s2.end()) v.push_back(i);
  }
  sort(v.begin(), v.end());
  cout << v.size() << '\n';
  for (string i : v) cout << i << '\n';
}
