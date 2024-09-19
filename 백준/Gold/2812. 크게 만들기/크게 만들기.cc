#include <bits/stdc++.h>
using namespace std;
int N, K;
string num;
stack<int> s1;
stack<int> s2;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> N >> K;
	cin >> num;
	for (int i = 0; i < num.length(); i++) {
		int now = num[i] - '0';
		while (!s1.empty() && K > 0 && s1.top() < now) {
			s1.pop();
			K--;
		}
		s1.push(now);
	}
	while (K > 0) {
		s1.pop();
		K--;
	}
	while (!s1.empty()) {
		s2.push(s1.top());
		s1.pop();
	}
	while (!s2.empty()) {
		cout << s2.top();
		s2.pop();
	}
	cout << '\n';
}
