#include <bits/stdc++.h>
using namespace std;


int main () {
    string s; cin >> s;
    for (char c : s) {
        if ((c-'0')%8==0) {
            cout << "YES\n" << c << "\n";
            return 0;
        }
    }
    for (int i = 0; i < s.size(); i++) {
        for (int j = i+1; j < s.size(); j++) {
            int l = (s[i]-'0')*10 + (s[j]-'0');
            if (l%8==0) {
                cout << "YES\n" << l << "\n";
                return 0;
            }
        }
    }
    for (int i = 0; i < s.size(); i++) {
        for (int j = i+1; j < s.size(); j++) {
            for (int k = j+1; k < s.size(); k++) {
                int l = (s[i]-'0')*100 + (s[j]-'0')*10 + (s[k]-'0');
                if (l%8==0) {
                    cout << "YES\n" << l << "\n";
                    return 0;
                }
            }
        }
    }
    cout << "NO\n";
}
