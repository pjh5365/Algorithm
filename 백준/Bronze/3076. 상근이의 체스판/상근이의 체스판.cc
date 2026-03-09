#include <bits/stdc++.h>
using namespace std;

int main() {
  int r, c, a, b;
  cin >> r >> c >> a >> b;

  for (int i = 0; i < r; i++) {
    for (int j = 0; j < a; j++) {
      for (int l = 0; l < c; l++) {
        if ((i + l) % 2 == 0) {
          for (int k = 0; k < b; k++) {
            cout << "X";
          }
        } else {
          for (int k = 0; k < b; k++) {
            cout << ".";
          }
        }
      }
      cout << "\n";
    }
  }
}
