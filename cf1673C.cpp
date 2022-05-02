#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const int MXN = 40003;
const int MOD = 1000000007;
int dp[MXN];
bool isP(int n) {
    int md = n;
    int k = 0;
    int tt = 1;
    while (md > 0) {
        k*=10;
        k += (md%10);
        md/=10;
    }
    // cout << k << " " << n;
    return k == n;
}

int main() {
    dp[0]=1;
    for (int inc = 1; inc < MXN; inc++) {
        if (isP(inc)) {
            for (int i = 0; i < MXN; i++) {
                if (dp[i]!=0) {
                    if (i+inc < MXN) {
                        dp[i+inc]+=dp[i];
                        dp[i+inc]%=MOD;
                    }
                }
            }
        }
    }
    // isP(12);
    int t; cin >> t;
    while (t--) {
        int n; cin >> n;
        cout << dp[n] << "\n";
    }
}