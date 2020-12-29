import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cf489c {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] build = new int[m];
		if (m==1) {
			if (s>=0 && s<=9) {
				System.out.println(s + " " + s);
			} else {
				System.out.println("-1 -1");
			}
			return;
		}
		if (s<1 || s>9*m) {
			System.out.println("-1 -1");
			return;
		}
//		if (s==1) {
//			System.out.println(10*(m-1) + " " + 10*(m-1));
//			return;
//		}
		int stopped = -1;
		int sum = 0;
		for (int i = 0; i < m; i++) {
			if (stopped!=-1) {
				build[i]=0;
			} else if (sum+9<=s) {
				sum+=9;
				build[i]=9;
				if (sum==s) {
					stopped=i;
				}
			} else {
				stopped = i;
				build[i]=s-sum;
			}
		}
		StringBuilder str = new StringBuilder();
		for (int i: build) {
			str.append(i);
		}
		String max = str.toString();
//		System.out.println(str);
		if (build[m-1]==0) {
//			System.out.println(build[stopped]-1);
			str.replace(stopped, stopped+1, String.valueOf(build[stopped] - 1));
//			System.out.println(str);
			str.deleteCharAt(m - 1);
//			System.out.println(str);
			str.append(1);
//			System.out.println(str);
		}
		str.reverse();
//		String min = str.toString();
//		System.out.println(min);
		System.out.println(str.toString()+" "+max);
	}
}
