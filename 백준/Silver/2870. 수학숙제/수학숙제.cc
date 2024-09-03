#include <bits/stdc++.h>
using namespace std;
int N;
string input;
vector<string> v;
bool cmp(string a, string b) {
  if (a.length() < b.length()) return true;
  if (a.length() == b.length()) return a.compare(b) < 0;
  return false;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  int cnt;
  for (int i = 0; i < N; i++) {
    cin >> input;
    string tmp;
    for (int j = 0; j < input.length(); j++) {
      if (input.at(j) <= '9' && input.at(j) >= '0') {
        tmp += input.at(j);
      } else if (tmp.length()) {  // tmp가 있을때만
        cnt = 0;
        for (int l = 0; l < tmp.length(); l++) {
          if (tmp.at(l) != '0') {
            cnt = 0;
            tmp = tmp.substr(l);
            break;
          } else {
            cnt++;
          }
        }
        if (cnt == tmp.length()) tmp = "0";
        v.push_back(tmp);
        tmp = "";
      }
    }
    if (tmp.length()) {
      cnt = 0;
      for (int l = 0; l < tmp.length(); l++) {
        if (tmp.at(l) != '0') {
          cnt = 0;
          tmp = tmp.substr(l);
          break;
        } else {
          cnt++;
        }
      }
      if (cnt == tmp.length()) tmp = "0";
      v.push_back(tmp);
      tmp = "";
    }
  }

  sort(v.begin(), v.end(), cmp);
  for (string i : v) {
    cout << i << '\n';
  }
}
