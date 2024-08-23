#include <bits/stdc++.h>
using namespace std;
int M, tmp;
string s;
unordered_map<string, int> drink;
unordered_map<int, int> total;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> M;
  for (int i = 0; i < M; i++) {
    cin >> s >> tmp;
    drink[s] += tmp;
  }

  for (auto i : drink) total[i.second] += 1;
  for (auto i : drink) {
    int cal = floor(i.second * 1.618);
    if (total[cal] >= 1) {
      if (total[cal] == 1 && cal == i.second) {
        cout << "Not Delicious..." << '\n';
        return 0;
      }
      cout << "Delicious!" << '\n';
      return 0;
    }
  }
  cout << "Not Delicious..." << '\n';
}
