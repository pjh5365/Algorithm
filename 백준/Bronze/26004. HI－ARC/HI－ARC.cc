#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  int arr[5] = {0};
  string s;
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'H') arr[0]++;
    else if (s[i] == 'I') arr[1]++;
    else if (s[i] == 'A') arr[2]++;
    else if (s[i] == 'R') arr[3]++;
    else if (s[i] == 'C') arr[4]++;
  }

  int ret = 100000;
  for (int i = 0; i < 5; i++) {
    ret = min(arr[i], ret);
  }
  cout << ret;
}
