import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cf1b {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			String str = st.nextToken();
			Pattern pattern = Pattern.compile("R\\d+C\\d+");
			if (pattern.matcher(str).find()) {
				Pattern extract = Pattern.compile("[RC](\\d+)");
				int a = -1;
				int b = -1;
				Matcher matcher = extract.matcher(str);
				while (matcher.find()) {
					if (a==-1) {
						a=Integer.parseInt(matcher.group(1));
					} else {
						b=Integer.parseInt(matcher.group(1));
					}
				}
				String cname = "";
				int mod;
				while (b>0) {
					mod = (b-1)%26;
					char c = 'A';
					c+=mod;
					cname = c+cname;
					b = ((b-mod)/26);
				}
				System.out.println(cname+a);
			} else {
				Pattern extract = Pattern.compile("([A-Z]+)");
				Matcher matched = extract.matcher(str);
				String lets="";
				int row=0;
				if (matched.find()) {
					lets = matched.group(1);
				}
//				System.out.println(lets);
				extract = Pattern.compile("(\\d+)");
				matched = extract.matcher(str);
				if (matched.find()) {
					row = Integer.parseInt(matched.group(1));
				}
				int col = 0;
				for (char c: lets.toCharArray()) {
					int num = c-65;
					num++;
					col*=26;
					col+=num;
				}
//				System.out.println(col);
				System.out.println("R"+row+"C"+col);
			}
		}
	}
}
