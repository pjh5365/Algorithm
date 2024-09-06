#include <bits/stdc++.h>
using namespace std;
string input;
int T, N, A, B;
int main() {
  cin >> T;
  while (T--) {
    cin >> N;
    while (N--) {
      cin >> A >> B;
      cout << A + B << ' ';
      cout << A * B << '\n';
    }
  }
}
