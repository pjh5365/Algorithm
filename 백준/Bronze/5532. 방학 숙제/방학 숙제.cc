#include <bits/stdc++.h>
using namespace std;
int main() {
  int L, A, B, C, D;
  cin >> L >> A >> B >> C >> D;
  int a = A / C;
  a += A % C != 0 ? 1 : 0;
  int b = B / D;
  b += B % D != 0 ? 1 : 0;

  cout << L - max(a, b) << "\n";
  return 0;
}