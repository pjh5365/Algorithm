#include <bits/stdc++.h>
using namespace std;
int n;
int dp[50];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cin >> n;
	dp[1] = dp[2] = 1;
	for (int i = 3; i <= n; i++)
		dp[i] = dp[i - 1] + dp[i - 2];
	cout << dp[n] << '\n';
}
