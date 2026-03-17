#include <bits/stdc++.h>
using namespace std;

int main() {
  while (1) {
    int n;
    cin >> n;
    if (n == -1) break;

    vector<int> v;
    int sum = 0;

    for (int i = 1; i < n; i++) {
      if (n % i == 0) v.push_back(i);
    }
    for (int i = 0; i < v.size(); i++) {
      sum += v[i];
    }

    if (sum == n) {
      cout << n << " = ";
      for (int i = 0; i < v.size(); i++) {
        if (i == v.size() - 1) cout << v[i];
        else cout << v[i] << " + ";
      }
    } else {
      cout << n << " is NOT perfect.";
    }


    cout << "\n";
  }
}
