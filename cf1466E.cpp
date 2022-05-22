#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MOD = 1000000007;

ll pw[60];

void solve() {
    int n; cin >> n;
    vector<ll> arr(n);
    vector<int> nwb(60);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        for (int j = 0; j < 60; j++) {
            if (arr[i]&(1LL<<j)) {
                nwb[j]++;
            }
        }
    }
    vector<ll> o(n), a(n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 60; j++) {
            if (arr[i]&(1LL<<j)) {
                a[i]+=(pw[j]*nwb[j])%MOD;
                a[i]%=MOD;
                o[i]+=(pw[j]*n)%MOD;
                o[i]%=MOD;
            } else {
                o[i]+=(pw[j]*nwb[j])%MOD;
                o[i]%=MOD;
            }
        }
    }
    ll ans = 0;
    for (int i = 0; i < n; i++) {
        ans+=(o[i]*a[i])%MOD;
        ans%=MOD;
    }
    cout << ans << "\n";
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    for (int i = 0; i < 60; i++) {
        pw[i]=(1LL<<i);
        pw[i]%=MOD;    
    }
    int t; cin >> t; while (t--) {solve();}
}