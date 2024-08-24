#include <bits/stdc++.h>
using namespace std;
int a[5][5];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
unordered_set<string> nums;
void dfs(int x, int y, string s) {
  if (s.size() == 6) {
    nums.insert(s);
    return;
  }
  for (int i = 0; i < 4; i++) {
    int X = x + dx[i];
    int Y = y + dy[i];

    if (X < 0 || X > 4 || Y < 0 || Y > 4) continue;

    dfs(X, Y, s + to_string(a[X][Y]));
  }
}
int main() {
  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) cin >> a[i][j];
  }

  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) dfs(i, j, "");
  }

  cout << nums.size() << '\n';
}
