import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cf455a {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		long[] max = new long[100001];
		long[] c = new long[100001];
		Arrays.fill(c, 0);
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			c[a]++;
		}
		max[0]=0;
		max[1]=c[1];
		for (int i = 2; i < max.length; i++) {
			max[i]=Math.max(max[i-1], max[i-2]+i*c[i]);
		}
		System.out.println(max[max.length-1]);
		
		
	}
}
