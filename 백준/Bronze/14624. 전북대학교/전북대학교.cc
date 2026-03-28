#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  if (n % 2 != 0) {
    for (int i = 0; i < n; i++) cout << "*";
    cout << "\n";
    int mid = n / 2;
    for (int i = 0; i < mid; i++) cout << " ";
    cout << "*" << "\n";
    for (int i = 1; i <= mid; i++) {
      for (int j = 0; j < mid - i; j++) cout << " ";
      cout << "*";
      for (int j = mid - i + 1; j < mid + i; j++) cout << " ";
      cout << "*" << "\n";
    }
  } else cout << "I LOVE CBNU";
}
