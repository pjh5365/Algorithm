#include <bits/stdc++.h>
using namespace std;

int N;
string a;
long long b;
vector<short> cost;
int c;
int out;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    cost.reserve(N);
    while (N--) {
        cin >> a >> b;

        if (a == "jinju") {
            c = b;
        } 
        if (b > 1000) {
            out++;
        } else {
            cost.push_back(b);
        }
    }
    
    sort(cost.begin(), cost.end());
    cout << c << "\n";
    cout << (cost.size() - (upper_bound(cost.begin(), cost.end(), c) - cost.begin())) + out << "\n";
    return 0;
}