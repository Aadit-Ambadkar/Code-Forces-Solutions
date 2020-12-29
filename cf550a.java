import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cf550a {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		String str = st.nextToken();
		boolean ab = false;
		boolean ba = false;
		boolean aba =false;
		for (int i = 0; i < str.length(); i++) {
			if (!(i>=str.length()-2) && str.charAt(i)=='A' && str.charAt(i+1)=='B' && str.charAt(i+2)=='A') {
				if (ab || ba || aba) {
					ab=true;
					ba=true;
					break;
				}
				aba=true;
				i+=2;
			}
			else if (!(i>=str.length()-2) && str.charAt(i)=='B' && str.charAt(i+1)=='A' && str.charAt(i+2)=='B') {
				if (ab || ba || aba) {
					ab=true;
					ba=true;
					break;
				}
				aba=true;
				i+=2;
			}
			else if (i < str.length()-1 && str.charAt(i)=='A' && str.charAt(i+1)=='B' && !ab) {
				ab=true;
				if (aba) {
					ba=true;
					break;
				}
				i++;
			} else if (i < str.length()-1 && str.charAt(i)=='B' && str.charAt(i+1)=='A'&& !ba) {
				ba=true;
				if (aba) {
					ab=true;
					break;
				}
			}
			if (ab && ba) break;
		}
		if (ab && ba) System.out.println("YES");
		else System.out.println("NO");
	}
}
