#include <bits/stdc++.h>
using namespace std;
int main() {
  int N, K;
  cin >> N >> K;

  for (int i = 0; i < N - 1; i++) {
    K /= 2;
  }
  cout << K;
}