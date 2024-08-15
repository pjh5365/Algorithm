#include <bits/stdc++.h>
using namespace std;
int N, M;
string input;
unordered_map<string, int> m1;
unordered_map<int, string> m2;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> N >> M;
  for (int i = 1; i <= N; i++) {
    cin >> input;
    m1[input] = i;
    m2[i] = input;
  }
  while (M--) {
    cin >> input;
    if (atoi(input.c_str()) == 0)
      cout << m1[input] << '\n';
    else
      cout << m2[atoi(input.c_str())] << '\n';
  }
}
