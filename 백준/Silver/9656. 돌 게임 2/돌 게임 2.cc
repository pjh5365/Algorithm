#include <bits/stdc++.h>
using namespace std;
int N;
int main() {
  cin >> N;
  int count = 0;
  while (N > 0) {
    if (N - 3 > 0) {
      N -= 3;
      count++;
    } else {
      N--;
      count++;
    }
  }
  if (count % 2 == 0)
    cout << "SK" << '\n';
  else
    cout << "CY" << '\n';
}
