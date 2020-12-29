import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cf1389c {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(f.readLine());
			String str = st.nextToken();
			int[] pref = new int[n+1];
			HashMap<Long, Long> groupCount = new HashMap<>();
			int[] groups = new int[n+1];
			int t = 1;
			int sum = 0;
			pref[0]=0;
			for (char c: str.toCharArray()) {
				int inte = c-'0';
				sum+=inte;
				pref[t]=sum;
				t++;
			}
			for (int j = 0; j < n+1; j++) {
				groups[j]=pref[j]-j;
			}
//			System.out.println(Arrays.toString(pref));
//			System.out.println(Arrays.toString(groups));
			for (int j = 0; j < n+1; j++) {
				if (groupCount.containsKey((long) groups[j])) groupCount.put((long) groups[j], groupCount.get((long) groups[j])+1);
				else groupCount.put((long) groups[j], (long) 1);
//				System.out.println(groupCount);
			}
			long ans = 0;
			for (Long j: groupCount.values()) {
				long th = j;
//				System.out.println(th);
				ans+=(th*(th-1))/2;
			}
			System.out.println(ans);
		}
	}
}
