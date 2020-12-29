import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cf25a {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] stuff = new int[n];
		int odd = 0;
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(st.nextToken());
			stuff[i] = next;
			if (next%2==1) {
				odd++;
			}
		}
		if (odd==1) {
			for (int i = 0; i < n; i++) {
				if (stuff[i]%2==1) {
					System.out.println(i+1);
					break;
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				if (stuff[i]%2==0) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}
