import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cf431c {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		long[] noRes = new long[n+k];
		long[] withRes = new long[n+d-1];
		noRes[0]=1;
		withRes[0]=1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				noRes[i+j]+=noRes[i];
				noRes[i+j]%=1000000007;
			}
		}
//		System.out.println(Arrays.toString(noRes));
		if (d==1) {
			System.out.println(noRes[n]);
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < d; j++) {
				withRes[i+j]+=withRes[i];
				withRes[i+j]%=1000000007;
			}
		}
//		System.out.println(Arrays.toString(noRes));
//		System.out.println(Arrays.toString(withRes));
		long ans = (noRes[n]-withRes[n])%1000000007;
		if (ans<0) ans+=1000000007;
		System.out.println(ans);
	}
}
