#include <bits/stdc++.h>
using namespace std;
string input;
string bomb;
stack<char> s1;
stack<char> s2;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cin >> input >> bomb;

	for (int i = 0; i < input.length(); i++) {
		s1.push(input[i]);
		if (s1.top() == bomb[bomb.length() - 1]) {
			bool isRemoved = true;
			for (int j = bomb.length() - 1; j >= 0; j--) {
				if (s1.size() != 0 && s1.top() == bomb[j]) {
					char tmp = s1.top();
					s1.pop();
					s2.push(tmp);
				} else {
					isRemoved = false;
					break;
				}
			}
			if (isRemoved) {
				while (!s2.empty()) s2.pop();
			} else {
				while (!s2.empty()) {
					char tmp = s2.top();
					s2.pop();
					s1.push(tmp);
				}
			}
		}
	}
	if (s1.size() == 0) {
		cout << "FRULA";
	} else {
		while (!s1.empty()) {
			char tmp = s1.top();
			s1.pop();
			s2.push(tmp);
		}
		while (!s2.empty()) {
			char tmp = s2.top();
			s2.pop();
			cout << tmp;
		}
	}
	cout << '\n';
}
