#include <bits/stdc++.h>
using namespace std;
string input;
int cnt;
int main() {
  while (1) {
    getline(cin, input);
    if (input == "#") break;
    cnt = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.at(i) == 'a' || input.at(i) == 'e' || input.at(i) == 'i' ||
          input.at(i) == 'o' || input.at(i) == 'u' || input.at(i) == 'A' ||
          input.at(i) == 'E' || input.at(i) == 'I' || input.at(i) == 'O' ||
          input.at(i) == 'U')
        cnt++;
    }
    cout << cnt << '\n';
  }
}
