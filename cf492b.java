import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cf492b {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] lamps = new int[n];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) {
			lamps[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lamps);
		int max = 0;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, lamps[i]-lamps[i-1]);
		}
		max = Math.max(max, 2*lamps[0]);
		max = Math.max(max, 2*(l-lamps[n-1]));
		System.out.println(((double) max)/2);
	}
}
