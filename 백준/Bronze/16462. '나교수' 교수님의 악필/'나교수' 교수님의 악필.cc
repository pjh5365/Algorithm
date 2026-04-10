#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  string q;
  double sum = 0;
  cin >> n;
  for (int N = 0; N < n; N++) {
    cin >> q;
    for (int i = 0; i < q.length(); i++) {
      if (q[i] == '0' || q[i] == '6') q[i] = '9';
    }
    int num = stoi(q);
    if (num > 100) num = 100;
    sum += num;
  }
  cout << round(sum / n);
}
