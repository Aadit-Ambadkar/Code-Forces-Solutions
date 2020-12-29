import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cf466a {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if (m*a<=b) {
			System.out.println(n*a);
			return;
		}
		int maxTimes = n/m;
		int ans = 0;
		ans+=maxTimes*b;
		n-=maxTimes*m;
		ans += Math.min(n * a, b);
		System.out.println(ans);
	}
}
