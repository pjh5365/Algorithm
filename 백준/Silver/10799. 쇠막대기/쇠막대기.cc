#include <bits/stdc++.h>
using namespace std;
string line;
int ret;
stack<char>s;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> line;

	for (int i = 0; i < line.length(); i++) {
		if (line[i] == '(')
			s.push(line[i]);
		else {
			s.pop();
			if (line[i - 1] == '(') ret += s.size();
			else ret++;
		}
	}
	cout << ret << '\n';
}
