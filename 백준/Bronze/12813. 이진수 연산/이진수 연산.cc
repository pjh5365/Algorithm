#include <bits/stdc++.h>
using namespace std;

int main() {
  bitset<100000> a, b;
  cin >> a >> b;
  cout << (a & b) << "\n";
  cout << (a | b) << "\n";
  cout << (a ^ b) << "\n";
  cout << (~a) << "\n";
  cout << (~b) << "\n";
}
