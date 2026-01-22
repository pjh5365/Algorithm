#include <bits/stdc++.h>
using namespace std;

int main() {
  int K;
  string S;
  cin >> K >> S;

  for (int i = 0; i < S.length(); i += K) {
    cout << S[i];
  }
  return 0;
}
